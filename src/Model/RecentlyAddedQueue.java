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
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.util.ArrayList;
public class RecentlyAddedQueue {
    private static final int capacity = 5;
    private static Product[] addedQueue = new Product[capacity];
    private static int front = 0;
    private static int rear = -1;
    private static int currentSize = 0;
    
    public static void initializingTable(){
        front = 0;
        rear = -1;
        currentSize = 0;
        addedQueue = new Product[capacity];
        
        enqueue(new Product("P001", "MacBook Pro", "Electronics", 300000, 250, LocalDate.of(0, 1, 1)));
        enqueue(new Product("P002", "iPhone 15", "Electronics", 250000, 1200, LocalDate.of(0, 1, 1)));
        enqueue(new Product("P003", "Nike Air Max", "Shoes", 15000, 150, LocalDate.of(0, 1, 1)));
        enqueue(new Product("P004", "Organic Milk", "Food", 300, 10, LocalDate.of(2026, 2, 15)));
        enqueue(new Product("P005", "Bread", "Food", 200, 20, LocalDate.of(2026, 2, 20)));
    }
    
    public static void enqueue(Product product){
        if(product == null){
            return;
        }
        if(currentSize == capacity){
            dequeue();
        } 
        rear = (rear + 1) % capacity;
        addedQueue[rear] = product;
        currentSize++;
    
    }
    public static Product dequeue(){
        if(currentSize == 0){
            return null;
        }
        Product removed = addedQueue[front];
        addedQueue[front] = null;
        front = (front + 1) %  capacity;
        currentSize--;
        return removed;
    }
    public static void productDeletion(String productId){
        if(productId == null || currentSize == 0){
            return;
        }
        ArrayList<Product> storage = new ArrayList<Product>();
        int size = currentSize;
        for(int i = 0; i < size; i++){
            Product p = dequeue();
            if(p != null && !(p.getProductId().equalsIgnoreCase(productId))){
                storage.add(p);
            }
        }
        for(Product p: storage){
            enqueue(p);
        }
    }
    
    public static void updateTable(JTable table){
        if(table == null){
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < currentSize; i++){
            int index = (front + i) % capacity;
            Product p = addedQueue[index];
            if(p != null){
                Object[] row = {p.getProductId(), p.getProductName()};
                model.addRow(row);
            }
        }
    }
    
}
