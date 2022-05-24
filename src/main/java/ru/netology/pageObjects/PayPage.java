package ru.netology.pageObjects;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class PayPage {
    private static SelenideElement fieldCardNumber = Selenide.$("[placeholder='0000 0000 0000 0000']");
    private static SelenideElement invalidCardNumber = Selenide.$x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[3]");
    private static SelenideElement fieldMonth = Selenide.$("[placeholder='08']");
    private static SelenideElement invalidMonth = Selenide.$x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[3]");
    private static SelenideElement fieldYear = Selenide.$("[placeholder='22']");
    private static SelenideElement invalidYear = Selenide.$x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]");
    private static SelenideElement fieldCardHolder = Selenide.$x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private static SelenideElement invalidCardHolder = Selenide.$x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[3]");
    private static SelenideElement fieldCvC = Selenide.$("[placeholder='999']");
    private static SelenideElement invalidCvC = Selenide.$x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]");
    private static SelenideElement buttonNext = Selenide.$(Selectors.withText("Продолжить"));
    private static SelenideElement notificationTitleOk = Selenide.$(".notification_status_ok .notification__title");
    private static SelenideElement notificationContentOk = Selenide.$(".notification_status_ok .notification__content");
    private static SelenideElement notificationTitleError = Selenide.$(".notification_status_error .notification__title");
    private static SelenideElement notificationContentError = Selenide.$(".notification_status_error .notification__content");
    private static SelenideElement closeNotificationContentError = Selenide.$x("//*[@id=\"root\"]/div/div[3]/button/span/span/span");

    public static void checkCardNumber() {
        invalidCardNumber.shouldBe(visible).shouldHave(text("Неверный формат"));
    }

    public static void checkMonthFormat() {
        invalidMonth.shouldBe(visible).shouldHave(text("Неверный формат"));
    }

    public static void checkMonthInvalidPeriod() {
        invalidMonth.shouldBe(visible).shouldHave(text("Неверно указан срок действия карты"));
    }

    public static void checkYear() {
        invalidYear.shouldBe(visible).shouldHave(text("Неверный формат"));
    }

    public static void checkYearExpiredPeriod() {
        invalidYear.shouldBe(visible).shouldHave(text("Истёк срок действия карты"));
    }

    public static void checkCardHolderFormat() {
        invalidCardHolder.shouldBe(visible).shouldHave(text("Неверный формат"));
    }

    public static void checkCardHolderEmpty() {
        invalidCardHolder.shouldBe(visible).shouldHave(text("Поле обязательно для заполнения"));
    }

    public static void checkCvC() {
        invalidCvC.shouldBe(visible).shouldHave(text("Неверный формат"));
    }

    public static void checkNotificationTitleOk() {
        notificationTitleOk.should(appear, Duration.ofSeconds(15));
        notificationTitleOk.shouldBe(visible).shouldHave(text("Успешно"));
        notificationContentOk.shouldBe(visible).shouldHave(text("Операция одобрена Банком."));
    }

    public static void checkNotificationTitleError() {
        notificationTitleError.should(appear, Duration.ofSeconds(15));
        notificationTitleError.shouldBe(visible).shouldHave(text("Ошибка"));
        notificationContentError.shouldBe(visible).shouldHave(text("Ошибка! Банк отказал в проведении операции."));
    }

    public static PayPage getApprovedCard() {
        fieldCardNumber.setValue(DataHelper.getApprovedCard().getNumberCard());
        fieldMonth.setValue(DataHelper.getApprovedCard().getMonthCard());
        fieldYear.setValue(DataHelper.getApprovedCard().getYearCard());
        fieldCardHolder.setValue(DataHelper.getApprovedCard().getCardHolder());
        fieldCvC.setValue(DataHelper.getApprovedCard().getCvcCard());
        buttonNext.click();
        return new PayPage();
    }

    public static PayPage getDeclinedCard() {
        fieldCardNumber.setValue(DataHelper.getDeclinedCard().getNumberCard());
        fieldMonth.setValue(DataHelper.getDeclinedCard().getMonthCard());
        fieldYear.setValue(DataHelper.getDeclinedCard().getYearCard());
        fieldCardHolder.setValue(DataHelper.getDeclinedCard().getCardHolder());
        fieldCvC.setValue(DataHelper.getDeclinedCard().getCvcCard());
        buttonNext.click();
        return new PayPage();
    }

    public static PayPage getNotTestCard() {
        fieldCardNumber.setValue(DataHelper.getNotTestCard().getNumberCard());
        fieldMonth.setValue(DataHelper.getNotTestCard().getMonthCard());
        fieldYear.setValue(DataHelper.getNotTestCard().getYearCard());
        fieldCardHolder.setValue(DataHelper.getNotTestCard().getCardHolder());
        fieldCvC.setValue(DataHelper.getNotTestCard().getCvcCard());
        PayPage.clickNext();
        return new PayPage();
    }

    public static PayPage clickNext() {
        buttonNext.click();
        return new PayPage();
    }

    public static PayPage closeNotificationContentError() {
        closeNotificationContentError.click();
        return new PayPage();
    }

    public static PayPage setLatinLetters() {
        fieldCardHolder.setValue(DataHelper.latinLetters());
        return new PayPage();
    }

    public static String getLatinLetters() {
        String LatinLetters = String.valueOf(fieldCardHolder.getValue());
        return LatinLetters;
    }
    public static PayPage setCyrilicLetters() {
        fieldCardHolder.setValue(DataHelper.cyrillicLetters());
        return new PayPage();
    }

    public static String getCyrilicLetters() {
        String CyrilicLetters = String.valueOf(fieldCardHolder.getValue());
        return CyrilicLetters;
    }
}
