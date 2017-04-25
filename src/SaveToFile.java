import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by PAS8 on 4/25/2017.
 */
public class SaveToFile {
    public static void main(String[] args) {

        //Ensure file exist or create one
        createFile ("test.txt");

        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book ("Snow White2", "Edgar", "None"));
        writeToFile(bookList);
    }

    //Create file method
    static void createFile(String fileString) {
        Path filePath = Paths.get (fileString );
        System.out.println (filePath);

        if (Files.notExists ( filePath )) {
            System.out.println ( Files.notExists ( filePath ) );
            try {
                Files.createFile ( filePath );
            } catch (IOException e) {
                //e.printStackTrace ();
                System.out.println ( "There was an error: " + e );
            }
        }
    }

    static void writeToFile(ArrayList <Book> bookList) {
        //Reference filename and pate
        Path filePath = Paths.get ("text.txt");
        File fileName = filePath.toFile ();

        try {
            // Assume default encoding.
            PrintWriter fileWriter = new PrintWriter ( new FileOutputStream ( fileName, true ) );

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter ( fileWriter );

            // Note that write() does not automatically
            // append a newline character.
            for (Book temp: bookList) {
                    bufferedWriter.write (temp.getAuthor ());
                    bufferedWriter.write (temp.getTitle ());
            };
            bufferedWriter.newLine ();
            System.out.println ("This country has been saved!");

            // Always close files.
            bufferedWriter.close ();
        } catch (IOException e) {
            //e.printStackTrace ();
            System.out.println ( "There was an error: " + e );
        }
    }
}
