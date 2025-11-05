public class HashMap {

    public static final int EXTENDED_ASCII = 256;
    public static final long P = 29245776433644439L;
    public static final int DEFAULT_TABLE_SIZE = 2;

    int tableSize;
    int n;
    String[] keys;
    String[] values;

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;

    }


    public long hash(String s) {
        int length = s.length();
        long h = 0;
        // Preform Horner's Method
        for (int i = 0; i < length; i++) {
            h = (h * EXTENDED_ASCII + s.charAt(i)) % P;
        }
        return h;
    }

    void add(String key, String value) {
        // Linear Probing

    }
    String get(String key) {
        // return value of key

    }
    void resize() {
        tableSize *= 2;
    }

}
