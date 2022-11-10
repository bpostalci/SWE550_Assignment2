package org.swe550.modelimplementations;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.Basket;

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
        // TODO
    }

    @Override
    public void e_RemoveItemFromBasket() {
        // TODO
    }
}
