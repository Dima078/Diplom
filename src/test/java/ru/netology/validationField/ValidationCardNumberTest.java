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

public class ValidationCardNumberTest {

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
    public void shouldEnterValidNumber() {
        PayPage.fieldCardNumber.setValue("4444444444444444");
        String actualContentsField = PayPage.fieldCardNumber.getValue();
        assertEquals("4444 4444 4444 4444", actualContentsField);
    }

    @Test
    public void shouldEnterMore16Numbers() {
        PayPage.fieldCardNumber.setValue("1111 2222 3333 4444 5555");
        String actualContentsField = PayPage.fieldCardNumber.getValue();
        assertEquals("1111 2222 3333 4444", actualContentsField);
    }

    @Test
    public void shouldEnterLatin() {
        PayPage.fieldCardNumber.setValue("qwery");
        String actualContentsField = PayPage.fieldCardNumber.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillic() {
        PayPage.fieldCardNumber.setValue("номер");
        String actualContentsField = PayPage.fieldCardNumber.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.fieldCardNumber.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = PayPage.fieldCardNumber.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWithInvalidNumber() {
        PayPage.fieldCardNumber.setValue("4444");
        PayPage.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        PayPage.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        PayPage.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        PayPage.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        PayPage.buttonNext.click();
        PayPage.checkCardNumber();
    }*/
}
