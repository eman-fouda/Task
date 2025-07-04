package org.example;

import java.util.List;

public class OrderPayment {
    List<Products>AllItems;
    public int totalPrice=0;
    public double totalFees = 0.0;
    public double TotalPayement = 0;


    public OrderPayment(List<Products> items) {
        this.AllItems = items;
    }

    public int TotalPrice(){
        if (AllItems != null && !AllItems.isEmpty()) {
            for (Products item : AllItems) {
                totalPrice +=item.getPrice() * item.OrderQuantity;

            }
            return totalPrice;
        }
        else {return 0;}


    }

    public double ShippingFees(){
        if (AllItems != null && !AllItems.isEmpty()) {
            for(Products item: AllItems){
                double weight = item.getWeight();
                totalFees+=weight*0.2;
        }
            return totalFees;
        }
        else {return 0;}

    }

    public double TotalPayement(){
        TotalPayement = totalPrice + totalFees;

        return TotalPayement;
    }

    public void PayOrder(Customers customer){
        double Balance = customer.GetBalance();
        if (Balance >= TotalPayement){
            Balance-=TotalPayement;
            System.out.println("Payement Processed succesfully");
            customer.SetBalance(Balance);
        }
        else {
            System.out.println("insuffecient balance to pay for this order.");
        }
    }
}
