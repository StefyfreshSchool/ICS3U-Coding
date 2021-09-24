package week2;

public class StudentExample {
    public static void main(String[] args) {
        Student shohei;

        shohei = new Student("Shohei", "123456", 11);
        //shohei is a student

        Student samantha = new Student("Samantha", "654321", 11);
        /**
         * Objects store references to memory space, primitives store values
         */
        Student alan = shohei;
        /**
         * called (acticvated) the method increaseGrade
         * since alan and shohei reference the same object, one change affects the other
         */
        alan.increaseGrade();


        samantha.displayName();
        samantha.displayStudentNumber();
        samantha.increaseGrade();

        //Causes NullPointerException - cannot call method from a null reference.
        samantha = null;
        
        
        alan = new Student("Alan", "555555", 11);
        alan.addTest(87);
        alan.displayAverage();
        alan.addTest(92);
        alan.displayAverage();
        alan.addTest(96);
        alan.displayAverage();
        alan.addTest(67);
        alan.displayAverage();
        System.out.println(alan.getName() + " has an average of " + alan.getAverage());

        samantha = new Student("Samantha", "654321", 11);

    }
}