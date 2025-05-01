package Java_oops_worksheet_1;

import java.util.Formatter;

abstract class Employee{
    String name;
    String id;
    double salary;
    Employee(String name,String id,double salary){
            this.name=name;
            this.id=id;
            this.salary=salary;
    }
    abstract double calculateSalary();
    abstract void getDetails();
}
class FreeLancer extends Employee{
    FreeLancer(String name,String id,double salary){
        super(name,id,salary);
    }

    @Override
    public double calculateSalary(){
        return salary;
    }
    @Override
    public void getDetails(){
        System.out.println("FreeLancer Details");
        System.out.println("Name:"+name);
        System.out.println("FreeLanceriD:"+id);
        System.out.println("Salary:"+calculateSalary()+"\n");
    }
}
class FullTimeEmployee extends Employee{
    FullTimeEmployee(String name,String id,double salary){
        super(name,id,salary);
    }
    @Override
    public double calculateSalary(){
        return salary+ 10000; //10000 as appreciation amount
    }
    @Override
    public void getDetails(){
        System.out.println("FullTimeEmployee Details:");
        System.out.println("Name:"+name);
        System.out.println("FullTimeEmployeeiD:"+id);
        System.out.println("Salary:"+calculateSalary()+"\n");

    }
}
public class Q5_Employee_Payroll_System {
    public static void main(String ar[]){
        FullTimeEmployee f1=new FullTimeEmployee("Farhan","A101",45000.50);
        FreeLancer fl=new FreeLancer("Ankita","F114",110000.50);

        f1.getDetails();
        fl.getDetails();
    }
}
