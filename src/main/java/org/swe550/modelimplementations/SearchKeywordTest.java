package org.swe550.modelimplementations;

import org.graphwalker.core.machine.ExecutionContext;
import org.swe550.SearchKeyword;

public class SearchKeywordTest extends ExecutionContext implements SearchKeyword {
    @Override
    public void v_SearchKeyword() {
        System.out.println("yes");
    }
}
