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

public class ValidationMonthTest {

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
    public void shouldEnterValidMonth() {
        PayPage.fieldMonth.setValue("05");
        String actualContentsField = PayPage.fieldMonth.getValue();
        assertEquals("05", actualContentsField);
    }

    @Test
    public void shouldEnterMore2Numbers() {
        PayPage.fieldMonth.setValue("1234");
        String actualContentsField = PayPage.fieldMonth.getValue();
        assertEquals("12", actualContentsField);
    }

    @Test
    public void shouldEnterLatinh() {
        PayPage.fieldMonth.setValue("qwert");
        String actualContentsField = PayPage.fieldMonth.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        PayPage.fieldMonth.setValue("йцуе");
        String actualContentsField = PayPage.fieldMonth.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.fieldMonth.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = PayPage.fieldMonth.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWith1Number() {
        PayPage.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        PayPage.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        PayPage.fieldMonth.setValue("0");
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        PayPage.buttonNext.click();
        PayPage.checkMonthFormat();
    }

    @Test
    public void shouldSendFormWith00() {
        PayPage.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        PayPage.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        PayPage.fieldMonth.setValue("00");
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        PayPage.buttonNext.click();
        PayPage.checkMonthFormat();
    }

    @Test
    public void shouldSendFormWithInvalidMonth() {
        PayPage.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        PayPage.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        PayPage.fieldMonth.setValue("13");
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        PayPage.buttonNext.click();
        PayPage.checkMonthInvalidPeriod();
    }*/
}
