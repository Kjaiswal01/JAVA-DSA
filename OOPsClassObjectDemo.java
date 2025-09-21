// ---------------------------
// CLASS AND OBJECTS DEMO
// ---------------------------

// A simple class Student with data members (properties) and a member function
class Student {
    String name;   // property: name of student
    int age;       // property: age of student

    // Member function to display info of this student
    public void getInfo() {
        System.out.println("The name of this Student is " + this.name);
        System.out.println("The age of this Student is " + this.age);
    }
}

// A second class Pen with a data member and a method
class Pen {
    String color; // property: color of pen

    public void printColor() {
        // prints color of this pen object
        System.out.println("The color of this Pen is " + this.color);
    }
}

// Main class where execution starts
public class OOPsClassObjectDemo {
    public static void main(String[] args) {
        // ---------------------------
        // Example 1: Student objects
        // ---------------------------
        Student s1 = new Student(); // create first student
        s1.name = "Aman";           // set name
        s1.age = 24;                // set age
        s1.getInfo();               // call member function to print details

        Student s2 = new Student(); // second student
        s2.name = "Shradha";
        s2.age = 22;
        s2.getInfo();

        // ---------------------------
        // Example 2: Pen objects
        // ---------------------------
        Pen p1 = new Pen(); // first pen
        p1.color = "blue";

        Pen p2 = new Pen(); // second pen
        p2.color = "black";

        Pen p3 = new Pen(); // third pen
        p3.color = "red";

        // call member function to print colors
        p1.printColor();
        p2.printColor();
        p3.printColor();
    }
}
