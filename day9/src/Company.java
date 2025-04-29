import java.util.ArrayList;

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void hireEmployee(String departmentName, String employeeName, String position) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addEmployee(new Employee(employeeName, position));
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            System.out.println("- Department: " + dept.getName());
            dept.displayEmployees();
        }
    }

    // When Company is deleted, all departments and employees are automatically deleted
}

class Department extends Departments {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        super();
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println("  - Employee: " + emp.getName() + ", Position: " + emp.getPosition());
        }
    }
}

class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}

class CompanyDemo {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions Inc.");

        company.addDepartment("Engineering");
        company.addDepartment("Marketing");

        company.hireEmployee("Engineering", "John Doe", "Software Engineer");
        company.hireEmployee("Engineering", "Jane Smith", "QA Engineer");
        company.hireEmployee("Marketing", "Alice Johnson", "Marketing Manager");

        company.displayStructure();
    }
}