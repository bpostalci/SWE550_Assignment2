package org.swe550.modelimplementations;

import com.codeborne.selenide.CollectionCondition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.SearchKeyword;
import org.swe550.util.SearchKeywordUtil;

import static com.codeborne.selenide.Selenide.$$;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class SearchKeywordTest extends ExecutionContext implements SearchKeyword {
    @Override
    public void v_SearchKeyword() {
    }

    @Override
    public void e_SearchKeyword() {
    }

    @Override
    public void e_SearchAKeyword() {
        SearchKeywordUtil.search("samsungsamsungsamsungsamsungsamsungsamsungsamsungsamsung");
    }

    @Override
    public void v_SearchVariousKeywords() {
        $$("[data-testid=suggestion]").shouldHave(CollectionCondition.sizeLessThanOrEqual(50));
    }
}
