package org.swe550.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class SearchKeywordUtil {
    public static void search(String keyword) {
        SelenideElement overlay = $(".overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            webdriver().driver().executeJavaScript("document.getElementsByClassName('overlay')[0].style.visibility='hidden'");
        }

        $("[data-testid=suggestion]").setValue(keyword);
        $("[data-testid=search-icon]").click();
    }
}
