public class HashMap {

    public static final int EXTENDED_ASCII = 256;
    public static final int DEFAULT_TABLE_SIZE = 997;

    int tableSize;
    // # of indices taken in current table
    int n;
    String[] keys;
    String[] values;

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        n = 0;
        keys = new String[DEFAULT_TABLE_SIZE];
        values = new String[DEFAULT_TABLE_SIZE];
    }

    public int hash(String s) {
        int length = s.length();
        int h = 0;
        // Preform Horner's Method
        for (int i = 0; i < length; i++) {
            h = (h * EXTENDED_ASCII + s.charAt(i)) % tableSize;
        }
        return h;
    }

    public void add(String key, String value) {
        // Resize table if halfway full
        if (n == tableSize / 2) {
            resize();
        }
        // Insert key and value and keyHash
        int keyHash = hash(key);
        // Shift index if keyHash spot is already taken
        while(keys[keyHash] != null) {
            keyHash = (keyHash + 1) % tableSize;
        }
        keys[keyHash] = key;
        values[keyHash] = value;
        n++;
    }

    public String get(String key) {
        int keyHash = hash(key);
        // while spot actually has a value
        while(keys[keyHash] != null) {
            // Compare to keys to ensure the correct value
            if(keys[keyHash].equals(key)) {
                return values[keyHash];
            }
            // Shift index if key @ keyHash spot is not correct
            keyHash = (keyHash + 1) % tableSize;
        }
        // Return null if key does not exist
        return null;
    }

    public void resize() {
        // Save old arrays
        String[]tempKeys = keys;
        String[]tempValues = values;
        // Double table size but add one to decrease  collisions (not multiple of 2)
        tableSize *= 2 + 1;
        keys =  new String[tableSize];
        values = new String[tableSize];
        // Reset current indices taken
        n = 0;
        // Re-add all old values to new Arrays
        for(int i = 0 ; i < tempKeys.length; i++) {
            if(tempKeys[i] != null) {
                add(tempKeys[i], tempValues[i]);
            }
        }
    }

}
