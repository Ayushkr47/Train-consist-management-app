import java.util.*;

// 🔹 Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 🔹 Passenger Bogie
class PassengerBogie {
    private int capacity;

    public PassengerBogie(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0!");
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

// 🔹 Train Consist (holds bogies)
class TrainConsist {
    private List<PassengerBogie> passengerBogies = new ArrayList<>();

    public void addPassengerBogie(int capacity) {
        try {
            PassengerBogie bogie = new PassengerBogie(capacity);
            passengerBogies.add(bogie);
            System.out.println("Passenger bogie added successfully with capacity: " + capacity);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayBogies() {
        System.out.println("Passenger Bogies in Train:");
        for (PassengerBogie b : passengerBogies) {
            System.out.println("Capacity: " + b.getCapacity());
        }
    }
}

// 🔹 Main Application
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TrainConsist train = new TrainConsist();

        System.out.print("Enter number of passenger bogies: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter capacity for bogie " + (i + 1) + ": ");
            int capacity = sc.nextInt();
            train.addPassengerBogie(capacity);
        }

        train.displayBogies();

        sc.close();
    }
}