/**
 * Project to keep passwords.
 * 
 */
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;
import UI.UI;
import Data.CSVData;
import Data.Key;

public class PasswordVault {

    public static void main(String[] args) {
        CSVData data = new CSVData(System.getProperty("user.dir") + 
                                   "\\keys.txt");
        Scanner scanner = new Scanner(System.in);
        UI userInterface = new UI(scanner,data.getKeysList());
        userInterface.start();    
       
    }
}
