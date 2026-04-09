import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

// ================= UC14: Custom Exception =================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ================= Passenger Bogie =================
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

// ================= Goods Bogie =================
class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String toString() {
        return type + " (" + cargo + ")";
    }
}

public class TrainManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        try {

            // ================= UC1 & UC2 =================
            List<String> trainConsist = new ArrayList<>();
            trainConsist.add("Sleeper");
            trainConsist.add("AC Chair");
            trainConsist.add("First Class");

            trainConsist.remove("AC Chair");
            System.out.println("\nTrain Consist: " + trainConsist);

            // ================= UC3 =================
            Set<String> bogieIds = new HashSet<>();
            bogieIds.add("BG101");
            bogieIds.add("BG102");
            bogieIds.add("BG101");
            System.out.println("\nUnique Bogie IDs: " + bogieIds);

            // ================= UC4 =================
            LinkedList<String> orderedTrain = new LinkedList<>();
            orderedTrain.add("Engine");
            orderedTrain.add("Sleeper");
            orderedTrain.add("AC");
            orderedTrain.add("Cargo");
            orderedTrain.add("Guard");

            orderedTrain.add(2, "Pantry Car");
            orderedTrain.removeFirst();
            orderedTrain.removeLast();
            System.out.println("\nOrdered Train: " + orderedTrain);

            // ================= UC5 =================
            LinkedHashSet<String> formation = new LinkedHashSet<>();
            formation.add("Engine");
            formation.add("Sleeper");
            formation.add("Cargo");
            formation.add("Guard");
            formation.add("Sleeper");
            System.out.println("\nFormation: " + formation);

            // ================= UC6 =================
            HashMap<String, Integer> capacityMap = new HashMap<>();
            capacityMap.put("Sleeper", 72);
            capacityMap.put("AC Chair", 60);
            capacityMap.put("First Class", 24);

            System.out.println("\nCapacity Map:");
            for (Map.Entry<String, Integer> e : capacityMap.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }

            // ================= UC7 =================
            List<Bogie> bogieList = new ArrayList<>();
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 60));
            bogieList.add(new Bogie("First Class", 24));

            // ❌ Try invalid case (to test UC14)
            // bogieList.add(new Bogie("Invalid", -10));

            bogieList.sort(Comparator.comparingInt(b -> b.capacity));
            System.out.println("\nSorted Bogies: " + bogieList);

            // ================= UC8 =================
            List<Bogie> filtered = bogieList.stream()
                    .filter(b -> b.capacity > 60)
                    .collect(Collectors.toList());
            System.out.println("\nFiltered (>60): " + filtered);

            // ================= UC9 =================
            Map<String, List<Bogie>> grouped = bogieList.stream()
                    .collect(Collectors.groupingBy(b -> b.name));

            System.out.println("\nGrouped Bogies:");
            for (Map.Entry<String, List<Bogie>> e : grouped.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }

            // ================= UC10 =================
            int totalCapacity = bogieList.stream()
                    .map(b -> b.capacity)
                    .reduce(0, Integer::sum);

            System.out.println("\nTotal Capacity: " + totalCapacity);

            // ================= UC11 =================
            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter Train ID (TRN-1234): ");
            String trainId = sc.nextLine();

            System.out.print("Enter Cargo Code (PET-AB): ");
            String cargoCode = sc.nextLine();

            Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
            Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

            System.out.println(trainPattern.matcher(trainId).matches()
                    ? "Valid Train ID" : "Invalid Train ID");

            System.out.println(cargoPattern.matcher(cargoCode).matches()
                    ? "Valid Cargo Code" : "Invalid Cargo Code");

            // ================= UC12 =================
            List<GoodsBogie> goodsList = new ArrayList<>();
            goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
            goodsList.add(new GoodsBogie("Open", "Coal"));

            boolean isSafe = goodsList.stream()
                    .allMatch(b ->
                            b.type.equals("Cylindrical")
                                    ? b.cargo.equals("Petroleum")
                                    : true
                    );

            System.out.println("\nSafety Check: " + (isSafe ? "SAFE" : "NOT SAFE"));

            // ================= UC13 =================
            List<Bogie> largeList = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                largeList.add(new Bogie("Sleeper", 72));
                largeList.add(new Bogie("AC Chair", 60));
            }

            long startLoop = System.nanoTime();
            List<Bogie> loopResult = new ArrayList<>();
            for (Bogie b : largeList) {
                if (b.capacity > 60) {
                    loopResult.add(b);
                }
            }
            long endLoop = System.nanoTime();

            long startStream = System.nanoTime();
            List<Bogie> streamResult = largeList.stream()
                    .filter(b -> b.capacity > 60)
                    .collect(Collectors.toList());
            long endStream = System.nanoTime();

            System.out.println("\nLoop Time: " + (endLoop - startLoop));
            System.out.println("Stream Time: " + (endStream - startStream));

            sc.close();

        } catch (InvalidCapacityException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}