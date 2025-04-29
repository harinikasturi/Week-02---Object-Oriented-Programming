import java.util.ArrayList;

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayStaff() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getName() + ", Specialty: " + doctor.getSpecialty());
        }
    }
}

class Doctor {
    private String name;
    private String specialty;
    private ArrayList<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient, String notes) {
        patients.add(patient);
        patient.addConsultation(this, notes);
        System.out.println("Consultation notes: Dr. " + name + " saw " + patient.getName() + " about " + notes);
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void displayPatients() {
        System.out.println("Dr. " + name + "'s patients:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}

class Patient {
    private String name;
    private ArrayList<Consultation> consultations;

    public Patient(String name) {
        this.name = name;
        this.consultations = new ArrayList<>();
    }

    public void addConsultation(Doctor doctor, String notes) {
        consultations.add(new Consultation(doctor, notes));
    }

    public String getName() {
        return name;
    }

    public void displayConsultations() {
        System.out.println(name + "'s consultations:");
        for (Consultation consult : consultations) {
            System.out.println("- With Dr. " + consult.getDoctor().getName() + ": " + consult.getNotes());
        }
    }
}

class Consultation {
    private Doctor doctor;
    private String notes;

    public Consultation(Doctor doctor, String notes) {
        this.doctor = doctor;
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getNotes() {
        return notes;
    }
}

class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City General");

        Doctor doctor1 = new Doctor("Smith", "Cardiology");
        Doctor doctor2 = new Doctor("Johnson", "Neurology");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        Patient patient1 = new Patient("Alice Brown");
        Patient patient2 = new Patient("Bob Green");

        hospital.admitPatient(patient1);
        hospital.admitPatient(patient2);

        doctor1.consult(patient1, "heart palpitations");
        doctor2.consult(patient1, "migraine");
        doctor1.consult(patient2, "high blood pressure");

        hospital.displayStaff();
        System.out.println();
        doctor1.displayPatients();
        System.out.println();
        patient1.displayConsultations();
    }
}