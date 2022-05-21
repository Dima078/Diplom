package ru.netology.validationField;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pageObjects.Page;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationCvcTest {

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
    public void shouldEnterValidCvC() {
        Page.fieldCvC.setValue("123");
        String actualContentsField = Page.fieldCvC.getValue();
        assertEquals("123", actualContentsField);
    }

    @Test
    public void shouldEnterMore3Numbers() {
        Page.fieldCvC.setValue("123456");
        String actualContentsField = Page.fieldCvC.getValue();
        assertEquals("123", actualContentsField);
    }

    @Test
    public void shouldEnterLatin() {
        Page.fieldCvC.setValue("qwer");
        String actualContentsField = Page.fieldCvC.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        Page.fieldCvC.setValue("номер");
        String actualContentsField = Page.fieldCvC.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        Page.fieldCvC.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = Page.fieldCvC.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWith2Numbers() {
        Page.fieldCvC.setValue("12");
        Page.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        Page.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        Page.buttonNext.click();
        Page.checkCvC();
    }
}
