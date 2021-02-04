import java.util.Scanner;

/**
 * Class that handles the command line inputs
 */
public class SecretSanta {

    /**
     * help command string
     */
    private final String HELP = "help";

    /**
     * add command string
     */
    private final String ADDNAME = "add";

    /**
     * remove command string
     */
    private final String REMOVENAME = "remove";

    /**
     * Creates mappings command string
     */
    private final String CREATE = "create-list";

    /**
     * Access a pick command
     */
    private final String ACCESS = "access";

    /**
     * Display the current list command
     */
    private final String DISPLAY = "display";

    /**
     * quit command
     */
    private final String QUIT = "quit";


    /**
     * Save command
     */
    private final String SAVE = "save";
    /**
     * Field holds the picker class
     */
    private SecretSantaPicker picker;

    public SecretSanta(SecretSantaPicker picker) {
        this.picker = picker;
    }

    /**
     * Helper function for the help command. Displays all commands
     */
    private void helperMessage() {
        System.out.println("add [name]: adds a name to list");
        System.out.println("help: this message");
        System.out.println("display: displays the people added to the list");
        System.out.println("remove [name]: removes name from the list");
        System.out.println("access [name]: once picker is executed, use this command to show who you got");
        System.out.println("create-list: will create the mappings once your list is finished");
        System.out.println("quit: will stop the program");
    }

    private void addName(String name) {
        picker.addName(name);
    }

    private void removeName(String name) {
        picker.removeName(name);
    }

    private String accessNameValue(String name) {
        return picker.getFinalList().get(name);
    }

    private void displayCurrentList() {
        for(String name : picker.getNames()) {
            System.out.println(name);
        }
    }

    private void executePicker() {
        picker.createMap();
        System.out.println("Successfully created secret santa mappings!");
    }


    private void saveMap(String filename) {
        picker.saveToFile(filename);
    }

    /**
     * Main loop that handles command prompt input.
     */
    public void commandLoop() {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Secret Santa. Please start inputting commands!");
        System.out.print("> ");
        boolean done = false;
        while(!done && in.hasNext()) {

            String line = in.nextLine();

            String fields[] = line.split("\\s+");

            switch(fields[0]) {
                case HELP:
                    helperMessage();
                    break;
                case ADDNAME:
                    addName(fields[1].toLowerCase());
                    break;
                case REMOVENAME:
                    removeName(fields[1].toLowerCase());
                    break;
                case ACCESS:
                    System.out.println(fields[1] + " got " + accessNameValue(fields[1].toLowerCase()) + " as their " +
                            "secret santa pick!");
                    break;
                case DISPLAY:
                    displayCurrentList();
                    break;
                case CREATE:
                    executePicker();
                    break;
                case SAVE:
                    saveMap(fields[1]);
                    break;
                case QUIT:
                    done = true;
                    break;
            }

            //reprompt
            if(done) {
                System.out.println("Goodbye!");
            } else {
                System.out.print("> ");
            }
        }

        in.close();

    }
}
