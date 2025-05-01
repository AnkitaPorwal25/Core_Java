package Java_oops_worksheet_1;
class Book{
    private String title;
    private String author;
    private String ISBN;

    Book(String title,String author,String ISBN){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
    }

    public void print(){
        System.out.println("title:"+title);
        System.out.println("author:"+author);
        System.out.println("ISBN:"+ISBN);
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }
}
class Library extends Book{
    Library(String title,String author,String ISBN) {
        super(title, author, ISBN);
    }
}
public class Q1_Library_Booking {
    public static void main(String ar[]){
        Library lb=new Library("My will","Karane","893231231239");
        System.out.println(lb.getTitle());
    }
}