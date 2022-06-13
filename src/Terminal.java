import java.util.*;

public class Terminal {
    protected static Payment payment = new Payment();
    
    public static void main(String[] args) throws Exception {
        payment.queryPayment();
        reserverTicket();
    }

    private static void reserverTicket() {
        Scanner in = new Scanner(System.in);

        main: while(true) {
            System.out.print("Buy again (Y/N)? ");
            String response = in.nextLine();
        
            switch(response) {
                case "Y" -> { payment.queryPayment(); }
                case "N" -> { break main; }
                case default -> { System.out.println("Your input is incorrect. Please try again!\n"); }
            }
        }

        System.out.println("Thank you for buying tickets! Enjoy our band jamming session and we hope you'll like it ^_^.");
    }
}
