import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Hold {
    /**
     * Run the program
     */
    public static void main(String[] args){
        hold(args);
    }

    /**
     * Read in a .hold file
     *
     * @param args the arguments from main, it should be 1 .hold file
     */
    public static void hold(String[] args){
        // Check if there is exactly 1 argument
        if (args.length < 1){
            printErr("Not enough arguments, try giving a .hold file");
        }
        else if (args.length > 1){
            printErr("Too many arguments, try giving one .hold file");
        }

        // Check if it is a . file
        String file = args[0];
        String[] splitFile = file.split("\\.");
        if (splitFile.length != 2) {
            printErr("File is not a .hold, try giving a .hold file");
        }

        // Check if it is a .hold file
        String holdCheck = splitFile[1];
        if (!holdCheck.equals("hold")){
            printErr("File is not a .hold, try giving a .hold file");
        }

        //TODO check if there should be more error checks

        // Read in the file
        readHold(file);
    }

    /**
     * Read in the .hold file
     *
     * @param file the .hold to read
     */
    private static void readHold(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Read the file
            String line = reader.readLine();
            while (line != null){
                System.out.println(line);



                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            printErr("FileNotFoundException, File does not exist");
        } catch (IOException e) {
            printErr("IOException");
        }
    }

    /**
     * Prints and error to err
     *
     * @param error the string of what went wrong to print
     */
    private static void printErr(String error){
        System.err.println(error);
        System.exit(-1);
    }

}
