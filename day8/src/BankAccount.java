public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", "John Doe");
        BankAccount account2 = new BankAccount("789012", "Jane Smith");

        account1.displayDetails();
        account2.displayDetails();
        BankAccount.getTotalAccounts();

        System.out.println(account1 instanceof BankAccount); // true
    }
}