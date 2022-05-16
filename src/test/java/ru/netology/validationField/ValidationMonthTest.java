package ru.netology.validationField;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.Page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationMonthTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openBrowser() {
        open("http://localhost:8080/");
        Page.buttonDebit.click();
    }

    @Test
    public void shouldEnterValidMonth() {
        Page.fieldMonth.setValue("05");
        String actualContentsField = Page.fieldMonth.getValue();
        assertEquals("05", actualContentsField);
    }

    @Test
    public void shouldEnterMore2Numbers() {
        Page.fieldMonth.setValue("1234");
        String actualContentsField = Page.fieldMonth.getValue();
        assertEquals("12", actualContentsField);
    }

    @Test
    public void shouldEnterLatinh() {
        Page.fieldMonth.setValue("qwert");
        String actualContentsField = Page.fieldMonth.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        Page.fieldMonth.setValue("йцуе");
        String actualContentsField = Page.fieldMonth.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        Page.fieldMonth.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = Page.fieldMonth.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWith1Number() {
        Page.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        Page.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        Page.fieldMonth.setValue("0");
        Page.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        Page.buttonNext.click();
        Page.invalidMonth.shouldBe(visible).shouldHave(text("Неверный формат"));
    }
}
