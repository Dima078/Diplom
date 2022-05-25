package ru.netology.data;

public class DataHelper {

    public static String getApprovedNumber() {
        String numberCard = "4444444444444441";
        return numberCard;
    }

    public static String getDeclinedNumber() {
        String numberCard = "4444444444444442";
        return numberCard;
    }

    public static String getNotTestCardNumber() {
        String numberCard = "4444444444444444";
        return numberCard;
    }

    public static String getInvalidCardNumber() {
        String year = "11112222333";
        return year;
    }

    public static String getValidYear() {
        String year = "23";
        return year;
    }

    public static String getInvalidYear() {
        String year = "12";
        return year;
    }

    public static String getValidCvc() {
        String cvc = "123";
        return cvc;
    }

    public static String getInvalidCvc() {
        String cvc = "12";
        return cvc;
    }

    public static String getValidMonth() {
        String month = "06";
        return month;
    }

    public static String getInvalidMonth00() {
        String month = "00";
        return month;
    }

    public static String latinLetters() {
        String latin = "DIMA DIMOV";
        return latin;
    }

    public static String cyrillicLetters() {
        String cyrillic = "дима димов";
        return cyrillic;
    }

    public static String numbers() {
        String numbers = "231324";
        return numbers;
    }

    public static String with1Numbers() {
        String number = "1";
        return number;
    }

    public static String empty() {
        String empty = "";
        return empty;
    }

    public static String symbols() {
        String symbols = "!@#$%^&*()_+/-,. `~";
        return symbols;
    }
}