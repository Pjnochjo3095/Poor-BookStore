/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nhutnhm.utils.DBUtilities;

/**
 *
 * @author SE130162
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> items = null;

    public List<ProductDTO> getItems() {
        return items;
    }

    public void readItemsFromDB() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select productID,productName,storeQuantity"
                        + " From Product";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (items == null) {
                    items = new ArrayList<>();
                }
                while (rs.next()) {
                    String id = rs.getString("productID");
                    String name = rs.getString("productName");
                    int quantity = rs.getInt("storeQuantity");
                    ProductDTO dto = new ProductDTO(id, name, quantity);
                    items.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

}
