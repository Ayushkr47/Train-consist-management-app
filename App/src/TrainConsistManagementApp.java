import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

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

        System.out.println(trainMatcher.matches() ? "Valid Train ID" : "Invalid Train ID");
        System.out.println(cargoMatcher.matches() ? "Valid Cargo Code" : "Invalid Cargo Code");

        // 🔹 UC12: Bogie Safety Validation
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Open", "Coal"),
                new Bogie("Cylindrical", "Petroleum"),
                new Bogie("Box", "Grain")
        );

        boolean isSafe = BogieValidator.isTrainSafe(bogies);

        System.out.println(isSafe ?
                "Train is SAFE and compliant." :
                "Train is NOT SAFE!");

        // 🔹 UC13: Performance Comparison

        // Loop-based
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCargo().equalsIgnoreCase("Petroleum")) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream-based
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCargo().equalsIgnoreCase("Petroleum"))
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("Loop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");

        sc.close();
    }
}