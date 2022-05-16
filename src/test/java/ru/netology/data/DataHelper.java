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
}