/**
 * Created by seandunn92 on 4/25/17.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Method4 {
    public static void main(String[] args) {

        int selection;
        Book currBook;
        Scanner scan = new Scanner(System.in);

        System.out.println("Sean's driver");
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

        do {
            System.out.println("Welcome to Grand Circus Library");
            System.out.println("Please select from the following options:");
            System.out.println("1 - Display the entire list of books.");
            System.out.println("2 - Search for a book by author.");
            System.out.println("3 - Search for a book by title keyword.");
            System.out.println("4 - Select a book to check out.");
            System.out.println("5 - Return a book.");
            selection = scan.nextInt();
            scan.nextLine();

            switch (selection) {
                case 1:
                    Trina.displayBooks(bookList);
                    break;
                case 2:
                    Search.searchBookByAuthor(bookList, scan);
                    break;
                case 3:
                    Search.searchBookByTitle(bookList, scan);
                    break;
                case 4:
                    currBook = Method4.SelectBook(bookList, scan);
                    Method4.CheckOutBook(currBook);
                    break;
                default:
                    System.out.println("Error");
            }
            System.out.println();
        }while (true);
//        Scanner scan = new Scanner(System.in);
//        int selection;
//        Book currBook;
//        do {
//            currBook = SelectBook(bookList, scan);
//            CheckOutBook(currBook);
//        } while (true);

    }


    public static Book SelectBook(ArrayList<Book> bookList, Scanner scan){
        int bookSel;
        //the book returned to user;
        Book retBook =null;
        System.out.println("Please enter the book number you would like to check out");
        do {
            bookSel = scan.nextInt();
        }while (bookSel<1 || bookSel>bookList.size());
        retBook = bookList.get(bookSel-1);
        return retBook;
    }
    public static void CheckOutBook(Book bookWanted){
        if(bookWanted.getBookStatus()== Book.STATUS.CHECKEDOUT){
            System.out.println("Sorry that book was already checked out");
            return;
        }
        else{
            bookWanted.setBookStatus(Book.STATUS.CHECKEDOUT);
            System.out.println("We have checked the book out to you! Due in 2 weeks");
        }

    }
}
