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

public class ValidationCardHolderTest {

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
    public void shouldEnterValidName() {
        Page.fieldCardHolder.setValue("DIMA DIMOV");
        String actualContentsField = Page.fieldCardHolder.getValue();
        assertEquals("DIMA DIMOV", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillicName() {
        Page.fieldCardHolder.setValue("дима димов");
        String actualContentsField = Page.fieldCardHolder.getValue();
        assertEquals("", actualContentsField);
    }


    @Test
    public void shouldEnterNumbers() {
        Page.fieldCardHolder.setValue("123456789");
        String actualContentsField = Page.fieldCardHolder.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        Page.fieldCardHolder.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = Page.fieldCardHolder.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldSendFormWithInvalidName() {
        Page.fieldCardHolder.setValue("DIMADIMOV");
        Page.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        Page.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        Page.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        Page.buttonNext.click();
        Page.checkCardHolderFormat();
    }
}
