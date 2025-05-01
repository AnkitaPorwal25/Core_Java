package Java_oops_worksheet_1;

import java.util.ArrayList;

class Shape{
    public void draw(){
        System.out.println("Draw shape");
    }
}
class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Circle right now");
    }
}
class Square extends Shape{
    public void draw(){
        System.out.println("Drawing Square right now");
    }
}
class Triangle extends Shape{
    public void draw(){
        System.out.println("Drawing Triangle right now");
    }
}
public class Q4_Drawing_App {
    public static void main(String ar[]){
        ArrayList<Shape>al=new ArrayList<>();
        al.add(new Square());
        al.add(new Triangle());
        al.add(new Circle());
        for(Shape x:al){
            x.draw();
        }
    }
}
