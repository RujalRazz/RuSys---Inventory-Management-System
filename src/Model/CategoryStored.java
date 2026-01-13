/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * The class divides the product in the respective HashMap using a linked list
 * @author ruzalrajopadhyay
 */
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
public class CategoryStored {
    
    private HashMap<String, LinkedList<Product>> categoryStored;
    public CategoryStored(ArrayList<Product> initialProducts){
        // Initializing the hash map
        categoryStored = new HashMap<String, LinkedList<Product>>();
        // Placing the product based on its category
        categoryStored.put("Electronic", new LinkedList<Product>());
        categoryStored.put("Food", new LinkedList<Product>());
        categoryStored.put("Shoes", new LinkedList<Product>());
     
        for (Product p : initialProducts) {
            addProduct(p);
        }    
    }
    // The method adds the product to the specific linked list based on category
    public void addProduct(Product product){
        LinkedList<Product> list = categoryStored.get(product.getCategory());
        if(list != null){
            list.add(product);
        }
        
    }
    // The method is used to retrieve the item by category
    public LinkedList<Product> getByCategory(String category){
        return categoryStored.get(category);
    }
        
}
