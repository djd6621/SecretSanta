/**
 * Starts the application
 */
public class Application {

    /**
     * Creates a picker and a new secret and starts up the command line interface
     * @param args
     */
    public static void main(String[] args) {

        SecretSantaPicker picker = new SecretSantaPicker();

        SecretSanta santa = new SecretSanta(picker);

        santa.commandLoop();
    }

}
