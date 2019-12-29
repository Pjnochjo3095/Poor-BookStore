/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordered;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import nhutnhm.utils.DBUtilities;

/**
 *
 * @author SE130162
 */
public class OrderedDAO implements Serializable {

    public boolean addOrdered(OrderedDTO dto) throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Insert into Ordered"
                        + "(username,dateCheckout,total)"
                        + " Values(?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setDate(2, dto.getDateCheckout());
                stm.setInt(3, dto.getTotal());
                boolean result = stm.executeUpdate()>0;
                if(result){
                 return true;
                }
            }
        } finally {
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
