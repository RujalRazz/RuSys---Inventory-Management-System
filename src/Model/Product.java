/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * The product class declares all the necessary attributes needed to define a products
 * @author ruzalrajopadhyay
 */
import java.time.LocalDate;
public class Product {
    // Declaring Varaibles
    private String productId;
    private String productName;
    private String category;
    private int quantity;
    private double price;
    private LocalDate expiryDate;
    
    // Initializing the variables
    public Product(String productId, String productName, String category, int quantity, double price, LocalDate expiryDate){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }
    
    // Defining getters method to retrieve the elements of the product
    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    // Setting up setters method to set the value of elements
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    }
