// ==============================
// TOPIC: STATIC KEYWORD
// ==============================

class Student {
    // static variable shared by all objects of Student
    static String school; // Class variable
    String name;          // Instance variable
}

public class StaticDemo {
    public static void main(String[] args) {
        // Assign static variable (class variable)
        Student.school = "JMV";

        // Create two students
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Meena";
        s2.name = "Beena";

        // Both see same school value because it's static
        System.out.println(s1.name + " goes to " + Student.school);
        System.out.println(s2.name + " goes to " + Student.school);
    }
}
