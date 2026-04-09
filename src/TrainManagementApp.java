import java.util.ArrayList;
import java.util.HashSet;
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

        // Adding bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nBogie IDs after insertion (duplicates automatically removed):");
        System.out.println(bogieIds);

        // Program continues...
    }
}