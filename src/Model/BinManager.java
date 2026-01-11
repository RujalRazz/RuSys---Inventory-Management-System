/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ruzalrajopadhyay
 */


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BinManager {
    private static final int capacity = 5;
    private static Product[] stackArray = new Product[capacity];
    private static int top = -1;
    
    public static void push(Product product){
        if(product == null){
            return;
        }
        if(top == capacity - 1){
            for(int i = 0; i < capacity - 1; i++){
                stackArray[i] = stackArray[i + 1];
            }
            stackArray[top] = product;
        }
        else{
            top++;
            stackArray[top] = product;
        }
    }
    public static Product pop(){
        if(top == -1){
            return null;
        }
        Product topProduct = stackArray[top];
        stackArray[top] = null;
        top--;
        
        return topProduct;
    }
    public static void refreshBinTable(JTable table){
        if(table == null){
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for(int i = top; i >= 0; i--){
            Product p = stackArray[i];
            Object[] row = {
                p.getProductId(),
                p.getProductName()
            };
            model.addRow(row);
        }
    }
    public static void restoreItem(ProductStored products, JTable mainTable, JTable binTable){
        Product itemToRestore = pop();
        if(itemToRestore == null){
            return;
        }
        products.addProduct(itemToRestore);
        products.refreshTable(mainTable);
        refreshBinTable(binTable);
    } 
}
