public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final String patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Name: " + name);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("P001", "Sarah", 30, "Fever");
        Patient patient2 = new Patient("P002", "David", 45, "Fracture");

        patient1.displayDetails();
        Patient.getTotalPatients();

        System.out.println(patient1 instanceof Patient); // true
    }
}