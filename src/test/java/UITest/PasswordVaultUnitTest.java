package UITest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;

import UI.UI;
import Data.Key;
import Data.CSVData;

public class PasswordVaultUnitTest {
    static InputStream bais;
    static UI ui;
    public PasswordVaultUnitTest() {
                
    }
    
    @BeforeAll
    public static void setup() {
        CSVData data = new CSVData(System.getProperty("user.dir") + 
                                   "\\keys.txt");
        // Reassign the input stream. 
        bais = new ByteArrayInputStream(" ".getBytes());
        
        Scanner scan = new Scanner(bais);            
        ui = new UI(scan, data.getKeysList());  
        
    }
        
    @Test
    public void userInputTest() {
        // Number of keys in the list.
        Assertions.assertEquals(5,ui.getNumberOfKeys());
        
        // Assert on the first item data.
        Assertions.assertEquals("Amazon Prime",ui.getKey(0).getKeyName());
        Assertions.assertEquals("andrevier",ui.getKey(0).getUserName());
        Assertions.assertEquals("andrevier@outlook.com",ui.getKey(0).getEmail());
        Assertions.assertEquals("ubauba",ui.getKey(0).getPassword());
        Assertions.assertEquals("amazon.com",ui.getKey(0).getWebsite());
        Assertions.assertEquals("NA",ui.getKey(0).getComments());
    }
    
    
}
