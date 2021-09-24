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
  private int totalMarks;
  private int numMarks;
  private double average;

  /**
   * The method with same name as class is used to instantiate an Object
   * 
   * COnstructor - same name as class, used to instantiate instance of the class
   */
  public Student(String name, String studentNumber, int grade) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = grade;
    this.totalMarks = 0;
    this.numMarks = 0;
    this.average = 0;
  }


  public Student(String name, String studentNumber) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = 9;
    this.totalMarks = 0;
    this.numMarks = 0;
    this.average = 0;
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

  public String getName(){
    return name;
  }

  //Method overloading - two methods with two signatures
  public void displayName(String greeting) {
    System.out.println(greeting + " " +name);
  }

  public void displayStudentNumber() {
    System.out.println(studentNumber);
  }


  /**
   * non-static methods do not have the word
   * non-static methods/attributes mean the method/attribute belongs to the objecty and not class
   */
  public void increaseGrade() {
    grade++;
  }

  public void displayGrade() {
    System.out.println(grade);
  }


  public void displayAverage() {
    System.out.println(average);
  }

  public double getAverage(){
    return average;
  }

  public void addTest(int mark) {
    numMarks++;
    totalMarks += mark;
    calculateAverage();

  }

  private void calculateAverage() {
    average = (double) totalMarks / numMarks;
  }
}