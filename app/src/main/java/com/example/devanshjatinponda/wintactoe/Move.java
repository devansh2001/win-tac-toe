package com.example.devanshjatinponda.wintactoe;

import android.widget.Button;

public class Move {
    Player player;
    Button cell;
    public Move (Player player, Button cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Button getCell() {
        return cell;
    }

    public void setCell(Button cell) {
        this.cell = cell;
    }

    public boolean isValid() {
        return cell.getText().equals("");
    }

}
