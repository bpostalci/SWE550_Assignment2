package org.swe550.modelimplementations;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.Basket;
import org.swe550.util.BasketUtil;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BasketTest extends ExecutionContext implements Basket {
    @Override
    public void e_GoToBasket() {
    }

    @Override
    public void v_AddToBasket() {
    }

    @Override
    public void v_RemoveFromBasket() {
        BasketUtil.validateRemovedItem();
    }

    @Override
    public void e_RemoveItemFromBasket() {
        BasketUtil.removeItemFromBasket();

    }
}
