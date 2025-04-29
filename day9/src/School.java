import java.util.ArrayList;

class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Students at " + name + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void displayCourses() {
        System.out.println(name + "'s courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("Springfield High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        school.enrollStudent(student1);
        school.enrollStudent(student2);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        school.displayStudents();
        student1.displayCourses();
        student2.displayCourses();
        math.displayStudents();
        science.displayStudents();
    }
}