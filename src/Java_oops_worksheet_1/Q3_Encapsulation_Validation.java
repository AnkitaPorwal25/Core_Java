package Java_oops_worksheet_1;
class BankAccount{
    private double balance;
    private String accountHolder;
    private String accountNumber;

    public void setBalance(double balance){
        if(balance>=0)
        this.balance=balance;
        else System.out.println("Enter valid amount");
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountHolder(){
        return accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
public class Q3_Encapsulation_Validation {
    public static void main(String ar[]){
        BankAccount account = new BankAccount();

        // Setting values
        account.setAccountHolder("Rohit Sharma");
        account.setAccountNumber("ACC123456789");
        account.setBalance(15000.50);

        // Invalid balance test
        account.setBalance(-500);  // Should trigger validation message

        // Getting and displaying values
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: ₹" + account.getBalance());
    }
}
