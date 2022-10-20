package Data;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import Data.Key;

/**
 * Handle All operations on CSV.
 */
public class CSVData {  
    private ArrayList<Key> keys;
    
    public CSVData(String path) {
        // Open the file with the 'path' and read each row. Split each word by 
        // comma and save it into a string array. Each word is recorded as an
        // element in a Key object. Each Key object is added to an ArrayList obj.
        this.keys = new ArrayList<>();
        
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row = "";
            String[] data;
        
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
                Key key = new Key();
                key.setKeyName(data[0]);
                key.setUserName(data[1]);
                key.setEmail(data[2]);
                key.setPassword(data[3]);
                key.setWebsite(data[4]);
                key.setComments(data[5]);
                
                this.keys.add(key);
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
    
    public ArrayList getKeysList() {
        return this.keys;
    }
}
