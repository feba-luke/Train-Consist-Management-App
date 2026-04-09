import java.util.*;

// === Bogie Class for UC7 ===
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

        // === UC1: Initialize Train ===
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // === UC2: Add Passenger Bogies ===

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter adding passenger bogies:");
        System.out.println("Train Consist: " + trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair bogie:");
        System.out.println("Train Consist: " + trainConsist);

        boolean exists = trainConsist.contains("Sleeper");
        System.out.println("\nDoes Sleeper bogie exist? " + exists);

        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        // === UC3: Track Unique Bogie IDs using HashSet ===

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("\nBogie IDs after insertion (duplicates automatically removed):");
        System.out.println(bogieIds);

        // === UC4: Maintain Ordered Train Consist using LinkedList ===

        LinkedList<String> orderedTrain = new LinkedList<>();

        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");

        System.out.println("\nInitial Ordered Train Consist:");
        System.out.println(orderedTrain);

        orderedTrain.add(2, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(orderedTrain);

        orderedTrain.removeFirst();
        orderedTrain.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(orderedTrain);

        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(orderedTrain);

        // === UC5: LinkedHashSet ===

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // duplicate

        System.out.println("\nTrain Formation (LinkedHashSet):");
        System.out.println(trainFormation);

        // === UC6: HashMap (Bogie → Capacity) ===

        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        // === UC7: Sort Bogies by Capacity using Comparator ===

        List<Bogie> bogieList = new ArrayList<>();

        // Create objects
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 24));

        System.out.println("\nBefore Sorting:");
        System.out.println(bogieList);

        // Sort using Comparator (ascending order)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        System.out.println(bogieList);

        // Optional: Descending order (real-world useful)
        bogieList.sort((b1, b2) -> b2.capacity - b1.capacity);

        System.out.println("\nAfter Sorting by Capacity (Descending):");
        System.out.println(bogieList);
    }
}