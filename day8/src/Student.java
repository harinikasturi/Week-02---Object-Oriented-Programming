public class Student {
    private static String universityName = "State University";
    private static int totalStudents = 0;
    private final String rollNumber;
    private String name;
    private String grade;

    public Student(String rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Student student1 = new Student("S001", "Tom", "A");
        Student student2 = new Student("S002", "Jerry", "B");

        student1.displayDetails();
        Student.displayTotalStudents();

        System.out.println(student1 instanceof Student); // true
    }
}