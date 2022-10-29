package org.swe550.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchKeywordUtil {
    public static void search(String keyword) {

        $("[data-testid=suggestion]").setValue(keyword);
        SelenideElement overlay = $(".overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            Selenide.executeJavaScript("document.getElementsByClassName('overlay')[0].style.visibility='hidden'");
        }
        $("[data-testid=search-icon]").click();
    }
}
