// ==============================
// PACKAGE & ACCESS MODIFIERS DEMO
// ==============================

// Agar aap separate package use karna chahte ho, to uncomment this line
// package mypackage;  // <- package declaration must be first

// Account class (can be in a separate file in real projects)
class Account {
    public String name;       // accessible everywhere
    protected String email;   // accessible within same package & subclasses
    private String password;  // accessible only inside Account class

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for password
    public String getPassword() {
        return this.password;
    }
}

// Main class
public class OOPsPackageAccessDemo {
    public static void main(String[] args) {
        // Create object of Account
        Account a1 = new Account();

        // Access public variable
        a1.name = "Apna College";

        // Access protected variable (works here because same package)
        a1.email = "hello@apnacollege.com";

        // Access private variable via setter
        a1.setPassword("abcd");

        // Print details
        System.out.println("Name: " + a1.name);
        System.out.println("Email: " + a1.email);
        System.out.println("Password: " + a1.getPassword());
    }
}
