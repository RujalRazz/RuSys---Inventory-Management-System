/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 * The class sorting consists multiple sorting algorithm such as selection Sort, insertion sort, and merge sort.
 * These methods are essential to sort the arrayList based on user's desire.
 * @author ruzalrajopadhyay
 */
import java.util.ArrayList;
import Model.Product;
public class Sorting {
    
    // Time complexity: O(n²)
    public static void selectionSortId(ArrayList<Product> products){
          // returning if the list consists less than 2 values
          if (products == null || products.size() < 2) {
            return;
          }
          // a for loop that runs till the it reaches the last index
          for(int step = 0; step < products.size() - 1; step++){
              
              // Initializing the minimum index as the first value
              int minIndex = step;
              
              // Running a nested loop to find out the minimum value in the list
              for (int next = step + 1; next < products.size(); next ++){
                   String nextId = products.get(next).getProductId();
                   String currentMinId = products.get(minIndex).getProductId();
                   
                   //comparing the product if of current min index to the product id of the current index.
                   if(nextId.compareToIgnoreCase(currentMinId) < 0){
                       minIndex = next; // replacing minIndex with the next value if the next value is less
                   }
             
              }
              // swapping the product in min index with the product defined by the value step
              if (minIndex != step) {
                Product temp = products.get(step);
                products.set(step, products.get(minIndex));
                products.set(minIndex, temp);
            }
          
          }
        
    }
    
    // O(n log n)
    public static void mergeSortName(ArrayList<Product> products){
        // returning if the list consists less than 2 values
        if (products == null || products.size() < 2) {
            return;
        }
        
        // calling mergeSortNameLogic by initializing the value of list, left, and right
        mergeSortNameLogic(products, 0, products.size() - 1);
    }
    
    // The method consists the logic for the merge sort.
    public static void mergeSortNameLogic(ArrayList<Product> products, int left, int right){
        // writing the base case to run the recursive function, The method will run till the item in left is lower than right
        if(left < right){
            // spliting the item in mid 
            int mid = left + (right - left) / 2;
            
            // calling the method to loop on both left and right simultaneously. 
            mergeSortNameLogic(products, left, mid);
            mergeSortNameLogic(products, mid + 1, right);
            
            // calling the mergeItems method to join the separated list
            mergeItems(products, left, mid, right);
        }
    }
    
    // the method is defined to merge the divided list
    public static void mergeItems(ArrayList<Product> products, int left, int mid, int right){
        // declaring a new arrayList named item that references to the class product
        ArrayList<Product> item = new ArrayList<Product>();
        
        // initializing the variables i and j to work with loops
        int i = left;
        int j = mid + 1;
        
        /* running a while loop till the value of i is less than or equal to the value of mid 
            and the value of j is less than or equal to the value of right passed in the parameter 
        */
        while(i <= mid && j <= right){
            
            
            String leftName = products.get(i).getProductName();
            String rightName = products.get(j).getProductName();
            
            //comparing if the left name is < or = to the right name
            if(leftName.compareToIgnoreCase(rightName) <= 0){
                item.add(products.get(i));
                i++;
            }
            else{
                item.add(products.get(j));
                j++;
            }
        }
        // if the item is in the left half adding them to the item list
        while (i <= mid) {
            item.add(products.get(i));
            i++;
        }
        // if the item is in the right half adding them to the item list
        while (j <= right) {
            item.add(products.get(j));
            j++;
        }
        
        for (int x = 0; x < item.size(); x++) {
            products.set(left + x, item.get(x));
        }
    }
    
    public static void insertionSortPrice(ArrayList<Product> products){
        if (products == null || products.size() < 2) {
        return;
    }
        int size = products.size();
        for (int i = 1; i < size; i++) {
            Product item = products.get(i);
            double itemPrice = item.getPrice();
            
            int j = i - 1;
            
            while(j >= 0 && products.get(j).getPrice() > itemPrice){
                products.set(j + 1, products.get(j));
                j--;
                
            }
            products.set(j + 1, item);
        }
       
}
}