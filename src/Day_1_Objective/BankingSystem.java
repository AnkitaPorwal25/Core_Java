package Day_1_Objective;

import java.util.ArrayList;
import java.util.Scanner;

// Interface remains the same
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
}

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Abstract bank account class
abstract class BankAccount implements Transaction {
    protected final String accountNumber;  // Made final
    private double balance;

    // Constructor for BankAccount class
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        setBalance(initialBalance);  // Using setter for validation
        System.out.println("BankAccount created with Account Number: " + accountNumber + " and Balance: " + balance);
    }

    public abstract void displayAccountDetails();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0)
            this.balance = balance;
        else
            System.out.println("Balance cannot be negative");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New Balance: " + balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

// Savings account class
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + " | Balance: " + getBalance() + " | Interest Rate: " + interestRate);
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest + ". New Balance: " + getBalance());
    }
}

// Main banking system
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SavingsAccount> accounts = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. List All Accounts");
            System.out.println("3. View Account Details");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Apply Interest");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create new account
                    System.out.print("Enter account number: ");
                    String accNum = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter interest rate (e.g. 0.05): ");
                    double rate = scanner.nextDouble();
                    accounts.add(new SavingsAccount(accNum, balance, rate));
                    break;

                case 2:
                    // List all accounts
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        System.out.println("Available Accounts:");
                        for (SavingsAccount acc : accounts) {
                            System.out.println("- " + acc.accountNumber);
                        }
                    }
                    break;


                case 3:
                    // View details
                    SavingsAccount accDetails = findAccount(accounts, scanner);
                    if (accDetails != null) accDetails.displayAccountDetails();
                    break;

                case 4:
                    // Deposit
                    SavingsAccount accDeposit = findAccount(accounts, scanner);
                    if (accDeposit != null) {
                        System.out.print("Enter deposit amount: ");
                        double amt = scanner.nextDouble();
                        accDeposit.deposit(amt);
                    }
                    break;

                case 5:
                    // Withdraw
                    SavingsAccount accWithdraw = findAccount(accounts, scanner);
                    if (accWithdraw != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amt = scanner.nextDouble();
                        try {
                            accWithdraw.withdraw(amt);
                        } catch (InsufficientFundsException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 6:
                    // Apply interest
                    SavingsAccount accInterest = findAccount(accounts, scanner);
                    if (accInterest != null) accInterest.applyInterest();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 7);

        scanner.close();
    }

    // Utility method to find account by account number
    private static SavingsAccount findAccount(ArrayList<SavingsAccount> accounts, Scanner scanner) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.print("Enter account number: ");
        String inputAcc = scanner.next();
        for (SavingsAccount acc : accounts) {
            if (acc.accountNumber.equals(inputAcc)) {
                return acc;
            }
        }

        System.out.println("Account not found.");
        return null;
    }
}
