import java.util.ArrayList;
import java.util.List;

public class TrainManagementApp {

    public static void main(String[] args) {

        // === UC1: Initialize Train ===
        System.out.println("=== Train Consist Management App ===");

        // Initialize train consist
        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // === UC2: Add Passenger Bogies ===

        // Add passenger bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display after adding bogies
        System.out.println("\nAfter adding passenger bogies:");
        System.out.println("Train Consist: " + trainConsist);

        // Remove one bogie (AC Chair)
        trainConsist.remove("AC Chair");

        // Display after removal
        System.out.println("\nAfter removing AC Chair bogie:");
        System.out.println("Train Consist: " + trainConsist);

        // Check existence of Sleeper
        boolean exists = trainConsist.contains("Sleeper");
        System.out.println("\nDoes Sleeper bogie exist? " + exists);

        // Final state
        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        // Program continues...
    }
}


