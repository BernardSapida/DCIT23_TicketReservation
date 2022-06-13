import java.util.*;

// shall contain the type and amount of each tickets through getter and setter method
public class Ticket {
    protected HashMap<String, ArrayList<Integer>> ticketInformation = new HashMap<String, ArrayList<Integer>>();

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

    protected void setTicket(String ticketType, int ticketQuantity, int chosenSchedule) {
        ticketInformation.get(ticketType).set(chosenSchedule, ticketInformation.get(ticketType).get(chosenSchedule) - ticketQuantity);
    }

    protected void getTicket() {
        System.out.println("\nSelect a ticket:");
        System.out.println("1. Economy $" + ticketInformation.get("Economy").get(0) + ".00");
        System.out.println("2. VIP $" + ticketInformation.get("VIP").get(0) + ".00");
    }
}