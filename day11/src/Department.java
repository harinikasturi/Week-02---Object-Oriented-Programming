// Department interface
interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

// Abstract Employee class
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + (department != null ? department : "Not assigned"));
        System.out.println("Total Salary: $" + calculateSalary());
    }

    // Encapsulated getters and setters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) this.baseSalary = baseSalary;
    }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private double bonus;

    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    // Department interface implementation
    @Override
    public void assignDepartment(String department) {
        setDepartment(department);
    }

    @Override
    public String getDepartmentDetails() {
        return "Works in " + getDepartment() + " department (Full-Time)";
    }

    // Specific method for FullTimeEmployee
    public void setBonus(double bonus) {
        if (bonus >= 0) this.bonus = bonus;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, double hourlyRate) {
        super(employeeId, name, 0); // Base salary is 0 for part-time
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    // Department interface implementation
    @Override
    public void assignDepartment(String department) {
        setDepartment(department);
    }

    @Override
    public String getDepartmentDetails() {
        return "Works in " + getDepartment() + " department (Part-Time)";
    }

    // Specific methods for PartTimeEmployee
    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked >= 0) this.hoursWorked = hoursWorked;
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create employees
        FullTimeEmployee emp1 = new FullTimeEmployee("E1001", "John Doe", 5000);
        emp1.setBonus(1000);
        emp1.assignDepartment("Engineering");

        PartTimeEmployee emp2 = new PartTimeEmployee("E1002", "Jane Smith", 25);
        emp2.setHoursWorked(80);
        emp2.assignDepartment("Marketing");

        // Demonstrate polymorphism
        Employee[] employees = {emp1, emp2};

        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department)emp).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}