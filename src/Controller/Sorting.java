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
    public static void mergeSortName(ArrayList<Product> products){
        if (products == null || products.size() < 2) {
            return;
        }
        
        mergeSortNameLogic(products, 0, products.size() - 1);
    }
    
    public static void mergeSortNameLogic(ArrayList<Product> products, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSortNameLogic(products, left, mid);
            mergeSortNameLogic(products, mid + 1, right);
            mergeItems(products, left, mid, right);
        }
    }
    
    public static void mergeItems(ArrayList<Product> products, int left, int mid, int right){
        ArrayList<Product> item = new ArrayList<Product>();
        int i = left;
        int j = mid + 1;
        
        while(i <= mid && j <= right){
            String leftName = products.get(i).getProductName();
            String rightName = products.get(j).getProductName();
            
            if(leftName.compareToIgnoreCase(rightName) <= 0){
                item.add(products.get(i));
                i++;
            }
            else{
                item.add(products.get(j));
                j++;
            }
        }
        while (i <= mid) {
            item.add(products.get(i));
            i++;
        }
        while (j <= right) {
            item.add(products.get(j));
            j++;
        }
        for (int x = 0; x < item.size(); x++) {
            products.set(left + x, item.get(x));
        }
    }
    
}
