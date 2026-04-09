import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (UC5) ===");

        // Create LinkedHashSet for ordered + unique bogies
        Set<String> train = new LinkedHashSet<>();

        // Add bogies
        System.out.println("\nAdding bogies...");
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        // Attempt duplicate
        System.out.println("\nAttempting to add duplicate 'Sleeper'...");
        train.add("Sleeper"); // ignored automatically

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(train);
    }
}