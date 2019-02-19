package com.example.devanshjatinponda.wintactoe;

public enum Player {
    HUMAN, COMPUTER;
    public Player invert() {
        if (this == HUMAN) {
            return COMPUTER;
        } else {
            return HUMAN;
        }
    }
}
