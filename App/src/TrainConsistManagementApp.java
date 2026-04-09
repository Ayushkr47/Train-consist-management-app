import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (UC4) ===");

        // Create LinkedList for train consist
        LinkedList<String> train = new LinkedList<>();

        // Add bogies (end of train)
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2 (index starts from 0)
        System.out.println("\nInserting 'Pantry Car' at position 2...");
        train.add(2, "Pantry Car");

        System.out.println("After insertion:");
        System.out.println(train);

        // Remove first and last bogie
        System.out.println("\nRemoving first and last bogie...");
        train.removeFirst();
        train.removeLast();

        // Final consist
        System.out.println("\nFinal Train Consist:");
        System.out.println(train);
    }
}