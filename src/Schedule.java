import java.util.*;

public class Schedule extends Ticket {
    protected String ticketType;
    protected int chosenSchedule;
    protected int ticketQuantity;
    protected HashMap<String, String[]> bandInformations = new HashMap<String, String[]>();

    // Initializing the HashMap.
    Schedule() {
        bandInformations.put("Economy", new String[] {"9AM", "1PM", String.valueOf(ticketInformation.get("Economy").get(1)), String.valueOf(ticketInformation.get("Economy").get(2))});
        bandInformations.put("VIP", new String[] {"9AM", "1PM", String.valueOf(ticketInformation.get("VIP").get(1)), String.valueOf(ticketInformation.get("VIP").get(2))});
    }

    /**
     * It asks the user to input a ticket type, and if the input is not 1 or 2, it will ask the user to
     * input again
     */
    protected void getTicketType() {
        Scanner in_getTicketType = new Scanner(System.in);
        System.out.println("\n###########################################################################################\n");

        System.out.print("Please enter the ticket type: ");
        int selectedTicket = in_getTicketType.nextInt();
        
        while(true) {
            if(selectedTicket == 1 || selectedTicket == 2) {
                if(selectedTicket == 1) ticketType = "Economy";
                if(selectedTicket == 2) ticketType = "VIP";
                break;
            } else {
                System.out.println("Sorry, Ma'am/Sir! Your input is incorrect. Please try again!\n");
                System.out.print("Please enter the ticket type: ");
                selectedTicket = in_getTicketType.nextInt();
            }
        }
    }

    /**
     * It gets the schedule of the ticket that the user wants to buy
     */
    protected void getSchedule() {
        Scanner in_getSchedule = new Scanner(System.in);

        main: while(true) {
            if(Integer.parseInt(bandInformations.get(ticketType)[2]) == 0 && Integer.parseInt(bandInformations.get(ticketType)[3]) == 0) {
                System.out.println("Sorry, Ma'am/Sir! All of the tickets for " + ticketType + " are being purchased. Please try another ticket!");
                getTicketType();
            } else {
                System.out.println("\n###########################################################################################\n");
                System.out.println("Pick a schedule:");
                System.out.println("A. 9AM (" + bandInformations.get(ticketType)[2] + " slots available)");
                System.out.println("B. 1PM (" + bandInformations.get(ticketType)[3] + " slots available)");
                System.out.print("Please enter the schedule: ");
                String schedule = in_getSchedule.nextLine();
                
                while(true) {
                    if(schedule.equals("A") || schedule.equals("B")) {
                        if(Integer.parseInt(bandInformations.get(ticketType)[2]) == 0 && schedule.equals("A")) {
                            System.out.println("Sorry, Ma'am/Sir! all of the tickets for " + ticketType + " 9AM are being purchased!\n");
                            System.out.print("Please enter the schedule: ");
                            schedule = in_getSchedule.nextLine();
                        } else if (Integer.parseInt(bandInformations.get(ticketType)[3]) == 0 && schedule.equals("B")) {
                            System.out.println("Sorry, Ma'am/Sir! all of the tickets for " + ticketType + " 1PM are being purchased!\n");
                            System.out.print("Please enter the schedule: ");
                            schedule = in_getSchedule.nextLine();
                        } else {
                            if(schedule.equals("A")) chosenSchedule = 2;
                            if(schedule.equals("B")) chosenSchedule = 3;
                            buyTicket();
                            break;
                        }
                    } else {
                        System.out.println("Sorry, Ma'am/Sir! Your input is incorrect. Please try again!\n");
                        System.out.print("Please enter the schedule: ");
                        schedule = in_getSchedule.nextLine();
                    }
                }
                
                break main;
            }
        }
    }

    /**
     * It asks the user for the number of tickets to buy, then checks if the number of tickets to buy
     * is greater than 0 and less than or equal to the number of tickets available. If it is, it will
     * subtract the number of tickets to buy from the number of tickets available and display the
     * summary. If not, it will ask the user to try again
     */
    protected void buyTicket() {
        Scanner in_buyTicket = new Scanner(System.in);
        System.out.println("\n###########################################################################################\n");
        
        System.out.print("No. of tickets to buy: ");
        int quantity = in_buyTicket.nextInt();
        
        while(true) {
            if(quantity > 0 && quantity <= Integer.parseInt(bandInformations.get(ticketType)[chosenSchedule])) {
                ticketQuantity = quantity;
                bandInformations.get(ticketType)[chosenSchedule] = String.valueOf(Integer.parseInt(bandInformations.get(ticketType)[chosenSchedule]) - ticketQuantity);
                setTicket(ticketType, quantity, chosenSchedule-1);
                displaySummary();
                break;
            } else {
                System.out.println("Sorry, Ma'am/Sir! we only have " + bandInformations.get(ticketType)[chosenSchedule] + " tickets available. Please try again!\n");
                System.out.print("No. of tickets to buy: ");
                quantity = in_buyTicket.nextInt();
            }
        }
    }

    /**
     * It displays the summary of the ticket purchase.
     */
    protected void displaySummary() {
        System.out.println("\n###########################################################################################\n");
        System.out.println("Summary:");
        System.out.println("Ticket type: " + ticketType);
        System.out.println("Schedule: " + ((chosenSchedule == 2) ? "9AM" : "1PM"));
        System.out.println("No. of tickets: " + ticketQuantity);
        System.out.println("Amount to pay: $" + (ticketInformation.get(ticketType).get(0) * ticketQuantity) + ".00");
    }
}
