package org.swe550.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CloseUtil {
    public static void closePopUp() {
        SelenideElement closePopup = $(".modal-content .modal-close");
        if (closePopup.exists() && closePopup.isDisplayed()) {
            closePopup.click();
        }
    }

    public static void closeOverlay() {
        SelenideElement overlay = $(".overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            $("[data-testid=search-icon]").click();
        }
    }

    public static void closeOnBoardingOverlay() {
        SelenideElement overlay = $(".onboarding-overlay");
        if (overlay.exists() && overlay.isDisplayed()) {
            $("[data-testid=search-icon]").click();
        }
    }

    public static void closeTooltip() {
        SelenideElement tooltipBtn = $(".tooltip-content>button");
        if (tooltipBtn.exists()) {
            tooltipBtn.click();
        }
    }
}
