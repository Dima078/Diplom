package ru.netology.pageObjects;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage {
    private SelenideElement heading = $x("[//*[@id=\"root\"]/div/h2]");
    private static SelenideElement buttonDebit = Selenide.$(Selectors.withText("Купить"));
    private static SelenideElement buttonCredit = Selenide.$(Selectors.withText("Купить в кредит"));

    public HeaderPage() {
        heading.shouldBe(visible);
    }

    public static PayPage clickDebit() {
        buttonDebit.click();
        return new PayPage();
    }

    public static PayPage clickCredit() {
        buttonCredit.click();
        return new PayPage();
    }
}
