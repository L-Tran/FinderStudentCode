import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Logan Tran
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    public static final int EXTENDED_ASCII = 256;
    public static final long P = 29245776433644439L;
    private TST data;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Hash every Key
        // Put keys into TST with end node with value
        data = new TST();
        String line;
        String[] dataset = {};
        while((line = br.readLine()) != null) {
            dataset = line.split(",");
            data.insert(Long.toString(hash(dataset[keyCol])), dataset[valCol]);

        }
        br.close();
    }

    public static long hash(String s) {
        int length = s.length();
        long h = 0;
        // Preform Horner's Method
        for (int i = 0; i < length; i++) {
            h = (h * EXTENDED_ASCII + s.charAt(i)) % P;
        }
        return h;
    }

    public String query(String key){
        return data.search(Long.toString(hash(key)));
    }
}

