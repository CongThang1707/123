/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class ItemManager {
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionString = "jdbc:sqlserver://localhost:1433;database=SampleDB;encrypt=true;trustServerCertificate=true;";
            Connection cnn = DriverManager.getConnection(connectionString, "sa", "123");
            return cnn;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
    
    public List<Item> getItems() throws Exception {
        String id, name;
        int quantity;
        Connection cnn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<Item> itemList = new ArrayList();
        try {
            cnn = getConnection();
            String sql = "select ItemId,ItemName,Quantity from Items";
            preStm = cnn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                quantity = rs.getInt(3);
                Item item = new Item(id, name, quantity);
                itemList.add(item);
            }
            rs.close();
            preStm.close();
            cnn.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        if (itemList.isEmpty()) {
            return null;
        }
        return itemList;
    }
}
