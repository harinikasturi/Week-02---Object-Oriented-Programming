public class Employee {
    private static String companyName = "Tech Corp";
    private static int totalEmployees = 0;
    private final String id;
    private String name;
    private String designation;

    public Employee(String id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("E001", "Alice", "Developer");
        Employee emp2 = new Employee("E002", "Bob", "Manager");

        emp1.displayDetails();
        Employee.displayTotalEmployees();

        System.out.println(emp1 instanceof Employee); // true
    }
}