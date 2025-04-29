import java.util.ArrayList;

class University {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void hireFaculty(Faculty faculty, String departmentName) {
        faculties.add(faculty);
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayStructure() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("- " + dept.getName());
            dept.displayFaculty();
        }
    }

    // When University is deleted, all Departments are deleted but Faculties can exist independently
}

class Departments{
    private String name;
    private ArrayList<Faculty> faculties;

    public Departments() {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public String getName() {
        return name;
    }

    public void displayFaculty() {
        for (Faculty faculty : faculties) {
            System.out.println("  - Faculty: " + faculty.getName() + ", Specialty: " + faculty.getSpecialty());
        }
    }
}

class Faculty {
    private String name;
    private String specialty;

    public Faculty(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}

class UniversityDemo {
    public static void main(String[] args) {
        University university = new University("State University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mathematics");

        Faculty faculty1 = new Faculty("Dr. Smith", "Artificial Intelligence");
        Faculty faculty2 = new Faculty("Dr. Johnson", "Data Structures");
        Faculty faculty3 = new Faculty("Dr. Williams", "Calculus");

        university.hireFaculty(faculty1, "Computer Science");
        university.hireFaculty(faculty2, "Computer Science");
        university.hireFaculty(faculty3, "Mathematics");

        university.displayStructure();

        // Faculty can exist without the university
        Faculty independentFaculty = new Faculty("Dr. Brown", "Physics");
        System.out.println("\nIndependent faculty: " + independentFaculty.getName());
    }
}