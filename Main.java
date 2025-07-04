package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customers customer = new Customers("Eman");
        customer.SetBalance(1000.0);

        // Create products
        ExpiringProducts cheese = new ExpiringProducts("Cheese", 100, 5, 0.5, "20/08/2025");
        ExpiringProducts biscuits = new ExpiringProducts("Biscuits", 150, 2, 0.6, "15/09/2025");
        Products scratchCard = new Products("Scratch Card", 50, 10);
        Products tv = new Products("TV", 300, 4, 5);


        Cart cart = new Cart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(scratchCard, 1);


        List<Products> items = cart.getItems();
        if (items == null) {
            System.out.println("your cart is empty.");
            return;
        }

        // Print shipment notice
        List<shippableProducts> toShip = cart.getShippableItems();
        double totalWeight = 0.0;

        if (!toShip.isEmpty()) {
            System.out.println("order details");
            for (Products item : items) {
                if (item.getWeight() > 0 && item.OrderQuantity > 0) {
                    System.out.println(item.OrderQuantity + "x " + item.getName());
                    totalWeight += item.getWeight() * item.OrderQuantity;
                }
            }
            System.out.println("Total package weight: " + totalWeight + "kg");
        }

        // Create order and calculate totals
        OrderPayment order = new OrderPayment(items);
        double subtotal = order.TotalPrice();
        double total = order.TotalPayement();


        System.out.println("cart details");
        for (Products item : items) {
            if (item.OrderQuantity > 0) {
                System.out.println(item.OrderQuantity + "x " + item.getName() + " " + (item.getPrice() * item.OrderQuantity));
            }
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int) subtotal);
        System.out.println("Shipping fees " + totalWeight*0.2 );
        System.out.println("Amount " + (int) total + totalWeight*0.2);


        order.PayOrder(customer);


        ShippingService.send(toShip);
    }
}


