// Loanable interface
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest: $" + calculateInterest());
    }

    // Encapsulated getters and setters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4%
    private double loanAmount;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    // Loanable interface implementation
    @Override
    public void applyForLoan(double amount) {
        if (amount > 0) {
            this.loanAmount = amount;
            System.out.println("Loan application for $" + amount + " submitted");
        }
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // Can loan up to 5 times the balance
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.01; // 1%

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class BankingSystem {
    public static void processAccounts(BankAccount[] accounts) {
        System.out.println("\nProcessing Accounts:");
        for (BankAccount account : accounts) {
            account.displayDetails();

            if (account instanceof Loanable) {
                System.out.println("Loan Eligibility: $" + ((Loanable)account).calculateLoanEligibility());
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create accounts
        SavingsAccount savings = new SavingsAccount("SA1001", "Alice Johnson", 5000);
        CurrentAccount current = new CurrentAccount("CA1001", "Bob Smith", 10000);

        // Demonstrate operations
        savings.deposit(1000);
        savings.withdraw(500);
        savings.applyForLoan(20000);

        current.deposit(2000);
        current.withdraw(1500);

        // Demonstrate polymorphism
        BankAccount[] accounts = {savings, current};
        processAccounts(accounts);
    }
}