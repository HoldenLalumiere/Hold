import java.io.*;
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
        File f = new File(file);
        System.out.println(f.getAbsolutePath());
        try {
            // TODO figure out why it doesn't find the file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\h\\Documents\\GitHub\\Hold\\Holds\\src\\" + file));

            //Set variables used in reading
            boolean instance = false; //used to check if a class instance has started or not


            // Read the file
            String line = reader.readLine();
            // Check first line to see if it is the class name (Class)
            //TODO unhard code this
            if (!line.equals("TestClass")){
                printErr("Incorrect file format");
            }
            // If the next line is null then there is no class instance in the file
            line = reader.readLine();
            if (line == null){
                //TODO maybe add something here
                System.exit(0);
            }

            while (line != null){
                System.out.println(line);

                // If this line is the start of Class instance ({)
                if (line.equals("{") && instance != true){
                    instance = true;
                    continue;
                }

                // The next line should be either the first field
                if (line.equals("}") && instance == true){
                    instance = false;
                    // Make the class now
                    continue;
                }



                String[] lines = line.split("\\s+|\"");
                for (int i = 0; i < lines.length; i++) {
                    System.out.println("\t" + lines[i]);
                }





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
