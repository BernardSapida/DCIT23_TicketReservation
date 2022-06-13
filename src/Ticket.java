import java.util.*;

public class Ticket {
    protected HashMap<String, ArrayList<Integer>> ticketInformation = new HashMap<String, ArrayList<Integer>>();

    // The constructor of the Ticket class. It is used to initialize the ticketInformation HashMap.
    Ticket() {
        ArrayList<Integer> economyInformations = new ArrayList<Integer>();
        ArrayList<Integer> vipInformations = new ArrayList<Integer>();

        economyInformations.add(20);
        economyInformations.add(10);
        economyInformations.add(10);

        vipInformations.add(100);
        vipInformations.add(10);
        vipInformations.add(10);

        ticketInformation.put("Economy", economyInformations);
        ticketInformation.put("VIP", vipInformations);
    }

    /**
     * This function is used to set the ticket quantity of a certain ticket type for a certain schedule
     * 
     * @param ticketType The type of ticket (Economy and VIP)
     * @param ticketQuantity The number of tickets the user wants to buy.
     * @param chosenSchedule the index of the schedule that the user has chosen
     */
    protected void setTicket(String ticketType, int ticketQuantity, int chosenSchedule) {
        ticketInformation.get(ticketType).set(chosenSchedule, ticketInformation.get(ticketType).get(chosenSchedule) - ticketQuantity);
    }

    /**
     * This function prints out the ticket options and their prices
     */
    protected void getTicket() {
        System.out.println("\n#################################################################################################################\n");
        System.out.println("Select a ticket:");
        System.out.println("1. Economy $" + ticketInformation.get("Economy").get(0) + ".00");
        System.out.println("2. VIP $" + ticketInformation.get("VIP").get(0) + ".00");
    }
}