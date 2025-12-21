/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ruzalrajopadhyay
 */
import java.util.ArrayList;
public class ProductStored {
    private ArrayList<Product> products;
    public ProductStored(){
        products = new ArrayList<Product>();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public ArrayList<Product> getAllProducts(){
        return products;
    }
    
}
