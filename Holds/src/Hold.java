public class Hold {
    /**
     * Run the program
     */
    public static void main(String[] args){
        hold(args);
    }

    /**
     * Read in a .hold file
     */
    public static void hold(String[] args){
        // Check if there is exactly 1 argument
        if (args.length < 1){
            System.err.println("Not enough arguments, try giving a .hold file");
        }
        else if (args.length > 1){
            System.err.println("Too many arguments, try giving one .hold file");
        }
































    }

}
