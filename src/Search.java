import java.util.ArrayList;

/**
 * Created by PAS8 on 4/25/2017.
 */
public class Search {

    //Method to search book by author
    static void searchBookByAuthor(ArrayList <Book> bookList, String author) {
        for (Book temp : bookList) {
            if (temp.getAuthor ().equals ( author )) {
                System.out.println ( temp );
            }
        }
    }

    //Method to search book by title
    static void searchBookByTitle(ArrayList <Book> bookList, String title) {
        for (Book temp : bookList) {
            if (temp.getTitle ().equals ( title )) {
                System.out.println ( temp );
            }
        }
    }
}
