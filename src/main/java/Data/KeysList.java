package Data;

import java.util.ArrayList;
import Data.Key;

/**
 * Class for store a list of Key objects and have special functions. 
 * 
 */
public class KeysList {
    private ArrayList<Key> list;
    
    public void KeysList() {
        this.list = new ArrayList<>();
    }
    
    public void add(Key key) {
        this.list.add(key);
    }
    
    public int size() {
        return this.list.size();
    }
}
