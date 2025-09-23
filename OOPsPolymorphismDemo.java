// ==================
// TOPIC: POLYMORPHISM
// ==================

public class OOPsPolymorphismDemo {

    // ==============================
    // Compile-time Polymorphism
    // ==============================
    static class Student {
        // Overloaded methods
        public void displayInfo(String name) {
            System.out.println("Name: " + name);
        }

        public void displayInfo(int age) {
            System.out.println("Age: " + age);
        }

        public void displayInfo(String name, int age) {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    // ==============================
    // Run-time Polymorphism
    // ==============================
    static class Shape {
        public void area() {
            System.out.println("Displays Area of Shape");
        }
    }

    static class Triangle extends Shape {
        int base, height;

        Triangle(int b, int h) {
            base = b;
            height = h;
        }

        @Override
        public void area() { // Correct overriding
            double ar = 0.5 * base * height;
            System.out.println("Triangle Area: " + ar);
        }
    }

    static class Circle extends Shape {
        int radius;

        Circle(int r) {
            radius = r;
        }

        @Override
        public void area() { // Correct overriding
            double ar = 3.14 * radius * radius;
            System.out.println("Circle Area: " + ar);
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Compile-time Polymorphism (Overloading) =====");
        Student s = new Student();
        s.displayInfo("Aman");
        s.displayInfo(24);
        s.displayInfo("Shradha", 22);

        System.out.println("\n===== Run-time Polymorphism (Overriding) =====");
        Shape t = new Triangle(10, 5); // Parent reference → child object
        t.area(); // Triangle area

        Shape c = new Circle(3); // Parent reference → child object
        c.area(); // Circle area
    }
}
