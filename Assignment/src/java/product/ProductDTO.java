/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.Serializable;
/**
 *
 * @author SE130162
 */
public class ProductDTO implements Serializable {

    private String productID;
    private String productName;
    private int storeQuantity;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, int storeQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.storeQuantity = storeQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStoreQuantity() {
        return storeQuantity;
    }

    public void setStoreQuantity(int storeQuantity) {
        this.storeQuantity = storeQuantity;
    }
}
