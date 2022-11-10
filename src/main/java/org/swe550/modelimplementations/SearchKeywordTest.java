package org.swe550.modelimplementations;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.SearchKeyword;
import org.swe550.util.CloseUtil;
import org.swe550.util.SearchKeywordUtil;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@GraphWalker(value = "random(edge_coverage(100))")
public class SearchKeywordTest extends ExecutionContext implements SearchKeyword {
    @Override
    public void v_SearchKeyword() {
    }

    @Override
    public void e_SearchInvalidKeyword() {
        SearchKeywordUtil.search("samsungsamsungsamsungsamsungsamsungsamsungsamsungsamsung");
    }

    @Override
    public void v_SearchInvalidKeyword() {
        $$("[data-testid=suggestion]").shouldHave(CollectionCondition.sizeLessThanOrEqual(50));
    }

    @Override
    public void e_SearchKeyword() {
    }

    @Override
    public void v_AddItemToFavorites() {
//        $("#login-register").shouldBe(Condition.visible);
    }

    @Override
    public void e_AddItemToFavorites() {
        SearchKeywordUtil.search("iphone");
        CloseUtil.closeOverlay();
        $(".fvrt-btn-wrppr").lastChild().click();
    }
}
