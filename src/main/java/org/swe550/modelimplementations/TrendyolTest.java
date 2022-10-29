package org.swe550.modelimplementations;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.Trendyol;
import org.swe550.util.PopUpCloseUtil;
import org.swe550.util.SearchKeywordUtil;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowser")
public class TrendyolTest extends ExecutionContext implements Trendyol {
    @Override
    public void v_HomePage() {

        PopUpCloseUtil.closePopUp();


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
        open("https://www.trendyol.com/");
    }

    @Override
    public void v_SearchKeyword() {

    }

    @Override
    public void e_SearchKeyword() {
        PopUpCloseUtil.closePopUp();

        SearchKeywordUtil.search("iphone");
    }

    @Override
    public void e_StartBrowser() {
        open("https://www.trendyol.com/");
    }

    @BeforeExecution
    public void setup() {
        browser = "chrome";
    }
}
