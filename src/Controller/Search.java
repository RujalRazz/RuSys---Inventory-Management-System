/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ruzalrajopadhyay
 */
import Model.Product;
import java.util.ArrayList;
public class Search {
    public static Product binarySearchId(ArrayList<Product> products, String id){
            int low = 0;
            int high = products.size() - 1;
            
            while(low <= high){
                int mid = (low + high) / 2;
                Product midPoint = products.get(mid);
                String midId = midPoint.getProductId();
                
                int found = id.compareToIgnoreCase(midId);
                if(found == 0){
                    return midPoint;
                }
                else if(found < 0){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            return null;      
        }
    }
