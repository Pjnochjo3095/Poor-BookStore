/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordereddetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import nhutnhm.utils.DBUtilities;

/**
 *
 * @author SE130162
 */
public class OrderedDetailsDAO implements Serializable {

    public boolean addOrderedDetalil(Map<String, Integer> items) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtilities.makeConnection();
            con.setAutoCommit(false);
            boolean check = false;
            if (con != null) {
                String sql = "insert into OrderedDetails(productID,quantity) Values(?,?)";
                stm = con.prepareStatement(sql);
                for (String item : items.keySet()) {
                    stm.setString(1, item);
                    stm.setInt(2, items.get(item));
                    check = stm.executeUpdate() > 0;
                    if (!check) {
                        return false;
                    }
                }
                con.commit();
                return true;
            }
        } finally {
            con.setAutoCommit(true);
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
}
