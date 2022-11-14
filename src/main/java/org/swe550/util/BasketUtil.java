package org.swe550.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BasketUtil {
    private static boolean executed = false;

    public static void addItemToBasket(String keyword) {
        if (!BasketUtil.executed) {
            SearchKeywordUtil.search(keyword);
            CloseUtil.closeOverlay();
            $(".fvrt-btn-wrppr").lastChild().click();

            $(".account-favorites").click();
            $(".basket-button").click();
        }
    }


    public static void validateBasket() {
        if (!BasketUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();

            $(".account-basket").click();
            new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(60))
                    .until(ExpectedConditions.visibilityOf($(".i-bagg")));
            $(".pb-basket-item").shouldBe(Condition.exist);

            SelenideElement tooltipBtn = $(".tooltip-content>button");
            if (tooltipBtn.exists()) {
                tooltipBtn.click();
            }
        }
    }


    public static void removeItemFromBasket() {
        if (!BasketUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();

            $(".account-basket").click();
            $(".pb-basket-item").shouldBe(Condition.exist);
            SelenideElement tooltipBtn = $(".tooltip-content>button");
            if (tooltipBtn.exists()) {
                tooltipBtn.click();
            }

            $(".i-trash").click();
            new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(60))
                    .until(ExpectedConditions.visibilityOf($(".pb-item-remove-confirmation-modal")));
            WebElement silButton = Selenide.webdriver().object().findElement(By.xpath("//button[text()='Sil']"));
            silButton.click();
        }
    }

    public static void validateRemovedItem() {
        if (!BasketUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();

            $(".pb-basket-item").shouldNotBe(Condition.exist);
            new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(60))
                    .until(ExpectedConditions.visibilityOf($(".account-favorites")));
            $(".account-favorites").click();
            SelenideElement unFvrtElement = $(".ufvrt-btn-wrppr");
            if (unFvrtElement.exists()) {
                unFvrtElement.click();
            }

            BasketUtil.executed = true;
        }
    }
}
