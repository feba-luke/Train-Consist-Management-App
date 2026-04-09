import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

// === Bogie Class ===
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainManagementApp {

    public static void main(String[] args) {

        // === UC1 → UC10 (shortened for clarity, already implemented above) ===

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 24));

        // === UC11: Regex Validation ===

        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("\nEnter Train ID (format TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Regex patterns
        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainPattern = Pattern.compile(trainRegex);
        Pattern cargoPattern = Pattern.compile(cargoRegex);

        // Match inputs
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validation
        if (trainMatcher.matches()) {
            System.out.println("✅ Valid Train ID");
        } else {
            System.out.println("❌ Invalid Train ID");
        }

        if (cargoMatcher.matches()) {
            System.out.println("✅ Valid Cargo Code");
        } else {
            System.out.println("❌ Invalid Cargo Code");
        }

        scanner.close();
    }
}