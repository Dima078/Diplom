package ru.netology.validationField;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pageObjects.PayPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationYearTest {

    /*@BeforeAll
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
        PayPage.buttonDebit.click();
    }

    @Test
    public void shouldEnterValidYear() {
        PayPage.fieldYear.setValue("23");
        String actualContentsField = PayPage.fieldYear.getValue();
        assertEquals("23", actualContentsField);
    }

    @Test
    public void shouldEnterMore2Numbers() {
        PayPage.fieldYear.setValue("1234");
        String actualContentsField = PayPage.fieldYear.getValue();
        assertEquals("12", actualContentsField);
    }

    @Test
    public void shouldEnterLatin() {
        PayPage.fieldYear.setValue("qwert");
        String actualContentsField = PayPage.fieldYear.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        PayPage.fieldYear.setValue("год");
        String actualContentsField = PayPage.fieldYear.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.fieldYear.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = PayPage.fieldYear.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWith1Number() {
        PayPage.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        PayPage.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        PayPage.fieldYear.setValue("2");
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        PayPage.buttonNext.click();
        PayPage.checkYear();
    }

    @Test
    public void shouldSendFormWithYearExpiredPeriod() {
        PayPage.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        PayPage.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        PayPage.fieldYear.setValue("12");
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        PayPage.buttonNext.click();
        PayPage.checkYearExpiredPeriod();
    }*/
}
