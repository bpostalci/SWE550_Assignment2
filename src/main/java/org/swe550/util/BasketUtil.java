package org.swe550.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class BasketUtil {
    private static boolean executed = false;
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

}
