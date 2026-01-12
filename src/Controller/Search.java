/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 * The method is used to perform binary search operation in the id.
 * @author ruzalrajopadhyay
 */
import Model.Product;
import java.util.ArrayList;
public class Search {
    public static Product binarySearchId(ArrayList<Product> products, String id){
            // Calling selectionSortId from sorting.java to sort the array as the searchig can only take place on sorted list.
            Sorting.selectionSortId(products);
            
            // initializing lower index pointer to 0 and upper index pointer to the last index.
            int low = 0;
            int high = products.size() - 1;
            
            // running loop till lower value is greater than higher.
            while(low <= high){
                // finding out the mid index.
                int mid = (low + high) / 2;
                Product midPoint = products.get(mid);
                String midId = midPoint.getProductId();
                
                // comparing the retrieved product id to the desired id.
                int found = id.compareToIgnoreCase(midId);
                
                // Returning the value if the id is found
                if(found == 0){
                    return midPoint;
                }
                // initializing higher index to be one lower than mid if desired value is less than mid
                else if(found < 0){
                    high = mid - 1;
                }
                // initializing lower index to be one greater than mid if desired value is greater than mid
                else{
                    low = mid + 1;
                }
            }
            // returning null if no id with the desired one is found
            return null;      
        }
    }
