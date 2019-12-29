package ordered;

import java.io.Serializable;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE130162
 */
public class OrderedDTO implements Serializable{
    private String username;
    private int total;
    private Date dateCheckout;

    public OrderedDTO() {
    }

    public OrderedDTO(String username, int total, Date dateCheckout) {
        this.username = username;
        this.total = total;
        this.dateCheckout = dateCheckout;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDateCheckout(Date dateCheckout) {
        this.dateCheckout = dateCheckout;
    }

    public Date getDateCheckout() {
        return dateCheckout;
    }

    
}
