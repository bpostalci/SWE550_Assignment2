package org.swe550.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class FavoriteItemUtil {

    private static boolean executed = false;
    private static String itemTitle;

    public static void favoriteAnItem(String keyword) {
        if (!FavoriteItemUtil.executed) {
            SearchKeywordUtil.search(keyword);
            CloseUtil.closeOverlay();
            SelenideElement selectedElement = $(".fvrt-btn-wrppr").lastChild();
            selectedElement.click();
            FavoriteItemUtil.itemTitle = selectedElement.attr("title");
        }
    }

    public static void validateFavoriteBox() {
        if (!FavoriteItemUtil.executed) {
            $(".account-favorites").click();
            SelenideElement selectedElement = $(".p-card-chldrn-cntnr");
            selectedElement.shouldBe(exist);
            selectedElement.shouldBe(attribute("title", FavoriteItemUtil.itemTitle));

            FavoriteItemUtil.executed = true;
        }
    }
}
