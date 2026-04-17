import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Bogie {
    private String type;
    private String cargo;

    public Bogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

class BogieValidator {
    public static boolean isTrainSafe(List<Bogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔹 UC11: Regex Validation
        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        Pattern trainPattern = Pattern.compile(trainRegex);
        Pattern cargoPattern = Pattern.compile(cargoRegex);

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }

        // 🔹 UC12: Bogie Safety Validation
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal"),
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Box", "Grain")
        );

        boolean isSafe = BogieValidator.isTrainSafe(bogies);

        if (isSafe) {
            System.out.println("Train is SAFE and compliant.");
        } else {
            System.out.println("Train is NOT SAFE!");
        }

        sc.close();
    }
}