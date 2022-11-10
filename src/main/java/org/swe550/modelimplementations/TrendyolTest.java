package org.swe550.modelimplementations;

import com.codeborne.selenide.CollectionCondition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.Trendyol;
import org.swe550.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowserAndLogin")
public class TrendyolTest extends ExecutionContext implements Trendyol {
    @Override
    public void v_HomePage() {

        CloseUtil.closePopUp();


        $("#navigation-wrapper").shouldHave(
                text("KADIN"),
                text("ERKEK"),
                text("ANNE & ÇOCUK"),
                text("EV & MOBILYA"),
                text("SÜPERMARKET"),
                text("KOZMETIK"),
                text("AYAKKABI & ÇANTA"),
                text("SAAT & AKSESUAR"),
                text("ELEKTRONIK"),
                text("SPOR&OUTDOOR")
        );
        $("#account-navigation-container").shouldBe(visible);
        $("#autoCompleteAppWrapper").shouldBe(visible);
        $("#logo").shouldBe(visible);
    }

    @Override
    public void e_HomePage() {
    }

    @Override
    public void v_SearchKeyword() {
        $$("[data-testid=suggestion]").shouldHave(CollectionCondition.sizeLessThanOrEqual(50));
    }

    @Override
    public void e_SearchKeyword() {
        SearchKeywordUtil.search("samsung");
    }

    @Override
    public void e_StartBrowserAndLogin() {
        open("https://www.trendyol.com/");
        CloseUtil.closePopUp();
        if (!LoginHelper.isAuthenticated()) {
            try {
                LoginHelper.login();
            } catch (Exception e) {
                System.err.println(e);
            }

        }
    }

    @Override
    public void e_AddItemToFavorites() {
        FavoriteItemUtil.favoriteAnItem("dell monitor");
    }

    @Override
    public void v_AddToFavorites() {
        FavoriteItemUtil.validateFavoriteBox();
    }

    @Override
    public void e_AddToBasket() {
        BasketUtil.addItemToBasket("iphone");
    }

    @Override
    public void v_AddToBasket() {
        BasketUtil.validateBasket();
    }

    @BeforeExecution
    public void setup() {
        browser = "chrome";
    }
}
