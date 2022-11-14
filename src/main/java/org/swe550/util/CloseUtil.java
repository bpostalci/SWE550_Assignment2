package org.swe550.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CloseUtil {
    public static void closePopUp() {
        SelenideElement closePopup = $(".modal-content .modal-close");
        if (closePopup.exists() && closePopup.isDisplayed()) {
            closePopup.click();
        }
    }

    public static void closeLoader(){
        SelenideElement loader = $(".q-loader");
        if (loader.exists() && loader.isDisplayed()) {
            Selenide.executeJavaScript("document.getElementsByClassName('q-loader')[0].style.visibility='hidden'");
        }
    }

    public static void closeOverlay(){
        SelenideElement overlay = $(".overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            Selenide.executeJavaScript("document.getElementsByClassName('overlay')[0].style.visibility='hidden'");
        }
    }

    public static void closeOnBoardingOverlay(){
        SelenideElement overlay = $(".onboarding-overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            Selenide.executeJavaScript("document.getElementsByClassName('onboarding-overlay')[0].style.visibility='hidden'");
        }
    }
}
