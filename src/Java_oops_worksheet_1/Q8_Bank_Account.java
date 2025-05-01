package Java_oops_worksheet_1;
class BankAccount1{
    private String name;
    private double balance;
    private String type;

    BankAccount1(String name,double balance,String type){
        this.name=name;
        this.balance=balance;
        this.type=type;
    }

    public void updateBalance(double balance){
        this.balance=balance;
    }

    public void getDetails(){
        System.out.println("Name:"+name+"\tbalance:"+balance+"\ttype:"+type);
    }
}
public class Q8_Bank_Account {
    public static void main(String ar[]){
        BankAccount1 b=new BankAccount1("Ankita",50000.90,"savings");
        b.getDetails();
        b.updateBalance(89000.90);
        System.out.println("Updated details:");
        b.getDetails();
    }
}
