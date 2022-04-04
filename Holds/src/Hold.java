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
            System.err.println("Not enough arguments, try giving a .hold file");
            System.exit(-1);
        }
        else if (args.length > 1){
            System.err.println("Too many arguments, try giving one .hold file");
            System.exit(-1);
        }

        System.out.println(args[0]);
        String file = args[0];
        String[] splitFile = file.split("\\.");
        if (splitFile.length != 2) {
            System.err.println("File is not a .hold, try giving a .hold file");
            System.exit(-1);
        }

        String holdCheck = splitFile[1];
        System.out.println(holdCheck);
        if (!holdCheck.equals("hold")){
            System.err.println("File is not a .hold, try giving a .hold file");
            System.exit(-1);
        }

























    }

}
