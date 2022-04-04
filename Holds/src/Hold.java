import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
            HashMap<String, Object> fields = new HashMap<>();

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

            // Go through the whole file
            while (line != null){
                System.out.println(line);

                //TODO maybe add in elses for these ifs that are error checks

                if (instance != true){
                    // If this line is the start of Class instance ({)
                    if (line.equals("{")){
                        instance = true;
                        continue;
                    }
                }
                else{
                    // This line is the last line of the instance, make the class instance
                    if (line.equals("}")){
                        instance = false;
                        // Make the class now
                        continue;
                    }

                    // The next line should be a field
                    else{
                        ArrayList<String> lines = new ArrayList<>(Arrays.asList(line.split("\"|:")));
                        for (int i = 0; i < lines.size(); i++) {
                            // Remove all blank entries
                            if (lines.get(i).equals("")) {
                                lines.remove(i);
                                i--;
                            }
                        }
                        //TODO remove this print
                        for (int i = 0; i < lines.size(); i++){
                            System.out.println("\t" + lines.get(i));
                        }

                        //TODO unhard code again
                        if (lines.get(0).equals("name")){
                            fields.put(lines.get(0), lines.get(1));
                            // If there are no more fields (no ,)
                            if (lines.size() == 2){
                                // TODO, next symbol should be }

                            }
                        }
                    }
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
