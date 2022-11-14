package org.swe550.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BasketUtil {
    private static boolean executed = false;
    private static boolean removeExecuted = false;
    private static String itemTitle;


    public static void addItemToBasket(String keyword) {
        if (!BasketUtil.executed) {
            SearchKeywordUtil.search(keyword);
            CloseUtil.closeOverlay();
            $(".fvrt-btn-wrppr").lastChild().click();

            $(".account-favorites").click();
            $(".basket-button").click();

//            SelenideElement selectedElement = $(".prdct-desc-cntnr-name");
//            BasketUtil.itemTitle = selectedElement.attr("title");
        }
    }


    public static void validateBasket() {
        if (!BasketUtil.executed) {
            $(".account-basket").click();
            $(".pb-basket-item").shouldBe(Condition.exist);

            SelenideElement tooltipBtn = $(".tooltip-content>button");
            if (tooltipBtn.exists()) {
                tooltipBtn.click();
            }
            BasketUtil.executed = true;
        }
    }


    public static void removeItemFromBasket() {
        if (!BasketUtil.removeExecuted) {
            $(".account-basket").click();
            $(".pb-basket-item").shouldBe(Condition.exist);
            SelenideElement tooltipBtn = $(".tooltip-content>button");
            if (tooltipBtn.exists()) {
                tooltipBtn.click();
            }

            $(".i-trash").click();
            new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(3));
            WebElement silButton = Selenide.webdriver().object().findElement(By.xpath("//button[text()='Sil']"));
            silButton.click();
        }
    }

    public static void validateRemovedItem() {
        if (!BasketUtil.removeExecuted) {
            $(".pb-basket-item").shouldNotBe(Condition.exist);
            BasketUtil.removeExecuted = true;
        }
    }
}
