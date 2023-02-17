import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
    
        Movie[] movies = new Movie[] {
            new Movie("The Shawshank Redemption", "BlueRay", 9.2),
            new Movie("The Godfather", "BlueRay", 9.1),
            new Movie("The Godfather: Part II", "DVD", 9.0),
            new Movie("The Dark Knight", "BlueRay", 9.0),
            new Movie("Schindler's List", "DVD", 8.9),
            new Movie("The Lord of the Rings: The Return of the King", "BlueRay", 8.9),
            new Movie("Pulp Fiction", "DVD", 8.8),
            new Movie("The Lord of the Rings: The Fellowship of the Ring", "DVD", 8.8)
        };

        
        Store store = new Store(movies);

        store.setMovie(8, new Movie("Tenet", "BlueRay", 9.7));
        store.setMovie(9, new Movie("The Matrix", "DVD", 9.8));

        print(movies, store.getAllMovie(), true);

        String responce;
        System.out.print("\nPlease choose a number between 0 - 9: ");
        responce = scan.nextLine();

        int intResponce = checks(responce);

        while (intResponce < 0 || intResponce > (store.getAllMovie().length - 1)) {
            System.out.print("\nPlease choose a number between 0 - 9: ");
            responce = scan.nextLine();
            intResponce = checks(responce);
        }

        Movie movie = store.getMovie(intResponce);
        System.out.print("\nSet a new rating for " + movie.getName() + ": ");

        // CHECKS ABOUT DOUBLE
        // completare
        double rating = 0;
        try {
            rating = scan.nextDouble();
        } catch (Exception e) {
            System.out.println("ERRR");
        }


        store.setRatingInStore(intResponce, rating);
        System.out.println("\n" + store.getMovie(intResponce).getName() + " new rating is: " + store.getMovie(intResponce).getRating());
        
    }   

    /**
     * 
     * @param movies
     * @param inStore
     * @param isInStore
     */
    public static void print(Movie[] movies, Movie[] inStore, boolean isInStore){
        if (!isInStore) {
            gallery(movies, "COMING SOON");
        } else {
            gallery(inStore, "MOVIE STORE");
        }
    }

    /**
     * 
     * @param movies
     * @param label
     */
    public static void gallery(Movie[] movies, String label){
        System.out.println("\n" + "********************************" + label  + "*******************************" + "\n"
        );

        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i]);
        }
    }

    /**
     * 
     * @param responce
     * @return
     */
    public static int checks(String responce) {
        int intResponce;

        try {
            
            if (responce.isEmpty()) {
            
                responce = checkString(true, "You have not entered anything", responce, scan);

            } else if (responce.toLowerCase() == responce.toUpperCase()) {
           
                responce = checkString(false, "You entered a special character", responce, scan);
            }

            intResponce = Integer.parseInt(responce);

        } catch (Exception e) {

            System.out.print("\nInvalid Enter. You entered a letter.\nPlease enter a number between 0 - 9: ");
            responce = scan.nextLine();
            intResponce = checks(responce);

        }

        return intResponce;
    }

    /**
     * 
     * @param emptyResponce
     * @param advice
     * @param responce
     * @param scan
     * @return
     */
    public static String checkString(boolean emptyResponce, String advice, String responce, Scanner scan) {
        try {

            Integer.parseInt(responce);
            return responce;

        } catch (Exception e) {

            boolean check = true;

            while (check) {

                System.out.print("\nInvalid Enter." + advice + ". \nPlease choose a number between 0 - 9: ");
                responce = scan.nextLine();
    
                if (responce.isEmpty()) {
                    advice = "You have not entered anything";
                    check = breack(true, check, responce);

                } else if (!responce.isEmpty() && (responce.toLowerCase() != responce.toUpperCase()) && (responce.toUpperCase() != responce.toLowerCase())) {
                    advice = "You entered a letter";
                    check = breack(false, check, responce);

                } else if (!responce.isEmpty()) {
                    advice = "You entered a special character";
                    check = breack(false, check, responce);
                }
            } 
            return responce;
        }
    }

    /**
     * 
     * @param emptyResponce
     * @param check
     * @param responce
     * @return
     */
    public static boolean breack(boolean emptyResponce, boolean check, String responce){
        if (emptyResponce) {
            if (!responce.isEmpty()) {
                check = false;
            } 
            return check;
        } else {
            if ((responce.toLowerCase() != responce.toUpperCase()) && (responce.toUpperCase() != responce.toLowerCase())) {
                check = false;
            } else if (responce.toLowerCase() == responce.toUpperCase()) {
                try {
                    Integer.parseInt(responce);
                    check = false;
                } catch (Exception e) {
                    check = true;
                }
            }
            return check;
        }
    }
}
