package week9;

public class MorphismDriver {
    public static void main(String[] args) {
        /*
        NOT polymorphism
        Animal animal = new Animal();
        animal.makeSound();
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.makeSound();
        dog.makeSound();
        dog.chaseTail();
        */

        Animal animal = new Cat();
        animal.makeSound();
        animal = new Dog();
        animal.makeSound();

        ((Dog) animal).chaseTail();
    }
}
