public class TestClass {
    // Creating a new instance of the Payment class.
    protected static Terminal terminal = new Terminal();
    
    public static void main(String[] args) throws Exception {
        terminal.queryTerminal();
        terminal.reserveTicket();
    }
}
