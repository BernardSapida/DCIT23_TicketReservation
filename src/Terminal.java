import java.util.*;

public class Terminal {
    // Creating a new instance of the Payment class.
    protected static Payment payment = new Payment();
    
    public static void main(String[] args) throws Exception {
        payment.queryPayment();
        reserverTicket();
    }

    /**
     * It's a function that asks the user if he/she wants to buy another ticket. If yes, it will call
     * the queryPayment() function. If no, it will break the loop and print a message
     */
    private static void reserverTicket() {
        Scanner in = new Scanner(System.in);

        main: while(true) {
            System.out.println("\n###########################################################################################\n");
            System.out.print("Buy again (Y/N)? ");
            String response = in.nextLine();
        
            switch(response) {
                case "Y" -> { payment.queryPayment(); }
                case "N" -> { break main; }
                case default -> { 
                    System.out.println("Sorry, Ma'am/Sir! Your input is incorrect. Please try again!\n"); 
                }
            }
        }
        System.out.println("Thank you for buying tickets! Enjoy our band jamming session and we hope you'll like it ^_^.");
    }
}
