import java.util.*;

public class Terminal extends Payment {
    /**
     * It's a function that will ask the user to enter the payment, and if the payment is greater than
     * or equal to the ticket price, it will print the change, and if the payment is less than the
     * ticket price, it will ask the user to enter the payment again
     */
    protected void queryTerminal() {
        Scanner in_queryPayment = new Scanner(System.in);

        if(Integer.parseInt(bandInformations.get("Economy")[2]) == 0 && Integer.parseInt(bandInformations.get("Economy")[3]) == 0 && Integer.parseInt(bandInformations.get("VIP")[2]) == 0 && Integer.parseInt(bandInformations.get("VIP")[3]) == 0) {
            System.out.println("Sorry, Ma'am/Sir! all Economy tickets and VIP tickets are purchased by many people, we're sorry about it!");
        } else {
            super.getTicket();
            super.getTicketType();
            super.getSchedule();
            System.out.println("\n#################################################################################################################\n");
            System.out.print("Enter payment: ");
            int payment = in_queryPayment.nextInt();

            while(true) {
                if(payment >= (ticketInformation.get(ticketType).get(0) * ticketQuantity)) {
                    int change = payment - (ticketInformation.get(ticketType).get(0) * ticketQuantity);
                    System.out.println("Transaction successful, your change is: $" + change + ".00");
                    break;
                } else {
                    System.out.println("Sorry, Ma'am/Sir! you don't have enough balance to pay for " + ticketType + " tickets. Please try again!\n");
                    System.out.print("Enter payment: ");
                    payment = in_queryPayment.nextInt();
                }
            }
        }
    }

    /**
     * It asks the user if he/she wants to buy another ticket. If yes, it will call the queryTerminal()
     * function again. If no, it will break the loop and print a thank you message
     */
    protected void reserverTicket() {
        Scanner in = new Scanner(System.in);

        main: while(true) {
            System.out.println("\n#################################################################################################################\n");
            System.out.print("Buy again (Y/N)? ");
            String response = in.nextLine();
        
            switch(response) {
                case "Y" -> { queryTerminal(); }
                case "N" -> { break main; }
                case default -> { 
                    System.out.println("Sorry, Ma'am/Sir! Your input is incorrect. Please try again!\n"); 
                }
            }
        }
        System.out.println("Thank you for buying tickets! Enjoy our band jamming session and we hope you'll like it ^_^.");
    }
}
