package view;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductPage implements Page {

    private final Product product;

    public ProductPage(Product product) {
        this.product = product;
    }

    @Override
    public String getPageName() {
        return product.getProductId() + "-" + product.getProductName();
    }

    @Override
    public Map<String, Object> getPageContent() {
        Map<String, Object> content = new HashMap<>();
        content.put(PRODUCT_DESCRIPTION, product.getProductDescription());
        content.put(PRODUCT_ID, product.getProductId());
        content.put(PRODUCT_NAME, product.getProductName());
        content.put(PRODUCT_PHOTO, product.getProductPhoto());
        return content;
    }

}
