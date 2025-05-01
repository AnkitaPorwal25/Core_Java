package Java_oops_worksheet_1;
class Student{
    static int counter;
    private String name;
    private int id;

    Student(String name){
        this.name=name;
        counter++;
        this.id=counter;
    }

    public void displayStudent(){
        System.out.println(toString());
    }
    public String toString(){
        return "name="+name+" id="+id;
    }

    public static int totalStudentCount(){
        return counter;
    }
}
public class Q6_StudentRegistry {
    public static void main(String ar[]){
        Student s1=new Student("Ankita");
        Student s2=new Student("Diya");
        Student s3=new Student("Tiya");

        System.out.println(Student.totalStudentCount());
    }
}
