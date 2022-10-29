package org.swe550.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OverlayCloseUtil {
    public static void closeOverlay(){
        SelenideElement overlay = $(".overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            Selenide.executeJavaScript("document.getElementsByClassName('overlay')[0].style.visibility='hidden'");
        }
    }
}
