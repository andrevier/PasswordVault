/*
 * Main UI class.
 */
package UI;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
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
            System.out.println("1 - Add a key");
            System.out.println("2 - Search for keys");
            System.out.println("3 - Exit");
            String word = this.scanner.nextLine();
            
            if (word.equals("3")) {
                System.out.println("Exit...");
                break;
            } else if (word.equals("1")) {
                this.addKey();
            } else if (word.equals("2")) {
                this.searchKeys();
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
    
    public void searchKeys() {
        // Search for the words in each key object.
        String words;
        ArrayList<Key> keyChoice = new ArrayList<Key>();
        String option = "";
        while (true) {
            // Search block: The search words must be case insensitive.
            System.out.print("Key words:");
            words = this.scanner.nextLine().toLowerCase();
            String keyData = "";
            int keyIndex = 0;
            for (Key item: this.keys) {
                keyData = item.toString().toLowerCase();
                
                // If contains the searched terms, keep the key object.
                if(keyData.contains(words)) {
                    keyChoice.add(item);
                    System.out.println(keyIndex + " - " + 
                            item.getKeyName());
                    keyIndex++;
                }  
            }
            
            if (keyChoice.isEmpty()) {
                System.out.println("(R) to return to the menu;" +
                                   " 'Enter' to search again.");
            } else {
                System.out.println("Select the number of the key;" + 
                                   " (R) for return to menu;" + 
                                   " 'Enter' to search again.");
            }
            
            option = this.scanner.nextLine();
                        
            if (option.equals("R")) {
                break;
            } else if (option.equals("") || option.equals(" ")) {
                // Case where the user wants to search again.
                System.out.println("");                
            } else {
                // Cases for valid numbers from the search keys on screen.
                int itemNumber = -1;
                boolean isNumber = true;
                
                // Test if it's a number.
                try {
                    itemNumber = Integer.parseInt(option);
                    isNumber = true;
                } catch (Exception e) {
                    itemNumber = -1;
                    isNumber = false;
                    System.out.println("not a number.");
                }
                // If is a valid number, get the key's name. 
                if (isNumber && ((keyIndex >= itemNumber) 
                                 && (0 <= itemNumber))) {
                    Key key = keyChoice.get(itemNumber);
                    
                    System.out.println(key.toString());
                }
            }
            // Empty the list to another round.
            keyChoice.clear();
        }
    }
}
