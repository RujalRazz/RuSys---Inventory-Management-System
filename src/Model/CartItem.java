/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * The method helps to perform operations in the users cart menu
 * @author ruzalrajopadhyay
 */
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class CartItem {
    private LinkedList<Cart> cart;
   // Initializing the linked List
    public CartItem(){
        cart = new LinkedList<Cart>();
    }
    // the method is used to add thd product to the cart
    public boolean addToCart(Product product, int qty){
        boolean found = false;
        for(int i = 0; i < cart.size(); i++){
            Cart item = cart.get(i);
            if(item.getProduct().getProductId().equalsIgnoreCase(product.getProductId())){
                int newQuantity = item.getQuantity() + qty;
                if(newQuantity > product.getQuantity()){
                    return false;
                }
                item.setQuantity(newQuantity);
                found = true;
                break;
            }

        }
        if(!found){
            cart.add(new Cart(product, qty));
           
        }
        return true;
    }
    // The method is used to remove the item from the cart
    public boolean removeItem(String productId){
        
        for(int i = 0; i < cart.size(); i++){
            Cart item = cart.get(i);
            if(item.getProduct().getProductId().equalsIgnoreCase(productId)){
                cart.remove(i);
                return true;
            }
        }
        return false;
        
    }
    // The method refereshes the cart table in the user panel
    public void refreshCartTable(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < cart.size(); i++){
            Cart items = cart.get(i);
            Object[] row = {
                items.getProduct().getProductId(),
                items.getProduct().getProductName(),
                items.getProduct().getCategory(),
                items.getQuantity(),
                items.getProduct().getPrice(),
                items.getTotalPrice()
            };
            model.addRow(row);
        }
    }
    // The method retrieves all the item in the cart
    public LinkedList<Cart> getAllItems(){
        return cart;
    }
   
}
