package ru.netology.data;

import lombok.Value;

public class DataHelper {

    @Value
    public static class Card {
        String numberCard;
        String monthCard;
        String yearCard;
        String cardHolder;
        String cvcCard;
    }

    public static Card getApprovedCard() {
        return new Card(
                "4444444444444441",
                "09",
                "23",
                "DIMA DIMOV",
                "123"
        );
    }

    public static Card getDeclinedCard() {
        return new Card(
                "4444444444444442",
                "09",
                "23",
                "DIMA DIMOV",
                "123"
        );
    }

    public static Card getNotTestCard() {
        return new Card(
                "4444444444444444",
                "09",
                "23",
                "DIMA DIMOV",
                "123"
        );
    }

    public static String latinLetters(){
        String latin = "DIMA DIMOV";
        return latin;
    }

    public static String cyrillicLetters(){
        String cyrillic = "дима димов";
        return cyrillic;
    }

    public static String numbers(){
        String numbers = "231324";
        return numbers;
    }

    public static String symbols(){
        String symbols = "!@#$%^&*()_+/-,. `~";
        return symbols;
    }
}