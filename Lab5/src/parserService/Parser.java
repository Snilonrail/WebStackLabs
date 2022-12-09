package parserService;

import view.Page;

public interface Parser {
    String NOT_COMPLETE_FIELDS = "content for some product field is missing.\n" +
            " We're not rendering such products";
    String parse(Page page);

}
