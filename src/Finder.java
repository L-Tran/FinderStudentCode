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

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        // Hash every Key
        // Put keys into TST with end node with value
        TST data = new TST();
        String line;
        String[] dataset = {};
        while((line = br.readLine()) != null) {
            dataset = line.split(",");
            data.insert(hash(dataset[keyCol]));

        }


        TST misspelledTST = new TST();
        ArrayList<String> misspelled = new ArrayList<>();
//        for(String word: text) {
//            if(!dict.search(word) && !misspelledTST.search(word)) {
//                misspelledTST.insert(word);
//                misspelled.add(word);
//            }
//        }
        misspelled.toArray(new String[misspelled.size()]);
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
        // TODO: Complete the query() function!
        return INVALID;
    }
}

