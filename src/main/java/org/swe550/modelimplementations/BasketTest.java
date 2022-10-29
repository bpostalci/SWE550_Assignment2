package org.swe550.modelimplementations;

import com.codeborne.selenide.Condition;
import org.graphwalker.core.machine.ExecutionContext;
import org.swe550.Basket;

import static com.codeborne.selenide.Selenide.$;

public class BasketTest extends ExecutionContext implements Basket {
    @Override
    public void e_GoToBasket() {
    }

    @Override
    public void v_GoToBasket() {
    }

    @Override
    public void v_DiscountCoupons() {
        $("#login-register").shouldBe(Condition.visible);
    }

    @Override
    public void e_DiscountCoupons() {
        $(".header-top>ul>li>a").click();
    }
}
