import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (UC2) ===");

        // Create ArrayList for passenger bogies
        List<String> bogies = new ArrayList<>();

        // Add bogies
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        // Display bogies after insertion
        System.out.println("\nBogies after addition:");
        System.out.println(bogies);

        // Remove a bogie
        System.out.println("\nRemoving 'AC Chair'...");
        bogies.remove("AC Chair");

        // Display after removal
        System.out.println("Bogies after removal:");
        System.out.println(bogies);

        // Check existence
        System.out.println("\nChecking if 'Sleeper' exists...");
        if (bogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present.");
        } else {
            System.out.println("Sleeper bogie is NOT present.");
        }

        // Final state
        System.out.println("\nFinal Bogie List:");
        System.out.println(bogies);
    }
}