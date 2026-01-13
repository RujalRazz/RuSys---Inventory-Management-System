/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * The class defines the operation that takes place in product list
 * @author ruzalrajopadhyay
 */
import java.util.ArrayList;
import javax.swing.JTable;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
public class ProductStored {
    
    // Declaring the array list product that acts as the main ArrayList
    private ArrayList<Product> products;
    public ProductStored(){
        //Declaring the main arraylist and setting up initial varaibles
        products = new ArrayList<Product>();
        products.add(new Product("P001", "MacBook Pro", "Electronic", 250, 300000, LocalDate.of(0, 1, 1)));
        products.add(new Product("P002", "iPhone 15", "Electronic", 100, 200000, LocalDate.of(0, 1, 1)));
        products.add(new Product("P003", "Nike Air Max", "Shoes", 150, 15000, LocalDate.of(0, 1, 1)));
        products.add(new Product("P004", "Organic Milk", "Food", 300, 300, LocalDate.of(2026, 2, 15)));
        products.add(new Product("P005", "Bread", "Food", 200, 200, LocalDate.of(2026, 2, 20)));
    }
    
    // Method to add product in the arraylist
    public void addProduct(Product product){
        products.add(product);
    }
    // Method to retrieve all the products in the array list
    public ArrayList<Product> getAllProducts(){
        return products;
    }
    
    // Method to write the content in the array list to the table
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
    // Method to update the table
    public void refreshTable(JTable table){
        populatingTable(table, getAllProducts());
    }
    
    // Method to perform a linear search that searches ID
    public Product searchById(String id){
        for(Product p: products){
            if(p.getProductId().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }
    // Method to delete the product from the array List
    public boolean deleteProduct(String id){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductId().equalsIgnoreCase(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
    // Method to update the product in the list
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
