// File name: EncapsulationDemo.java

// ==============================
// TOPIC: ENCAPSULATION
// ==============================

// Account class with private data
class Account {
    private String name;
    private String email;

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }
}

// Main class
public class OOPsEncapsulationDemo {
    public static void main(String[] args) {
        Account acc = new Account();

        // Set values using setters
        acc.setName(" School Apna");
        acc.setEmail("hello@apnacollege.com");

        // Get values using getters
        System.out.println("Name: " + acc.getName());
        System.out.println("Email: " + acc.getEmail());
    }
}
