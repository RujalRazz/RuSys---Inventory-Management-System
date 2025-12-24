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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    
    public void populatingTable(JTable table, ArrayList<Product> display){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        model.setRowCount(0);
        if(display == null){
            return;
        }
        for(int i = 0; i < display.size(); i++){
            Product p = display.get(i);
            Object[] row = {
                p.getProductId(),
                p.getProductName(),
                p.getCategory(),
                p.getQuantity(),
                p.getPrice(),
                p.getExpiryDate()
            };
            model.addRow(row);
        }
    }
    public void refreshTable(JTable table){
        populatingTable(table, getAllProducts());
    }
    public Product searchById(String id){
        for(Product p: products){
            if(p.getProductId().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }
    public boolean deleteProduct(String id){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductId().equalsIgnoreCase(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean updateProduct(String id, int newQuantity, double newPrice){
        Product p = searchById(id);
        if(p != null){
            p.setPrice(newPrice);
            p.setQuantity(newQuantity);
            return true;
        }
        return false;
    }
}
