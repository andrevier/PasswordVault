/**
 * Each item of the Password Valt is a key. The Key class has all possible 
 * information from the keys as well as edition and access of the data.
 * 
 */

package Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Key {
    private String keyName;
    private String userName;
    private String email;
    private String password;
    private String website;
    private String comments;
    private Pattern pattern;
    private Matcher matcher;
    
    public void setKeyName(String key) {
        this.keyName = avoidNull(key);
    }
    
    public String getKeyName() {
        return this.keyName;
    }
    
    public void setUserName(String name) {
        this.userName = avoidNull(name);
    }
    
    public String getUserName() {
       return this.userName;
    }
    
    public void setEmail(String email) {
        this.email = avoidNull(email);
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setPassword(String pswd) {
        this.password = avoidNull(pswd);
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setWebsite(String website) {
        this.website = avoidNull(website);
    }
    
    public String getWebsite() {
        return this.website;
    }
    
    public void setComments(String comments) {
        this.comments = avoidNull(comments);
    }
    
    public String getComments() {
        return this.comments;
    }
    
    public static String avoidNull(String answer) {
        // Avoid an empty string or a blank space response by changing it to 
        // NA - Not Available.
        if (answer.isEmpty() || answer.isBlank()) {
            return "NA";
        } else
            return answer;
    }
    
    public String toString() {
        // Return a string with all the variables but the password.
        String text = this.keyName + "%s" + this.userName + "%s" + 
        this.email + "%s" + this.website +"%s"+ this.comments;
        return String.format(text,System.lineSeparator(),
                System.lineSeparator(),System.lineSeparator(),
                System.lineSeparator());
        
    }
    
    public boolean contains(String term) {
        // Returns true if the key has the char sequence 'term' among their 
        // data. Otherwise, returns false.
        this.pattern = Pattern.compile(term, Pattern.CASE_INSENSITIVE);
        this.matcher = this.pattern.matcher(this.toString());
        return this.matcher.find();                    
    }
}


