/**
 * Created by seandunn92 on 4/25/17.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Book book1= new Book("Cinderella", "Disney", "None");
        System.out.println(book1.getTitle()  +", " + book1.getBookStatus() + ", " + book1.getDueDate());
        System.out.println(book1);
        Book book2 = new Book ("Snow White", "Edgar Alan Poe", "None");
        System.out.println(book2);
        System.out.println();

        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book ("Snow White2", "Edgar", "None"));
       // System.out.println(bookList.get(0));

        bookList.add(new Book("Harry Potter", "JK Rowling", "Today"));
        System.out.println(bookList);
        System.out.println("Welcome to Grand Circus Library");
        System.out.println("Please select from the following options:");
        System.out.println("1 - Display the entire list of books.");
        System.out.println("2 - Search for a book by author.");
        System.out.println("3 - Search for a book by title keyword.");
        System.out.println("4 - Select a book to check out.");
        System.out.println("5 - Return a book.");

        System.out.println("This is Trina");
        System.out.println ("Peter");
        System.out.println("Hi Peter this is Trina");


        System.out.println("Hi this is Sean Again");

        System.out.println ("Test - Peter");
        System.out.println ("last time - Peter - after Sean's changes");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();
    }
}
