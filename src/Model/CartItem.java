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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class CartItem {
    private LinkedList<Cart> cart;
   
    public CartItem(){
        cart = new LinkedList<Cart>();
    }
    
    public void addToCart(Product product, int qty){
        boolean found = false;
        for(int i = 0; i < cart.size(); i++){
            Cart item = cart.get(i);
            if(item.getProduct().getProductId().equalsIgnoreCase(product.getProductId())){
                item.setQuantity(item.getQuantity() + qty);
                found = true;
                break;
            }

        }
        if(!found){
            cart.add(new Cart(product, qty));
        }
    }
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
    
    public LinkedList<Cart> getAllItems(){
        return cart;
    }
   
}
