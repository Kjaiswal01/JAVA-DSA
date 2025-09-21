// ==================
// TOPIC: INHERITANCE
// ==================

public class OOPsInheritanceDemo {

    // ===== Single Inheritance =====
    static class Shape {
        public void area() {
            System.out.println("Displays Area of Shape");
        }
    }

    static class Triangle extends Shape {
        int base, height;

        Triangle() {
            // default constructor
            base = 0;
            height = 0;
        }

        Triangle(int b, int h) {
            base = b;
            height = h;
        }

        // Overloaded method
        public void area(int h, int b) {
            System.out.println("Triangle Area (method overloading): " + (0.5 * b * h));
        }

        // Override parent method
        @Override
        public void area() {
            System.out.println("Triangle Area (default) from Shape: " + (0.5 * base * height));
        }
    }

    // ===== Hierarchical Inheritance =====
    static class Circle extends Shape {
        int radius;

        Circle(int r) {
            radius = r;
        }

        @Override
        public void area() {
            System.out.println("Circle Area: " + (3.14 * radius * radius));
        }
    }

    // ===== Multilevel Inheritance =====
    static class EquilateralTriangle extends Triangle {
        int side;

        EquilateralTriangle(int s) {
            side = s;
        }

        @Override
        public void area() {
            double ar = (Math.sqrt(3) / 4) * side * side;
            System.out.println("Equilateral Triangle Area: " + ar);
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Single Inheritance =====");
        Triangle t = new Triangle(10, 5);
        t.area();           // overridden method
        t.area(10, 5);      // overloaded method

        System.out.println("\n===== Hierarchical Inheritance =====");
        Circle c = new Circle(3);
        c.area();           // overridden from Shape

        System.out.println("\n===== Multilevel Inheritance =====");
        EquilateralTriangle et = new EquilateralTriangle(6);
        et.area();          // overridden method in EquilateralTriangle
    }
}
