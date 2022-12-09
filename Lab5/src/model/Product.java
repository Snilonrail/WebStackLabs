package model;

import java.util.BitSet;

public class Product {

    private final String productId;
    private final String productName;
    private final String productDescription;
    private final BitSet productPhoto;

    public Product(String productId, String productName, String productDescription, BitSet productPhoto) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPhoto = productPhoto;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public BitSet getProductPhoto() {
        return productPhoto;
    }
}
