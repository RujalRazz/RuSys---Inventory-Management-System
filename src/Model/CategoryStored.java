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
public class CategoryStored {
    private HashMap<String, LinkedList<Product>> categoryStored;
    public CategoryStored(){
        categoryStored = new HashMap<String, LinkedList<Product>>();
        categoryStored.put("Electronics", new LinkedList<Product>());
        categoryStored.put("Food", new LinkedList<Product>());
        categoryStored.put("Shoes", new LinkedList<Product>());
        
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
