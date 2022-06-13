import java.util.*;

public class Payment extends Schedule {
    // get the total amount to be paid.
    protected int totalAmount;

    protected void queryPayment() {
        Scanner in_queryPayment = new Scanner(System.in);

        if(Integer.parseInt(bandInformations.get("Economy")[2]) == 0 && Integer.parseInt(bandInformations.get("Economy")[3]) == 0 && Integer.parseInt(bandInformations.get("VIP")[2]) == 0 && Integer.parseInt(bandInformations.get("VIP")[3]) == 0) {
            System.out.println("Sorry, all of the tickets are being sold for both Economy and VIP!\n");
        } else {
            super.getTicket();
            super.getTicketType();
            super.getSchedule();

            System.out.print("\nEnter payment: ");
            int payment = in_queryPayment.nextInt();

            while(true) {
                if(payment >= (ticketInformation.get(ticketType).get(0) * ticketQuantity)) {
                    System.out.println("Transaction successful, your change is: $" + (payment - (ticketInformation.get(ticketType).get(0) * ticketQuantity)) + ".00");
                    break;
                } else {
                    System.out.println("Sorry, you don't have enough balance to pay for " + ticketType + " tickets. Please try again!\n");
                    System.out.print("Enter payment: ");
                    payment = in_queryPayment.nextInt();
                }
            }
        }
    }
}
