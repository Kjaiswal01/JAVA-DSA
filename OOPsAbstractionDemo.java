// ================
// TOPIC: ABSTRACTION
// ================

// Abstract Class Example
abstract class Animal {
    abstract void walk(); // abstract method

    void breathe() {
        System.out.println("This animal breathes air");
    }

    Animal() {
        System.out.println("You are about to create an Animal.");
    }
}

class Horse extends Animal {
    Horse() {
        System.out.println("Wow, you have created a Horse!");
    }

    @Override
    void walk() {
        System.out.println("Horse walks on 4 legs");
    }
}

class Chicken extends Animal {
    Chicken() {
        System.out.println("Wow, you have created a Chicken!");
    }

    @Override
    void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
}

// Interface Example
interface AnimalInterface {
    void walk();
}

class HorseInterface implements AnimalInterface {
    @Override
    public void walk() {
        System.out.println("Horse walks on 4 legs");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {

        // Using Abstract Class
        Horse horse = new Horse();
        horse.walk();
        horse.breathe();

        // Using Interface
        HorseInterface hi = new HorseInterface();
        hi.walk();
    }
}
