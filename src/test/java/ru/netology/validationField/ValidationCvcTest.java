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

public class ValidationCvcTest {

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
    public void shouldEnterValidCvC() {
        PayPage.fieldCvC.setValue("123");
        String actualContentsField = PayPage.fieldCvC.getValue();
        assertEquals("123", actualContentsField);
    }

    @Test
    public void shouldEnterMore3Numbers() {
        PayPage.fieldCvC.setValue("123456");
        String actualContentsField = PayPage.fieldCvC.getValue();
        assertEquals("123", actualContentsField);
    }

    @Test
    public void shouldEnterLatin() {
        PayPage.fieldCvC.setValue("qwer");
        String actualContentsField = PayPage.fieldCvC.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        PayPage.fieldCvC.setValue("номер");
        String actualContentsField = PayPage.fieldCvC.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.fieldCvC.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = PayPage.fieldCvC.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWith2Numbers() {
        PayPage.fieldCvC.setValue("12");
        PayPage.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        PayPage.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.buttonNext.click();
        PayPage.checkCvC();
    }*/
}
