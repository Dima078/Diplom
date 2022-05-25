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
        HeaderPage.clickCredit();
    }

    @Test
    public void shouldEnterLatinName() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkNotificationTitleOk();
    }

    @Test
    public void shouldEnterCyrillicName() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.cyrillicLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkCardHolderFormat();
    }

    @Test
    public void shouldEnterNumbers() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.numbers(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkCardHolderFormat();
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.symbols(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkCardHolderFormat();
    }

    @Test
    public void shouldEmptyField() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.empty(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkCardHolderEmpty();
    }
}
