import java.util.*;
import java.util.stream.*;

// === Goods Bogie Class ===
class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " (" + cargo + ")";
    }
}

public class TrainManagementApp {

    public static void main(String[] args) {

        // === UC12: Safety Compliance Check ===

        List<GoodsBogie> goodsList = new ArrayList<>();

        // Sample Data
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Open", "Coal"));
        goodsList.add(new GoodsBogie("Box", "Grain"));
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid

        // Safety Check using allMatch()
        boolean isSafe = goodsList.stream()
                .allMatch(b ->
                        // Rule: Cylindrical → only Petroleum
                        b.type.equals("Cylindrical")
                                ? b.cargo.equals("Petroleum")
                                : true
                );

        System.out.println("\nGoods Bogies:");
        System.out.println(goodsList);

        if (isSafe) {
            System.out.println("✅ Train is SAFETY COMPLIANT");
        } else {
            System.out.println("❌ Train is NOT SAFE");
        }
    }
}