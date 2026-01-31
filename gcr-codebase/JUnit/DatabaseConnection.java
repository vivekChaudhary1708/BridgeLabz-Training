public class DatabaseConnection {

    private boolean connected = false;

    // Connect to database
    public void connect() {
        connected = true;
        System.out.println("Database connected");
    }

    // Disconnect from database
    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected");
    }

    // Check connection status
    public boolean isConnected() {
        return connected;
    }
}
