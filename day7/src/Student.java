public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    private String thesisTitle;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTitle) {
        super(rollNumber, name, CGPA);
        this.thesisTitle = thesisTitle;
    }

    public void displayPGStudentInfo() {
        System.out.println("PG Student Name: " + name);
        System.out.println("Thesis Title: " + thesisTitle);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "John Doe", 8.5, "AI in Healthcare");
        pg.displayStudentInfo();
        System.out.println();
        pg.displayPGStudentInfo();

        pg.setCGPA(9.0);
        System.out.println("\nUpdated CGPA: " + pg.getCGPA());
    }

}
