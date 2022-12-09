package parserService;

import view.Page;

import static view.Page.*;

public class XmlParser implements Parser {
    @Override
    public String parse(Page page) {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("<root>");
        if (page.getPageContent().containsKey(PRODUCT_PHOTO) && page.getPageContent().containsKey(PRODUCT_DESCRIPTION)
                && page.getPageContent().containsKey(PRODUCT_ID) && page.getPageContent().containsKey(PRODUCT_NAME)){
            sbuilder.append("<title>").append(page.getPageName()).append("</title>");
            sbuilder.append("<id>").append(page.getPageContent().get(PRODUCT_ID)).append("</id>");
            sbuilder.append("<name>").append(page.getPageContent().get(PRODUCT_NAME)).append("</name>");
            sbuilder.append("<desc>").append(page.getPageContent().get(PRODUCT_DESCRIPTION)).append("</desc>");
            sbuilder.append("<product_photo>").append(page.getPageContent().get(PRODUCT_PHOTO)).append("<product_photo>");
        }
        else if (page.getPageContent().containsKey(ADDITIONAL_CONTENT)){
            sbuilder.append("<content>").append(page.getPageContent().get(ADDITIONAL_CONTENT)).append("</content>");
        }
        else {
            throw new IllegalArgumentException(NOT_COMPLETE_FIELDS);
        }
        sbuilder.append("</root>");
        return sbuilder.toString();
    }

}
