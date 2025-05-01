package Java_oops_worksheet_1;
class Animal{
    public void makeSound(){
        System.out.println("Sound making");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound(){
        super.makeSound();
        System.out.println("Meow-A cat sound");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound(){
        super.makeSound();
        System.out.println("Bhoo-Bhoo-A dog sound");
    }
}
public class Q9_Animal_Sounds {
    public static void main(String ar[]){
        Dog d1=new Dog();
        Cat c1=new Cat();
        d1.makeSound();
        c1.makeSound();
    }
}
