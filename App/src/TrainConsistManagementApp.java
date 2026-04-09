import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (UC3) ===");

        // Create HashSet for unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs
        System.out.println("\nAdding bogie IDs...");
        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");
        bogieIds.add("B101"); // duplicate
        bogieIds.add("B102"); // duplicate

        // Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);

        // Check if a bogie exists
        System.out.println("\nChecking if B101 exists...");
        if (bogieIds.contains("B101")) {
            System.out.println("B101 is present.");
        } else {
            System.out.println("B101 is NOT present.");
        }
    }
}