package org.swe550.modelimplementations;

import com.codeborne.selenide.Condition;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.swe550.Basket;
import org.swe550.util.OverlayCloseUtil;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@GraphWalker(value = "random(edge_coverage(100))")
public class BasketTest extends ExecutionContext implements Basket {
    @Override
    public void e_GoToBasket() {
        OverlayCloseUtil.closeOverlay();
        $(".account-basket").click();
    }

    @Override
    public void v_GoToBasket() {
        $("#basket-app-container").shouldBe(visible);
    }

    @Override
    public void v_DiscountCoupons() {
        $("#login-register").shouldBe(Condition.visible);
    }

    @Override
    public void e_DiscountCoupons() {
        OverlayCloseUtil.closeOverlay();
        $(".header-top>ul>li>a").click();
    }
}
