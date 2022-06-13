public class Payment extends Schedule {
    /**
     * It's a function that will ask the user to enter the payment, and if the payment is greater than
     * or equal to the ticket price, it will print the change, and if the payment is less than the
     * ticket price, it will ask the user to enter the payment again
     */
    protected int getTotalAmount() {
        int totalAmount = (ticketInformation.get(ticketType).get(0) * ticketQuantity);
        return totalAmount;
    }
}
