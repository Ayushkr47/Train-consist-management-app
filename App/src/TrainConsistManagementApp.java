import java.util.*;

// 🔹 Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// 🔹 Goods Bogie
class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        // Rule: Petroleum NOT allowed in Rectangular bogie
        if (shape.equalsIgnoreCase("Rectangular") &&
                cargo.equalsIgnoreCase("Petroleum")) {

            throw new CargoSafetyException(
                    "Unsafe Assignment: Petroleum cannot be loaded in Rectangular bogie!"
            );
        }

        this.cargo = cargo;
        System.out.println("Cargo assigned successfully: " + cargo);
    }

    public String getDetails() {
        return "Shape: " + shape + ", Cargo: " + (cargo != null ? cargo : "None");
    }
}

// 🔹 Train Consist
class TrainConsist {
    private List<GoodsBogie> bogies = new ArrayList<>();

    public void addBogie(GoodsBogie bogie) {
        bogies.add(bogie);
    }

    public void display() {
        System.out.println("\nTrain Consist Details:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.getDetails());
        }
    }
}

// 🔹 Main Application
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TrainConsist train = new TrainConsist();

        System.out.print("Enter number of goods bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {

            System.out.print("Enter bogie shape (Cylindrical/Rectangular): ");
            String shape = sc.nextLine();

            GoodsBogie bogie = new GoodsBogie(shape);

            System.out.print("Enter cargo to assign: ");
            String cargo = sc.nextLine();

            try {
                bogie.assignCargo(cargo); // may throw exception
                train.addBogie(bogie);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Assignment attempt completed for bogie " + (i + 1));
            }
        }

        train.display();

        sc.close();
    }
}