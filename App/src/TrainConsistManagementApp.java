import java.util.ArrayList;
import java.util.List;

// Reusing Bogie class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (UC10) ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        // Stream pipeline: map + reduce
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)          // extract capacity
                .reduce(0, Integer::sum);      // sum all values

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);
    }
}