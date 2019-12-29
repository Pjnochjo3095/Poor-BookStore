/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author SE130162
 */
public class CartObj {

    private String username;
    private Map<String, Integer> items = null;
    public CartObj() {
    }

    public CartObj(String username) {
        this.username = username;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addToCart(String productID) {
        if (items == null) {
            items = new HashMap<>();
        }
        int quantity = 1;
        if (items.containsKey(productID)) {
            items.put(productID, items.get(productID) + quantity);
        } else {
            this.items.put(productID, quantity);
        }
    }
    public void removeItemFromYourCart(String item) {
        if (this.items != null) {
            if (this.items.containsKey(item)) {
                items.remove(item);
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            }
        }

    }
}
