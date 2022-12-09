package parserService;

import view.Page;

import static view.Page.*;

public class HtmlParser implements Parser {

    @Override
    public String parse(Page page) {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("<html>");
        sbuilder.append("<head><title>").append(page.getPageName()).append("<title></head>");

        if (page.getPageContent().containsKey(PRODUCT_PHOTO) && page.getPageContent().containsKey(PRODUCT_DESCRIPTION)
        && page.getPageContent().containsKey(PRODUCT_ID) && page.getPageContent().containsKey(PRODUCT_NAME)){
            sbuilder.append("<body>");
            sbuilder.append("<div id='product_id'>").append(page.getPageContent().get(PRODUCT_ID)).append("</div>");
            sbuilder.append("<div id='product_name'>").append(page.getPageContent().get(PRODUCT_NAME)).append("</div>");
            sbuilder.append("<div id='product_desc'>").append(page.getPageContent().get(PRODUCT_DESCRIPTION)).append("</div>");
            sbuilder.append("<div id='product_photo'>").append(page.getPageContent().get(PRODUCT_PHOTO)).append("</div>");
        } else if (page.getPageContent().containsKey(ADDITIONAL_CONTENT)){
            sbuilder.append("<div id='content'>").append(page.getPageContent().get(ADDITIONAL_CONTENT)).append("</div>");
        }
        else {
            throw new IllegalArgumentException(NOT_COMPLETE_FIELDS);
        }
        sbuilder.append("</body></html>");
        return sbuilder.toString();
    }
}
