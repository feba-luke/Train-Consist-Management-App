import java.util.*;
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

        // === UC1 ===
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();

        // === UC2 ===
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");

        // === UC3 ===
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");

        // === UC4 ===
        LinkedList<String> orderedTrain = new LinkedList<>();
        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");
        orderedTrain.add(2, "Pantry Car");
        orderedTrain.removeFirst();
        orderedTrain.removeLast();

        // === UC5 ===
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        // === UC6 ===
        HashMap<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 24);

        // === UC7 ===
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 72)); // duplicate for grouping

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nSorted Bogies:");
        System.out.println(bogieList);

        // === UC8 ===
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        System.out.println(filteredBogies);

        // === UC9 ===
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // === UC10: Total Capacity using reduce() ===

        int totalCapacity = bogieList.stream()
                .map(b -> b.capacity)          // extract capacity
                .reduce(0, Integer::sum);      // aggregate (sum)

        System.out.println("\nTotal Seating Capacity of Train:");
        System.out.println(totalCapacity);

        // Verify original list unchanged
        System.out.println("\nOriginal Bogie List (Unchanged):");
        System.out.println(bogieList);
    }
}