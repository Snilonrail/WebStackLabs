package parserService;

import view.Page;

import static view.Page.*;

public class JsonParser implements Parser {

    @Override
    public String parse(Page page) {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("{");
        if (page.getPageContent().containsKey(PRODUCT_PHOTO) && page.getPageContent().containsKey(PRODUCT_DESCRIPTION)
                && page.getPageContent().containsKey(PRODUCT_ID) && page.getPageContent().containsKey(PRODUCT_NAME)){
            sbuilder.append("'title': '").append(page.getPageName()).append("',");
            sbuilder.append("'id': '").append(page.getPageContent().get(PRODUCT_ID)).append("',");
            sbuilder.append("'name': '").append(page.getPageContent().get(PRODUCT_NAME)).append("',");
            sbuilder.append("'desc': '").append(page.getPageContent().get(PRODUCT_DESCRIPTION)).append("',");
            sbuilder.append("'photo': '").append(page.getPageContent().get(PRODUCT_PHOTO));
        } else if (page.getPageContent().containsKey(ADDITIONAL_CONTENT)){
            sbuilder.append("'content': '").append(page.getPageContent().get(ADDITIONAL_CONTENT)).append("'");
        }
        else {
            throw new IllegalArgumentException(NOT_COMPLETE_FIELDS);
        }
        sbuilder.append("}");
        return sbuilder.toString();
    }

}
