package com.nazjara.model;

import java.io.Serializable;

public class Billing implements Serializable {
    private final static long serialVersionUID = 1L;

    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
