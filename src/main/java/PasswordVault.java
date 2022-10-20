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
        Scanner scanner = new Scanner(System.in);
        UI userInterface = new UI(scanner);
        userInterface.start();    
       
    }
}
