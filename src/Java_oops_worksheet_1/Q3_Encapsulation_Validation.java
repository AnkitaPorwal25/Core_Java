package Java_oops_worksheet_1;

class BankAccount {
    private double balance;
    private String accountHolder;
    private final String accountNumber; // made final

    // Constructor to initialize accountNumber
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        if (balance >= 0)
            this.balance = balance;
        else
            System.out.println("Enter valid amount");
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class Q3_Encapsulation_Validation {
    public static void main(String ar[]) {
        // Provide accountNumber at the time of object creation
        BankAccount account = new BankAccount("ACC123456789");

        // Setting other values
        account.setAccountHolder("Rohit Sharma");
        account.setBalance(15000.50);

        // Invalid balance test
        account.setBalance(-500);  // Should trigger validation message

        // Getting and displaying values
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: ₹" + account.getBalance());
    }
}
