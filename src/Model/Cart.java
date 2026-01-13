/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * The class is used to operate the cart of the users
 * @author ruzalrajopadhyay
 */
import java.util.LinkedList;
public class Cart {
    private Product products;
    private int quantity;
    // Initializing the variables
    public Cart(Product products, int quantity){
        this.products = products;
        this.quantity = quantity;
    }
    // setting up getters method to received the attributes of the product
    public Product getProduct(){
        return this.products;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public double getTotalPrice(){
        return products.getPrice() * quantity;
    }
}

