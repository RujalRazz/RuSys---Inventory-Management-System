/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ruzalrajopadhyay
 */
import java.util.ArrayList;
import Model.Product;
public class Sorting {
    public static void selectionSortId(ArrayList<Product> products){
          if (products == null || products.size() < 2) {
            return;
          }
          for(int step = 0; step < products.size() - 1; step++){
              int minIndex = step;
              for (int next = step + 1; next < products.size(); next ++){
                   String nextId = products.get(next).getProductId();
                   String currentMinId = products.get(minIndex).getProductId();
                   if(nextId.compareToIgnoreCase(currentMinId) < 0){
                       minIndex = next;
                   }
             
              }
              if (minIndex != step) {
                Product temp = products.get(step);
                products.set(step, products.get(minIndex));
                products.set(minIndex, temp);
            }
          
          }
        
    }
}
