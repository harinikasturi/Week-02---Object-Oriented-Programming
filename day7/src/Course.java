public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("Tech Academy");

        Course c1 = new Course("Java Programming", 8, 500);
        Course c2 = new Course("Web Development", 10, 700);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }

}
