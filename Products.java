package org.example;

public class Products implements shippableProducts {
    protected String name;
    protected int price;
    public int quantity;
    private double weight;
    protected int OrderQuantity;

    public Products(String name,int price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }
    public Products(String name, int price, int quantity, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

   @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public boolean isAvalible(){
        if (quantity>0){
            return true;
        }
        else{
            return false;
        }
    }
    public void decrementQuantity(int orderQuantity){

        if (orderQuantity<=quantity){
            quantity-=orderQuantity;
            OrderQuantity=orderQuantity;
        }
        else {
            System.out.println("sorry there's insuffucient amount for the "+this.name+"the avalible quantity to be ordered is "+ quantity);

        }
    }
    public boolean isExpired() {
        return false;
    }


    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
