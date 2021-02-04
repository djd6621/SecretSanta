 import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Class handles the logic behind assigning a name to a name
 */
public class SecretSantaPicker {

    private final ArrayList<String> names = new ArrayList<>();

    /**
     * Copy of list to hold names not chosen
     */
    private ArrayList<String> namesAvailable;

    private HashMap<String, String> finalList = new HashMap<>();

    public SecretSantaPicker() {}

    /**
     * Runs through the list and creates key, value pairs for mapping.
     */
    public void createMap() {
        namesAvailable = new ArrayList<>(names);

        for(int i = 0; i < names.size(); i++) {
            String firstPerson = names.get(i);

            int randomNum = randomGenerator(namesAvailable.size() - 1);
            String secondPerson = namesAvailable.get(randomNum);

            while(firstPerson.equals(secondPerson)) {
                randomNum = randomGenerator(namesAvailable.size() - 1);
                secondPerson = namesAvailable.get(randomNum);

                // checks and fixes for when last item in list is the own person
                if(namesAvailable.size() == 1) {
                    if(namesAvailable.get(0).equals(firstPerson)) {
                        secondPerson = finalList.get(names.get(0));
                        finalList.put(names.get(0), namesAvailable.get(0));

                        namesAvailable.remove(0);
                        namesAvailable.add(secondPerson);
                    }
                }
            }

            namesAvailable.remove(secondPerson);

            finalList.put(firstPerson, secondPerson);
        }
    }


    public void saveToFile(String filename) {
        try {
            File file = new File(filename);
            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);

            for(Map.Entry<String, String> entry : finalList.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }

            bw.close();
            writer.close();
            System.out.println("Finished saving mappings...");

        } catch(IOException e) {
            System.out.println("File error occurred.");
        }

    }

    public HashMap<String, String> getFinalList() {
        return finalList;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void addName(String name) {
        names.add(name);
    }

    public void removeName(String name) {
        names.remove(name);
    }

    private int randomGenerator(int max) {
        Random rand = new Random();

        return rand.nextInt((max + 1));
    }







}
