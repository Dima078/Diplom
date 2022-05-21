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

public class ValidationCardNumberTest {

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
    public void shouldEnterValidNumber() {
        Page.fieldCardNumber.setValue("4444444444444444");
        String actualContentsField = Page.fieldCardNumber.getValue();
        assertEquals("4444 4444 4444 4444", actualContentsField);
    }

    @Test
    public void shouldEnterMore16Numbers() {
        Page.fieldCardNumber.setValue("1111 2222 3333 4444 5555");
        String actualContentsField = Page.fieldCardNumber.getValue();
        assertEquals("1111 2222 3333 4444", actualContentsField);
    }

    @Test
    public void shouldEnterLatin() {
        Page.fieldCardNumber.setValue("qwery");
        String actualContentsField = Page.fieldCardNumber.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        Page.fieldCardNumber.setValue("номер");
        String actualContentsField = Page.fieldCardNumber.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        Page.fieldCardNumber.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = Page.fieldCardNumber.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWithInvalidNumber() {
        Page.fieldCardNumber.setValue("4444");
        Page.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        Page.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        Page.buttonNext.click();
        Page.checkCardNumber();
    }
}
