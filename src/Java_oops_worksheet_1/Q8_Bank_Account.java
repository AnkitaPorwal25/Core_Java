package Java_oops_worksheet_1;

class BankAccount1 {
    private String name;
    private double balance;
    private String type;
    private final String accountNumber;  // made final

    BankAccount1(String name, double balance, String type, String accountNumber) {
        this.name = name;
        this.balance = balance;
        this.type = type;
        this.accountNumber = accountNumber; // initialized once
    }

    public void updateBalance(double amount) {
        if (amount >= 0) balance = amount;
        else System.out.println("This is not a valid balance to be updated..");
    }

    public void getDetails() {
        System.out.println("Name: " + name +
                "\tBalance: " + balance +
                "\tType: " + type +
                "\tAccount Number: " + accountNumber);
    }
}

public class Q8_Bank_Account {
    public static void main(String ar[]) {
        BankAccount1 b = new BankAccount1("Ankita", 50000.90, "savings", "ACC987654321");
        b.getDetails();
        b.updateBalance(89000.90);
        System.out.println("Updated details:");
        b.getDetails();
    }
}
