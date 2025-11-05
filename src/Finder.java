import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
//        hash each key, then add to the map
//        when necessary, double the table size
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
//        hash the key
//        if it is found, return its value
//        otherwise, return "INVALID KEY"
        if(data.get(hash(key)) != null) {
            return data.get(hash(key));
        }
        else {
            return INVALID;
        }
    }
}

