package Java_oops_worksheet_1;

import java.util.ArrayList;
import java.util.List;

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
class Library{
    private ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }
}
public class Q1_Library_Booking {
    public static void main(String ar[]){
        Library library = new Library();


        library.addBook(new Book("My Will", "Karane", "893231231239"));
        library.addBook(new Book("Java Basics", "Sun", "112233445566"));

        List<Book> foundBooks = library.searchByTitle("My Will");
        if (!foundBooks.isEmpty()) {
            System.out.println("Books found with title 'My Will':");
            for (Book book : foundBooks) {
                book.print();
                System.out.println("-----");
            }
        } else {
            System.out.println("No books found with the title 'My Will'");
        }
    }
}