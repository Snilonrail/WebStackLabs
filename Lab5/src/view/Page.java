package view;

import java.util.Map;

public interface Page {

    String PRODUCT_ID = "idKey";
    String PRODUCT_NAME = "nameKey";
    String PRODUCT_DESCRIPTION = "descKey";
    String PRODUCT_PHOTO = "photoKey";
    String ADDITIONAL_CONTENT = "addContentKey";

    String getPageName();
    Map<String, Object> getPageContent();

}

