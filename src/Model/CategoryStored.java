/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ruzalrajopadhyay
 */
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
public class CategoryStored {
    private HashMap<String, LinkedList<Product>> categoryStored;
    public CategoryStored(ArrayList<Product> initialProducts){
        categoryStored = new HashMap<String, LinkedList<Product>>();
        categoryStored.put("Electronic", new LinkedList<Product>());
        categoryStored.put("Food", new LinkedList<Product>());
        categoryStored.put("Shoes", new LinkedList<Product>());
        for (Product p : initialProducts) {
            addProduct(p);
        }    
    }
    public void addProduct(Product product){
        LinkedList<Product> list = categoryStored.get(product.getCategory());
        if(list != null){
            list.add(product);
        }
        
    }
    public LinkedList<Product> getByCategory(String category){
        return categoryStored.get(category);
    }
        
}
