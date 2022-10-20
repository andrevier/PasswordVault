/*
 * Main UI class.
 */
package UI;
import java.util.Scanner;
import java.util.ArrayList;
import Data.Key;


public class UI {
    private Scanner scanner;
    private ArrayList<Key> keys;
        
    public UI(Scanner userInput) {
        this.scanner = userInput;
        this.keys = new ArrayList<>();
       
    }
    
    public UI(Scanner userInput, ArrayList keysList) {
        this.scanner = userInput;
        this.keys = keysList;
    }
       
    public void start() {
        // Start the user queries.
        while(true) {
            System.out.println("Password Vault");
            System.out.println("1 - Add a password");
            System.out.println("2 - Search keys");
            System.out.println("3 - Exit");
            String word = this.scanner.nextLine();
            
            if (word.contains("3")) {
                System.out.println("Exit...");
                break;
            } else if (word.contains("1")) {
                this.addKey();
            }            
            
        }
    }
    
    public void addKey() {
        // Add a new key to the list.
        Key item = new Key();
        String option;
        while (true) {
            System.out.println("Adding a password...");
            //0
            System.out.print("Key name: ");
            item.setKeyName(this.scanner.nextLine()); 
            //1
            System.out.print("User name: ");
            item.setUserName(this.scanner.nextLine());
            //2
            System.out.print("Email: ");
            item.setEmail(this.scanner.nextLine());
            //3
            System.out.print("Password: ");
            item.setPassword(this.scanner.nextLine());
            //4
            System.out.print("Website: ");
            item.setWebsite(this.scanner.nextLine());
            //5
            System.out.print("Any comments? ");
            item.setComments(this.scanner.nextLine());
            //6
            System.out.println("Return to menu (R); Save and return (S);");
            System.out.println("Re-type the keys (T); Save and add another key (A);");
            
            option = this.scanner.nextLine();
            
            if (option.equals("R")) {
                // Return without saving.
                System.out.println("");
                break;
            } else if (option.equals("S")) {
                // Save and return.
                this.keys.add(item);
                System.out.println("");
                break;
            } else if (option.equals("T")) {
                // Don't save and re-type.
                System.out.println("");
            } else if (option.equals("A")) {
                // Save and start the loop again.
                this.keys.add(item);
                //System.out.println("");
            }
            
        }       
        
    }
    
    public void newScanner(Scanner scan) {
        // New Scanner obj;
        this.scanner = scan;
    }
    
    public int getNumberOfKeys() {
            return this.keys.size();
        }
    
    public Key getKey(int number) {
        return this.keys.get(number);
    }
    
    public ArrayList<Integer> searchKeys() {
        // Look for the words in each key object.
        String words;
        ArrayList<Integer> positions = new ArrayList<>();
        while (true) {
            System.out.print("Key words:");
            words = this.scanner.nextLine();
            
            for (int i = 0; i < this.keys.size(); i++) {
                if(this.keys.get(i).contains(words)) {
                    positions.add(i);
                }
            }
            return positions;          
        }
    }
        
}
