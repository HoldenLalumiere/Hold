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

























    }

    private static void printErr(String error){
        System.err.println(error);
        System.exit(-1);
    }

}
