/**
 * Created by seandunn92 on 4/25/17.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
       int selection;
       Scanner scan = new Scanner(System.in);

        ArrayList<Book> bookList = new ArrayList<Book>();
       FileFunctions.readFromFile("test.txt",bookList);


        do {
            promptUser();
            selection = scan.nextInt();
            scan.nextLine();

            //0 is the number we told the user would allow them to quit
            if(selection==0)
                break;

            PerfomActionBasedOnInput(selection, scan, bookList);
            System.out.println();
        }while (true);

        FileFunctions.writeToFile(bookList);


    }

    public static void promptUser() {
        System.out.println("Welcome to Grand Circus Library");
        System.out.println("Please select from the following options:");
        System.out.println("1 - Display the entire list of books.");
        System.out.println("2 - Search for a book by author.");
        System.out.println("3 - Search for a book by title keyword.");
        System.out.println("4 - Select a book to check out.");
        System.out.println("5 - Return a book.");
        System.out.println("0- quit and save");
    }

    public static void PerfomActionBasedOnInput(int selection, Scanner scan, ArrayList<Book> bookList) {
        Book currBook;
        switch (selection) {
            case 1:
                BookListFunctions.displayBooks(bookList);
                break;
            case 2:
                BookListFunctions.searchBookByAuthor(bookList, scan);
                break;
            case 3:
                BookListFunctions.searchBookByTitle(bookList, scan);
                break;
            case 4:
                System.out.println("Please enter the book number you would like to check out");
                currBook = BookListFunctions.SelectBook(bookList, scan);
                BookListFunctions.CheckOutBook(currBook);
                break;
            case 5:
                System.out.println("Please enter the book number you would like to return");
                currBook = BookListFunctions.SelectBook(bookList, scan);
                BookListFunctions.ReturnBook(currBook);
                break;
            default:
                System.out.println("Error");
        }
    }

}
