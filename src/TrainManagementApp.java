import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

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

        // === UC5: Preserve Insertion Order & Uniqueness using LinkedHashSet ===

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // محاولة إضافة مكرر (duplicate)
        trainFormation.add("Sleeper"); // duplicate

        System.out.println("\nTrain Formation using LinkedHashSet (No duplicates, order preserved):");
        System.out.println(trainFormation);
    }
}