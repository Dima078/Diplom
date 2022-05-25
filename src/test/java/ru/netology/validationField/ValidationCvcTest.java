package ru.netology.validationField;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pageObjects.HeaderPage;
import ru.netology.pageObjects.PayPage;

import static com.codeborne.selenide.Selenide.open;

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
        HeaderPage.clickCredit();
    }

    @Test
    public void shouldEnterInvalidCvc() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getInvalidCvc());
        PayPage.clickButtonNext();
        PayPage.checkCvC();
    }

    @Test
    public void shouldEnterLatin() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.latinLetters());
        PayPage.clickButtonNext();
        PayPage.checkCvC();
    }

    @Test
    public void shouldEnterCyrillic() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.cyrillicLetters());
        PayPage.clickButtonNext();
        PayPage.checkCvC();
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.symbols());
        PayPage.clickButtonNext();
        PayPage.checkCvC();
    }

    @Test
    public void shouldSendFormWith2Numbers() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidMonth());
        PayPage.clickButtonNext();
        PayPage.checkCvC();
    }
}
