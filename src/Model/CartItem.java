/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ruzalrajopadhyay
 */

public class CartItem {
    private Product product;
    private int quantity;
    public CartItem(Product product, int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void increaseQuantity(int qty){
        if(qty > 0){
            this.quantity += qty;
        }
       
    }
   
}
