import java.util.*;

public class Payment extends Schedule {
    // get the total amount to be paid.
    protected int totalAmount;

    /**
     * It's a function that will ask the user to enter the payment and if the payment is greater than
     * or equal to the ticket price, it will print the change
     */
    protected void queryPayment() {
        Scanner in_queryPayment = new Scanner(System.in);

        if(Integer.parseInt(bandInformations.get("Economy")[2]) == 0 && Integer.parseInt(bandInformations.get("Economy")[3]) == 0 && Integer.parseInt(bandInformations.get("VIP")[2]) == 0 && Integer.parseInt(bandInformations.get("VIP")[3]) == 0) {
            System.out.println("Sorry, Ma'am/Sir! all Economy tickets and VIP tickets are purchased by many people, we're sorry about it!");
        } else {
            super.getTicket();
            super.getTicketType();
            super.getSchedule();
            System.out.println("\n###########################################################################################\n");
            System.out.print("Enter payment: ");
            int payment = in_queryPayment.nextInt();

            while(true) {
                if(payment >= (ticketInformation.get(ticketType).get(0) * ticketQuantity)) {
                    totalAmount = payment - (ticketInformation.get(ticketType).get(0) * ticketQuantity);
                    System.out.println("Transaction successful, your change is: $" + totalAmount + ".00");
                    break;
                } else {
                    System.out.println("Sorry, Ma'am/Sir! you don't have enough balance to pay for " + ticketType + " tickets. Please try again!\n");
                    System.out.print("Enter payment: ");
                    payment = in_queryPayment.nextInt();
                }
            }
        }
    }
}
