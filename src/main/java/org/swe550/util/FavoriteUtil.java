package org.swe550.util;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class FavoriteUtil {

    private static boolean executed = false;
    private static String itemTitle;

    public static void favoriteAnItem(String keyword) {
        if (!FavoriteUtil.executed) {
            SearchKeywordUtil.search(keyword);
            CloseUtil.closeOverlay();
            SelenideElement selectedElement = $(".fvrt-btn-wrppr").lastChild();
            selectedElement.click();
            FavoriteUtil.itemTitle = selectedElement.attr("title");
        }
    }

    public static void validateFavoriteBox() {
        if (!FavoriteUtil.executed) {
            $(".account-favorites").click();
            SelenideElement selectedElement = $(".p-card-chldrn-cntnr");
            selectedElement.shouldBe(exist);
            selectedElement.shouldBe(attribute("title", FavoriteUtil.itemTitle));
        }
    }

    public static void removeFromFavorites() {
        if (!FavoriteUtil.executed) {
            $(".ufvrt-btn-wrppr").click();
        }
    }

    public static void validateRemovedFavorite() {
        if (!FavoriteUtil.executed) {
            $(".p-card-chldrn-cntnr").shouldNotBe(exist);
            FavoriteUtil.executed = true;
        }
    }
}
