package org.swe550.util;

import static com.codeborne.selenide.Selenide.$;

public class SearchKeywordUtil {
    public static void search(String keyword) {

        $("[data-testid=suggestion]").setValue(keyword);
        CloseUtil.closeOverlay();
        $("[data-testid=search-icon]").click();
    }
}
