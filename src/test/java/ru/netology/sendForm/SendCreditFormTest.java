package ru.netology.sendForm;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.Database;
import ru.netology.pageObjects.Page;

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
        Page.buttonCredit.click();
    }

    @Test
    public void shouldBuyApprovedCard() {
        Page.fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        Page.fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        Page.fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        Page.buttonNext.click();
        Page.checkNotificationTitleOk();
        Database.checkApprovedBuyTourCredit();
    }

    @Test
    public void shouldBuyDeclinedCard() {
        Page.fieldCardNumber.setValue(DataHelper.getDeclinedCard().getNumberCard());
        Page.fieldMonth.setValue(DataHelper.getDeclinedCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getDeclinedCard().getYearCard());
        Page.fieldCardHolder.setValue(DataHelper.getDeclinedCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getDeclinedCard().getCvcCard());
        Page.buttonNext.click();
        Page.checkNotificationTitleError();
        Database.checkDeclinedBuyTourCredit();
    }

    @Test
    public void shouldBuyNotTestCard() {
        Page.fieldCardNumber.setValue(DataHelper.getNotTestCard().getNumberCard());
        Page.fieldMonth.setValue(DataHelper.getNotTestCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getNotTestCard().getYearCard());
        Page.fieldCardHolder.setValue(DataHelper.getNotTestCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getNotTestCard().getCvcCard());
        Page.buttonNext.click();
        Page.checkNotificationTitleError();
    }

    @Test
    public void shouldSendEmptyForm() {
        Page.buttonNext.click();
        Page.checkCardNumber();
        Page.checkMonthFormat();
        Page.checkYear();
        Page.checkCardHolderEmpty();
        Page.checkCvC();
    }

    @Test
    public void shouldClosedNotificationContentError() {
        Page.fieldCardNumber.setValue(DataHelper.getNotTestCard().getNumberCard());
        Page.fieldMonth.setValue(DataHelper.getNotTestCard().getMonthCard());
        Page.fieldYear.setValue(DataHelper.getNotTestCard().getYearCard());
        Page.fieldCardHolder.setValue(DataHelper.getNotTestCard().getCardHolder());
        Page.fieldCvC.setValue(DataHelper.getNotTestCard().getCvcCard());
        Page.buttonNext.click();
        Page.checkNotificationTitleError();
        Page.closeNotificationContentError.click();
        Page.checkNotificationTitleOk();
    }
}
