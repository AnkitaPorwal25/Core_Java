package Day_1_Objective;

import java.util.Scanner;

// Interface for transaction operations
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
}

// Exception class for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


// Abstract class for a generic bank account
abstract class BankAccount implements Transaction {
    protected String accountNumber;
    private double balance;

    // Constructor for BankAccount class
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        setBalance(initialBalance);  // Using setter for validation
        System.out.println("BankAccount created with Account Number: " + accountNumber + " and Balance: " + balance);
    }

    // Abstract method to display account details
    public abstract void displayAccountDetails();

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative");
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method with exception handling
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Current Balance: " + balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds or invalid withdrawal amount");
        }
    }
}

// Concrete class for Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor for SavingsAccount class
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);  // Constructor chaining
        this.interestRate = interestRate;
        System.out.println("SavingsAccount created with Interest Rate: " + interestRate);
    }

    // Overriding method to display account details
    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account - Account Number: " + accountNumber + ", Balance: " + getBalance() + ", Interest Rate: " + interestRate);
    }

    // Method to apply interest
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest + ". New Balance: " + getBalance());
    }
}

// Main class to test the system with menu-driven approach
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount mySavings = new SavingsAccount("123456789", 1000.00, 0.05);

        int choice;

        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Interest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display account details
                    mySavings.displayAccountDetails();
                    break;
                case 2:
                    // Deposit amount
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    mySavings.deposit(depositAmount);
                    break;
                case 3:
                    // Withdraw amount
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        mySavings.withdraw(withdrawAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    // Apply interest
                    mySavings.applyInterest();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 5);  // Continue until the user selects "Exit"

        scanner.close();
    }
}
