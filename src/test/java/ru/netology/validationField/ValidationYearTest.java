package ru.netology.validationField;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.Page;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationYearTest {

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
    public void shouldEnterValidYear() {
        Page.fieldYear.setValue("23");
        String actualContentsField = Page.fieldYear.getValue();
        assertEquals("23", actualContentsField);
    }

    @Test
    public void shouldEnterMore2Numbers() {
        Page.fieldYear.setValue("1234");
        String actualContentsField = Page.fieldYear.getValue();
        assertEquals("12", actualContentsField);
    }

    @Test
    public void shouldEnterLatin() {
        Page.fieldYear.setValue("qwert");
        String actualContentsField = Page.fieldYear.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        Page.fieldYear.setValue("год");
        String actualContentsField = Page.fieldYear.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        Page.fieldYear.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = Page.fieldYear.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWith1Number() {
        Page.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        Page.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        Page.fieldYear.setValue("2");
        Page.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        Page.buttonNext.click();
        Page.invalidYear.shouldBe(visible).shouldHave(text("Неверный формат"));
    }
}
