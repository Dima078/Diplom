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

import java.util.logging.Handler;

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
        HeaderPage.clickCredit();
    }

    @Test
    public void shouldEnterValidName() {
        PayPage.setLatinLetters();
        String actualContentsField = PayPage.getLatinLetters();
        assertEquals("DIMA DIMOV", actualContentsField);
    }

    @Test
    public void shouldEnterCyrillicName() {
        PayPage.setCyrilicLetters();
        String actualContentsField = PayPage.getCyrilicLetters();
        assertEquals("", actualContentsField);
    }

    /*@Test
    public void shouldEnterNumbers() {
        PayPage.fieldCardHolder.setValue("123456789");
        String actualContentsField = PayPage.fieldCardHolder.getValue();
        assertEquals("", actualContentsField);
    }

    @Test
    public void shouldEnterSymbols() {
        PayPage.fieldCardHolder.setValue("!@#$%^&*()_+/-,. `~");
        String actualContentsField = PayPage.fieldCardHolder.getValue();
        assertEquals("", actualContentsField);
    }*/
}
