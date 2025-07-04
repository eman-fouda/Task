package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExpiringProducts extends Products {

    protected String expiringDate;

    public ExpiringProducts(String name, int price, int quantity, String expiringDate) {
        super(name, price, quantity);
        this.expiringDate = expiringDate;
    }

    public ExpiringProducts(String name, int price, int quantity, double weight, String expiringDate) {
        super(name, price, quantity, weight);
        this.expiringDate = expiringDate;
    }

    @Override
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        String exp ="this product is not expired";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate expiryDate = LocalDate.parse(expiringDate,formatter);
        if (expiryDate.isBefore(currentDate)){
            exp ="this product is expired";
            System.out.println(exp);
            return true;
        }
        else {
            return false;
        }
    }
}
