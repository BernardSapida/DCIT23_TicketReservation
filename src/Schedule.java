import java.util.*;

public class Schedule extends Ticket {
    // shall contain the time, available slot. and contain the ticket type from Tickets class
    protected String ticketType;
    protected int chosenSchedule;
    protected int ticketQuantity;
    protected HashMap<String, String[]> bandInformations = new HashMap<String, String[]>();

    Schedule() {
        bandInformations.put("Economy", new String[] {"9AM", "1PM", String.valueOf(ticketInformation.get("Economy").get(1)), String.valueOf(ticketInformation.get("Economy").get(2))});
        bandInformations.put("VIP", new String[] {"9AM", "1PM", String.valueOf(ticketInformation.get("VIP").get(1)), String.valueOf(ticketInformation.get("VIP").get(2))});
    }

    protected void getTicketType() {
        Scanner in_getTicketType = new Scanner(System.in);

        System.out.print("Ticket: ");
        int selectedTicket = in_getTicketType.nextInt();
        
        while(true) {
            if(selectedTicket == 1 || selectedTicket == 2) {
                if(selectedTicket == 1) ticketType = "Economy";
                if(selectedTicket == 2) ticketType = "VIP";
                break;
            } else {
                System.out.println("Your input is incorrect. Please try again!\n");
                System.out.print("Enter your ticket type: ");
                selectedTicket = in_getTicketType.nextInt();
            }
        }
    }

    protected void getSchedule() {
        Scanner in_getSchedule = new Scanner(System.in);

        main: while(true) {
            if(Integer.parseInt(bandInformations.get(ticketType)[2]) == 0 && Integer.parseInt(bandInformations.get(ticketType)[3]) == 0) {
                System.out.println("All of the tickets for " + ticketType + " are being sold. Please try another ticket!\n");
                getTicketType();
            } else {
                System.out.println("\nPick a schedule:");
                System.out.println("A. 9AM (" + bandInformations.get(ticketType)[2] + " slots available)");
                System.out.println("B. 1PM (" + bandInformations.get(ticketType)[3] + " slots available)");
                System.out.print("Schedule: ");
                String schedule = in_getSchedule.nextLine();
                
                while(true) {
                    if(schedule.equals("A") || schedule.equals("B")) {
                        if(Integer.parseInt(bandInformations.get(ticketType)[2]) == 0 && schedule.equals("A")) {
                            System.out.println("Sorry, all of the ticket for " + ticketType + " 9AM are being sold!\n");
                            System.out.print("Enter your schedule: ");
                            schedule = in_getSchedule.nextLine();
                        } else if (Integer.parseInt(bandInformations.get(ticketType)[3]) == 0 && schedule.equals("B")) {
                            System.out.println("Sorry, all of the ticket for " + ticketType + " 1PM are being sold!\n");
                            System.out.print("Enter your schedule: ");
                            schedule = in_getSchedule.nextLine();
                        } else {
                            if(schedule.equals("A")) chosenSchedule = 2;
                            if(schedule.equals("B")) chosenSchedule = 3;
                            buyTicket();
                            break;
                        }
                    } else {
                        System.out.println("Your input is incorrect. Please try again!\n");
                        System.out.print("Enter your schedule: ");
                        schedule = in_getSchedule.nextLine();
                    }
                }
                
                break main;
            }
        }
    }

    protected void buyTicket() {
        Scanner in_buyTicket = new Scanner(System.in);
        
        System.out.print("\nNo. of tickets to buy: ");
        int quantity = in_buyTicket.nextInt();
        
        while(true) {
            if(quantity > 0 && quantity <= Integer.parseInt(bandInformations.get(ticketType)[chosenSchedule])) {
                ticketQuantity = quantity;
                bandInformations.get(ticketType)[chosenSchedule] = String.valueOf(Integer.parseInt(bandInformations.get(ticketType)[chosenSchedule]) - ticketQuantity);
                setTicket(ticketType, quantity, chosenSchedule-1);
                displaySummary();
                break;
            } else {
                System.out.println("Sorry, we only have " + bandInformations.get(ticketType)[chosenSchedule] + " tickets available. Please try again!\n");
                System.out.print("Enter ticket quantity: ");
                quantity = in_buyTicket.nextInt();
            }
        }
    }

    protected void displaySummary() {
        System.out.println("\nSummary:");
        System.out.println("Ticket type: " + ticketType);
        System.out.println("Schedule: " + ((chosenSchedule == 2) ? "9AM" : "1PM"));
        System.out.println("No. of tickets: " + ticketQuantity);
        System.out.println("Amount to pay: $" + (ticketInformation.get(ticketType).get(0) * ticketQuantity) + ".00");
    }
}
