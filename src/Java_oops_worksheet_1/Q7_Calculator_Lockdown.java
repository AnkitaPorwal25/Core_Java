package Java_oops_worksheet_1;
class BasicCalculator{
    final int addInt(int a,int b){
        return a+b;
    }
}
class SmartCalculatorClass extends BasicCalculator{
//    @Override
//    public int addInt(int a,int b){
//        return a-b;
//    }
    public int subtract(int a,int b){
        return a-b;
    }
}
public class Q7_Calculator_Lockdown {
    public static void main(String ar[]){
        SmartCalculatorClass sb=new SmartCalculatorClass();
        int x=sb.addInt(10,20);
        int y=sb.subtract(20,30);
        System.out.println("x="+x);
        System.out.println("y="+y);
    }
}
