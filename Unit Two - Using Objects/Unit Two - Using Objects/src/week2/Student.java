package week2;

/*
 * A class is a blueprint for something we can model and create variables to use inour code.
 */
public class Student {
    /**
     *Attributes to define a student
     *State of a specific student is entailed in the attributes at a specific point.
     */
  private String name;
  private String studentNumber;
  private int grade;

  /**
   * The method with same name as class is used to instantiate an Object
   * 
   * COnstructor - same name as class, used to instantiate instance of the class
   */
  public Student(String name, String studentNumber, int grade) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = grade;
  }

  /**
   * displayName, displayStudentNumber, increaseGrade, displayGrade
   * The methods in a class define behaviour for the class
   * 
   * A void method performs a task and does not return a value
   */
  public void displayName() {
    System.out.println(name);
  }

  public void displayStudentNumber() {
    System.out.println(studentNumber);
  }

  public void increaseGrade() {
    grade++;
  }

  public void displayGrade() {
    System.out.println(grade);
  }

}