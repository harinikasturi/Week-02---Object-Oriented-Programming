class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountType() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        super.displayAccountType();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        super.displayAccountType();
        System.out.println("Account Type: Checking");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    private int termMonths;

    public FixedDepositAccount(String accountNumber, double balance, int termMonths) {
        super(accountNumber, balance);
        this.termMonths = termMonths;
    }

    @Override
    public void displayAccountType() {
        super.displayAccountType();
        System.out.println("Account Type: Fixed Deposit");
        System.out.println("Term (Months): " + termMonths);
    }
}

class BankDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA001", 5000, 3.5);
        CheckingAccount checking = new CheckingAccount("CA001", 3000, 1000);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD001", 10000, 12);

        savings.displayAccountType();
        System.out.println();
        checking.displayAccountType();
        System.out.println();
        fixedDeposit.displayAccountType();
    }
}