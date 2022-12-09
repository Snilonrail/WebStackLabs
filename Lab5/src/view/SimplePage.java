package view;

import java.util.Map;

public class SimplePage implements Page {

    private final String title;
    private final String content;

    public SimplePage(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getPageName() {
        return title;
    }

    @Override
    public Map<String, Object> getPageContent() {
        return Map.of(ADDITIONAL_CONTENT, content);
    }

}
