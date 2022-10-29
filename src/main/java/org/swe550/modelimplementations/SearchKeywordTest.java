package org.swe550.modelimplementations;

import com.codeborne.selenide.Condition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.SearchKeyword;
import org.swe550.util.PopUpCloseUtil;
import org.swe550.util.SearchKeywordUtil;

import static com.codeborne.selenide.Selenide.$;

@GraphWalker(value = "random(edge_coverage(100))")
public class SearchKeywordTest extends ExecutionContext implements SearchKeyword {
    @Override
    public void v_SearchKeyword() {
        PopUpCloseUtil.closePopUp();
        $(".dscrptn").shouldBe(Condition.visible);
    }

    @Override
    public void e_SearchTooLongString() {
        PopUpCloseUtil.closePopUp();
        SearchKeywordUtil.search("samsungsamsungsamsungsamsungsamsungsamsungsamsungsamsung");
    }

    @Override
    public void v_SearchTooLongString() {
        PopUpCloseUtil.closePopUp();
        $("[data-testid=suggestion]").shouldNotHave(Condition.value("samsungsamsungsamsungsamsungsamsungsamsungsamsungsamsung"));
        $("[data-testid=suggestion]").shouldHave(Condition.value("samsungsamsungsamsungsamsungsamsungsamsungsamsungs"));
    }
}
