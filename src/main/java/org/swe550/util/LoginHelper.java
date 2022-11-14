package org.swe550.util;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginHelper {
    private static boolean authenticated = false;

    public static void login() throws InterruptedException {
        String email = System.getenv("trendyol.email");
        String password = System.getenv("trendyol.password");
        $(".account-user").click();
        $("#login-email").setValue(email);
        $("#login-password-input").setValue(password);
        $(".submit").click();
        new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOf($(".q-loader")));

        LoginHelper.authenticated = true;
    }

    public static boolean isAuthenticated() {
        return authenticated;
    }
}
