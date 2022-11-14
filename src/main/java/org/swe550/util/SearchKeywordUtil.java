package org.swe550.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchKeywordUtil {
    public static void search(String keyword) {

        $("[data-testid=suggestion]").setValue(keyword);
        CloseUtil.closeOverlay();

        SelenideElement searchIconElement = $("[data-testid=search-icon]");
        SelenideElement popupElement = $(".popup");
        if (popupElement.exists() && popupElement.isDisplayed()) {
            searchIconElement.click();
        }
        CloseUtil.closeOverlay();

        searchIconElement.click();
    }
}
