import java.util.ArrayList;

// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private ArrayList<String> medicalRecords;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalRecords = new ArrayList<>();
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Estimated Bill: $" + calculateBill());
    }

    // Encapsulated getters and setters
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    protected ArrayList<String> getMedicalRecords() { return medicalRecords; }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private static final double DAILY_RATE = 250.0;

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * DAILY_RATE;
    }

    // MedicalRecord interface implementation
    @Override
    public void addRecord(String record) {
        getMedicalRecords().add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : getMedicalRecords()) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private int numberOfVisits;
    private static final double VISIT_FEE = 75.0;

    public OutPatient(String patientId, String name, int age, int numberOfVisits) {
        super(patientId, name, age);
        this.numberOfVisits = numberOfVisits;
    }

    @Override
    public double calculateBill() {
        return numberOfVisits * VISIT_FEE;
    }

    // MedicalRecord interface implementation
    @Override
    public void addRecord(String record) {
        getMedicalRecords().add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : getMedicalRecords()) {
            System.out.println("- " + record);
        }
    }
}

class HospitalManagementSystem {
    public static void processPatients(Patient[] patients) {
        System.out.println("\nPatient Billing:");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord)patient).viewRecords();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create patients
        InPatient inPatient = new InPatient("P1001", "Alice Johnson", 35, 5);
        OutPatient outPatient = new OutPatient("P1002", "Bob Smith", 42, 3);

        // Add medical records
        inPatient.addRecord("Admitted for appendectomy");
        inPatient.addRecord("Post-surgery recovery - normal");

        outPatient.addRecord("Initial consultation");
        outPatient.addRecord("Follow-up visit 1");
        outPatient.addRecord("Follow-up visit 2");

        // Demonstrate polymorphism
        Patient[] patients = {inPatient, outPatient};
        processPatients(patients);
    }
}