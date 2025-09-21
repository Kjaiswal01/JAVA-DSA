// =================
// TOPIC: CONSTRUCTORS
// =================

public class OOPsConstructorsDemo {

    // Inner Student class
    static class Student {
        String name;
        int age;

        // 1. Non-parameterized constructor
        Student() {
            this.name = "Unknown"; // default value
            this.age = 0;          // default value
            System.out.println("Non-parameterized Constructor called");
        }

        // 2. Parameterized constructor
        Student(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("Parameterized Constructor called");
        }

        // 3. Copy constructor
        Student(Student s2) {
            this.name = s2.name;
            this.age = s2.age;
            System.out.println("Copy Constructor called");
        }

        // Method to display student details
        void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) {
        // Non-parameterized constructor
        Student s0 = new Student();
        s0.display();

        System.out.println("--------------------------");

        // Parameterized constructor
        Student s1 = new Student("Aman", 24);
        s1.display();

        System.out.println("--------------------------");

        // Copy constructor
        Student s2 = new Student(s1);
        s2.display();
    }
}
