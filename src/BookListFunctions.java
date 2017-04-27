/**
 * Created by seandunn92 on 4/25/17.
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class BookListFunctions {


    static void searchBookByAuthor(ArrayList <Book> bookList, Scanner scan) {
        boolean found =false;
        System.out.println("Enter the author's name");
        String author = scan.nextLine();
        for (Book temp : bookList) {
            if (temp.getAuthor ().equals ( author )) {
                found = true;
                System.out.println ( temp );
            }
        }
        if(!found)
            System.out.println("Did not find the book");
    }

    //Method to search book by title
    static void searchBookByTitle(ArrayList <Book> bookList, Scanner scan) {
        System.out.println("Enter in the book's title");
        String title = scan.nextLine();
        boolean found = false;
        for (Book temp : bookList) {
            if (temp.getTitle ().equals ( title )) {
                System.out.println ( temp );
                found = true;
            }
        }
        if (!found)
            System.out.println("Did not  find the book");
    }

    public static void displayBooks(ArrayList <Book> bookList) { //taking in arraylist from library driver as param

        for (int i=0; i<bookList.size(); i++) {
            Book b = bookList.get(i);
            System.out.println("Book " + (i+1) + ": " +b);
        }

    }


    public static Book SelectBook(ArrayList<Book> bookList, Scanner scan){
        int bookSel;
        //the book returned to user;
        Book retBook =null;

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
            upDateDate(bookWanted);
            System.out.println("We have checked " + bookWanted.getTitle() +" to you! Due " + bookWanted.getDueDate());
        }


    }

    public static void upDateDate(Book bookWanted) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 14);

        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
        String output = sdf.format(c.getTime());
       bookWanted.setDueDate(output);
    }

    public static void ReturnBook(Book bookWanted){
        bookWanted.setBookStatus(Book.STATUS.ONSHELF);
        System.out.println("Thank You for returning " + bookWanted.getTitle());

    }
}
