import java.io.BufferedReader;
import java.io.IOException;

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
    public HashMap data;

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // Read every key and value into HashMap
        String line;
        String[] dataset = {};
        data = new HashMap();
        while((line = br.readLine()) != null) {
            dataset = line.split(",");
            data.add(dataset[keyCol], dataset[valCol]);
        }
        br.close();
    }


    public String query(String key){
        // Return the value at key
        if(data.get(key) != null) {
            return data.get(key);
        }
        else {
            return INVALID;
        }
    }
}

