public class HashMap {

    public static final int EXTENDED_ASCII = 256;
    public static final int DEFAULT_TABLE_SIZE = 997;

    int tableSize;
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
        // Linear Probing
        if (n == tableSize / 2) {
            resize();
        }
        int keyHash = hash(key);
        while(keys[keyHash] != null) {
            keyHash = (keyHash + 1) % tableSize;
        }
        keys[keyHash] = key;
        values[keyHash] = value;
        n++;
    }

    public String get(String key) {
        // return value of key
        int keyHash = hash(key);
        while(keys[keyHash] != null) {
            if(keys[keyHash].equals(key)) {
                return values[keyHash];
            }
            keyHash = (keyHash + 1) % tableSize;
        }
        return null;
    }
    public void resize() {
        String[]tempKeys = keys;
        String[]tempValues = values;
        tableSize *= 2 + 1;
        keys =  new String[tableSize];
        values = new String[tableSize];
        n = 0;
        for(int i = 0 ; i < tempKeys.length; i++) {
            if(tempKeys[i] != null) {
                add(tempKeys[i], tempValues[i]);
            }
        }
    }

}
