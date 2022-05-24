package ru.netology.sendForm;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Database;
import ru.netology.pageObjects.HeaderPage;
import ru.netology.pageObjects.PayPage;

import static com.codeborne.selenide.Selenide.open;

public class SendCreditFormTest {

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
    public void shouldBuyApprovedCard() {
        PayPage.getApprovedCard();
        PayPage.checkNotificationTitleOk();
        Database.checkApprovedBuyTourCredit();
    }

    @Test
    public void shouldBuyDeclinedCard() {
        PayPage.getDeclinedCard();
        PayPage.checkNotificationTitleError();
        Database.checkDeclinedBuyTourCredit();
    }

    @Test
    public void shouldBuyNotTestCard() {
        PayPage.getNotTestCard();
        PayPage.checkNotificationTitleError();
    }

    @Test
    public void shouldSendEmptyForm() {
        PayPage.clickNext();
        PayPage.checkCardNumber();
        PayPage.checkMonthFormat();
        PayPage.checkYear();
        PayPage.checkCardHolderEmpty();
        PayPage.checkCvC();
    }

    @Test
    public void shouldClosedNotificationContentError() {
        PayPage.getNotTestCard();
        PayPage.checkNotificationTitleError();
        PayPage.closeNotificationContentError();
        PayPage.checkNotificationTitleOk();
    }
}
