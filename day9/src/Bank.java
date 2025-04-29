import java.util.ArrayList;

class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialBalance) {
        customers.add(customer);
        customer.addAccount(this, initialBalance);
        System.out.println(customer.getName() + " opened an account with " + name + " with initial balance $" + initialBalance);
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Bank bank, double initialBalance) {
        accounts.add(new Account(bank, initialBalance));
    }

    public void viewBalances() {
        System.out.println(name + "'s account balances:");
        for (Account account : accounts) {
            System.out.println("- " + account.getBank().getName() + ": $" + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double initialBalance) {
        this.bank = bank;
        this.balance = initialBalance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

class BankDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("National Bank");
        Bank bank2 = new Bank("City Bank");

        Customer customer1 = new Customer("Alice Johnson");
        Customer customer2 = new Customer("Bob Smith");

        bank1.openAccount(customer1, 1000.0);
        bank2.openAccount(customer1, 500.0);
        bank1.openAccount(customer2, 2000.0);

        customer1.viewBalances();
        customer2.viewBalances();
    }
}