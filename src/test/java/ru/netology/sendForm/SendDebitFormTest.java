package ru.netology.sendForm;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.Database;
import ru.netology.pageObjects.HeaderPage;
import ru.netology.pageObjects.PayPage;

import static com.codeborne.selenide.Selenide.open;

public class SendDebitFormTest {

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
        HeaderPage.clickDebit();
    }

    @Test
    public void shouldBuyApprovedCard() {
        PayPage.emptyForm(DataHelper.getApprovedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkNotificationTitleOk();
        Database.checkApprovedBuy();
    }

    @Test
    public void shouldBuyDeclinedCard() {
        PayPage.emptyForm(DataHelper.getDeclinedNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkNotificationTitleError();
        Database.checkDeclinedBuy();
    }

    @Test
    public void shouldBuyNotTestCard() {
        PayPage.emptyForm(DataHelper.getNotTestCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkNotificationTitleError();
    }

    @Test
    public void shouldSendEmptyForm() {
        PayPage.clickButtonNext();
        PayPage.checkCardNumber();
        PayPage.checkMonthFormat();
        PayPage.checkYear();
        PayPage.checkCardHolderEmpty();
        PayPage.checkCvC();
    }

    @Test
    public void shouldClosedNotificationContentError() {
        PayPage.emptyForm(DataHelper.getNotTestCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkNotificationTitleError();
        PayPage.clickcloseNotificationContentError();
        PayPage.checkNotificationTitleOk();
    }

    @Test
    public void shouldCheckingMessagesErrors() {
        PayPage.clickButtonNext();
        PayPage.emptyForm(DataHelper.getNotTestCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.latinLetters(),
                DataHelper.getValidCvc());
        PayPage.clickButtonNext();
        PayPage.checkNotificationTitleOk();
        PayPage.checkCardNumber();
        PayPage.checkCardHolderEmpty();
        PayPage.checkCvC();
    }
}
