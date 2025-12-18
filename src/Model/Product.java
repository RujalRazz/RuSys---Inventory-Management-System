/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ruzalrajopadhyay
 */
import java.time.LocalDate;
public class Product {
    private String productId;
    private String productName;
    private String category;
    private int quantity;
    private double price;
    private LocalDate expiryDate;
    
    public Product(String productId, String productName, String category, int quantity, double price, LocalDate expiryDate){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }
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
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPrice(double price){
        this.price = price;
    }
    }
