public class HashMap {

    public static final int EXTENDED_ASCII = 256;
    public static final int DEFAULT_TABLE_SIZE = 997;

    int tableSize;
    int n;
    String[] keys;
    String[] values;

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        keys = new String[DEFAULT_TABLE_SIZE];
        values = new String[DEFAULT_TABLE_SIZE];
        n = 0;


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

    void add(String key, String value) {
        // Linear Probing
        n++;
        int keyHash = hash(key);
        while(keys[keyHash] != null) {
            if(keyHash == tableSize) {
                keyHash = 0;
            }
            else {
                keyHash++;
            }
        }
        keys[keyHash] = key;
        values[keyHash] = value;
    }

    String get(String key) {
        // return value of key
        int keyHash = hash(key);
        while(!keys[keyHash].equals(key)) {
            keyHash++;
        }
        return values[keyHash];

    }
    void resize() {
        String[]tempKeys = keys;
        String[]tempValues = values;
        if (n == tableSize / 2) {
            tableSize *= 2;
            keys =  new String[tableSize];
            values = new String[tableSize];
        }
        for(int i = 0 ; i < ) {

        }
    }

}
