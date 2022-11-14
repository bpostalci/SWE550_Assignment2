package org.swe550.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class BasketAddFavoritesUtil {
    private static boolean executed = false;

    public static void addNewItemToBasket(String keyword) {
        if (!BasketAddFavoritesUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();

            SearchKeywordUtil.search(keyword);
            CloseUtil.closeOverlay();
            $(".fvrt-btn-wrppr").lastChild().click();
            $(".account-favorites").click();
            new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(60))
                    .until(ExpectedConditions.visibilityOf($(".basket-button")));

            $(".basket-button").click();
        }
    }

    public static void validateNewItemAddedToBasket() {
        if (!BasketAddFavoritesUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();

            $(".account-basket").click();
            $(".pb-basket-item").shouldBe(Condition.exist);

            CloseUtil.closeTooltip();
        }
    }

    public static void removeFromBasketAddToFavorites() {
        if (!BasketAddFavoritesUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();
            CloseUtil.closeTooltip();

            $(".account-basket").click();
            $(".pb-basket-item").shouldBe(Condition.exist);

            CloseUtil.closeTooltip();

            $(".i-trash").click();
            new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(60))
                    .until(ExpectedConditions.visibilityOf($(".pb-item-remove-confirmation-modal")));
            WebElement silButton =
                    Selenide.webdriver().object().findElement(By.xpath("//button[text()='Sil ve Favorilere Ekle']"));
            silButton.click();
        }
    }

    public static void validateAddToFavorites() {
        if (!BasketAddFavoritesUtil.executed) {
            CloseUtil.closeOnBoardingOverlay();
            CloseUtil.closeOverlay();
            CloseUtil.closeTooltip();

            $(".account-favorites").click();
            $(".p-card-chldrn-cntnr").shouldBe(exist);
            $(".ufvrt-btn-wrppr").click();

            BasketAddFavoritesUtil.executed = true;
        }
    }
}
