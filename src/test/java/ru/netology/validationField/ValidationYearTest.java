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
        HeaderPage.clickCredit();
    }

    @Test
    public void shouldEnterLatin() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.latinLetters(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkYear();
    }

    @Test
    public void shouldEnterCyrillic() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.cyrillicLetters(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkYear();
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.symbols(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkYear();
    }

    @Test
    public void shouldSendFormWith1Number() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.with1Numbers(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkYear();
    }

    @Test
    public void shouldSendFormWithYearExpiredPeriod() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidMonth(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkYearExpiredPeriod();
    }
}
