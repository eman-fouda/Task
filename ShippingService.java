package org.example;
import java.util.List;
public class ShippingService {
    public static void send(List<shippableProducts> itemsToShip) {
        if (itemsToShip == null || itemsToShip.isEmpty()) {
            System.out.println("No items to ship.");
            return;
        }

        System.out.println("\nShipping the following items:");
        for (shippableProducts item : itemsToShip) {
            System.out.println(" - " + item.getName() + ", Weight: " + item.getWeight() + "kg");
        }

        System.out.println("Shipping process initiated...");
    }
}
