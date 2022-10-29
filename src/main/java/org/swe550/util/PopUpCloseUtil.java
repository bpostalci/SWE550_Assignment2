package org.swe550.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PopUpCloseUtil {
    public static void closePopUp() {
        SelenideElement closePopup = $(".modal-content .modal-close");
        if (closePopup.exists() && closePopup.isDisplayed()) {
            closePopup.click();
        }
    }
}
