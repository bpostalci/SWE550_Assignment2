package org.swe550.modelimplementations;

import com.codeborne.selenide.CollectionCondition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.ValidateSearchBar;
import org.swe550.util.SearchKeywordUtil;

import static com.codeborne.selenide.Selenide.$$;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ValidateSearchBarTest extends ExecutionContext implements ValidateSearchBar {
    @Override
    public void e_LongString2() {
        SearchKeywordUtil.search("aasafdsaflds;aaasafdsaflds;aaasafdsaflds;aaasafdsaflds;aaasafdsaflds;a" +
                "aasafdsaflds;aaasafdsaflds;aaasafdsaflds;aaasafdsaflds;aaasafdsaflds;aaasafdsaflds;a" +
                "aasafdsaflds;aaasafdsaflds;aaasafdsaflds;a");
    }

    @Override
    public void e_LongString1() {
        SearchKeywordUtil.search("<html>" +
                "<body></body>" +
                "</html>");
    }

    @Override
    public void v_ValidateSearchBar() {
        $$("[data-testid=suggestion]").shouldHave(CollectionCondition.sizeLessThanOrEqual(50));
    }

    @Override
    public void e_EmptyString() {
        SearchKeywordUtil.search("");
    }
}
