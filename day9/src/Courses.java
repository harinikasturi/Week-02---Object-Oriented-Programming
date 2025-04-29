import java.util.ArrayList;

class Courses {
    private String courseCode;
    private String title;
    private Professor professor;
    private ArrayList<Students> enrolledStudents;

    public Courses(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
        this.enrolledStudents = new ArrayList<Students>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
    }

    public void enrollStudent(Students student) {
        enrolledStudents.add(student);
        student.addCourse(this);
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseCode + " - " + title);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students (" + enrolledStudents.size() + "):");
        for (Students student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }
}

class Students {
    private String studentId;
    private String name;
    private ArrayList<Courses> enrolledCourses;

    public Students(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<Courses>();
    }

    public void addCourse(Courses course) {
        enrolledCourses.add(course);
    }

    public void enrollInCourse(Courses course) {
        course.enrollStudent(this);
    }

    public void displayCourses() {
        System.out.println(name + "'s enrolled courses:");
        for (Courses course : enrolledCourses) {
            System.out.println("- " + course.getCourseCode() + ": " + course.getTitle());
        }
    }

    public String getName() {
        return name;
    }
}

class Professor {
    private String professorId;
    private String name;
    private ArrayList<Courses> teachingCourses;

    public Professor(String professorId, String name) {
        this.professorId = professorId;
        this.name = name;
        this.teachingCourses = new ArrayList<Courses>();
    }

    public void addCourse(Courses course) {
        teachingCourses.add(course);
    }

    public void assignToCourse(Courses course) {
        course.assignProfessor(this);
    }

    public void displayTeachingSchedule() {
        System.out.println("Professor " + name + "'s courses:");
        for (Courses course : teachingCourses) {
            System.out.println("- " + course.getCourseCode() + ": " + course.getTitle());
        }
    }

    public String getName() {
        return name;
    }
}

class UniversityManagementDemo {
    public static void main(String[] args) {
        // Create professors
        Professor profSmith = new Professor("P100", "Dr. Smith");
        Professor profJohnson = new Professor("P101", "Dr. Johnson");

        // Create courses
        Courses cs101 = new Courses("CS101", "Introduction to Computer Science");
        Courses math201 = new Courses("MATH201", "Linear Algebra");
        Courses phys101 = new Courses("PHYS101", "Physics I");

        // Assign professors to courses
        profSmith.assignToCourse(cs101);
        Courses math101 = null;
        profJohnson.assignToCourse(math101);

        // Create students
        Students alice = new Students("S100", "Alice Brown");
        Students bob = new Students("S101", "Bob Green");
        Students charlie = new Students("S102", "Charlie White");

        // Enroll students in courses
        alice.enrollInCourse(cs101);
        alice.enrollInCourse(math201);
        bob.enrollInCourse(cs101);
        charlie.enrollInCourse(math201);
        charlie.enrollInCourse(phys101);

        // Display information
        cs101.displayCourseInfo();
        System.out.println();
        math201.displayCourseInfo();
        System.out.println();

        alice.displayCourses();
        System.out.println();
        profSmith.displayTeachingSchedule();
    }
}