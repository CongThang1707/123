/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemDAO;

/**
 *
 * @author admin
 */
public class Item {
    private String itemId;
    private String itemName;
    private int quantity;

    public Item(String itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("id=%s,name=%s,quantity=%d",itemId,itemName,quantity);
    }
    
}
