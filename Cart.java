package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
   private List<Products>items;
   public Cart(){
       items = new ArrayList<>();
   }
   public void addItem(Products item, int quantity){
      boolean Avalibality = item.isAvalible();
      boolean expairy = item.isExpired();
      if(Avalibality==true && expairy==false){
         item.decrementQuantity(quantity);
         items.add(item);
      }
      else {
         System.out.println("sorry this item is not avalible right now we will restock soon");
      }
   }
   public List<Products> getItems() {
      if (items != null && !items.isEmpty()) {
         return items;
      } else {
         return null;
      }
   }

   public List<shippableProducts> getShippableItems() {
      List<shippableProducts> shippables = new ArrayList<>();
      for (Products item : items) {
         if (item instanceof shippableProducts) {
            shippables.add((shippableProducts) item);
         }
      }
      return shippables;
   }

}
