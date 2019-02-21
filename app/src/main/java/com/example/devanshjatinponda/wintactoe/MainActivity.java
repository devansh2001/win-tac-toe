package com.example.devanshjatinponda.wintactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttons[][];
    private int operated;
    private Player currPlayer;

    private void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    private boolean isOver() {
        return operated != 9;
    }

    private boolean checkWon() {
        for (int i = 0; i < 3; i++) {
                if ((!buttons[i][0].equals(""))
                        && buttons[i][0].getText().equals(buttons[i][1].getText())
                        && buttons[i][0].getText().equals(buttons[i][2].getText())) {
                    Toast.makeText(this, "One", Toast.LENGTH_SHORT).show();
                    return true;
                }
        }
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText())
                    && buttons[0][i].getText().equals(buttons[2][i].getText())
                    && !buttons[0][i].equals("")) {
                Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        if (!buttons[0][0].getText().equals("")
                && !buttons[1][1].getText().equals("")
                && !buttons[2][2].getText().equals("")
                && buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[0][0].getText().equals(buttons[2][2].getText())) {
            Toast.makeText(this, "Three", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (!buttons[0][2].getText().equals("")
                && !buttons[1][1].getText().equals("")
                && !buttons[2][0].getText().equals("")
                && buttons[0][2].getText().equals(buttons[1][1].getText())
                && buttons[2][0].getText().equals(buttons[1][1].getText())) {
            Toast.makeText(this, "Four", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonArray[][] = {
                {
                        findViewById(R.id.button1),
                        findViewById(R.id.button2),
                        findViewById(R.id.button3)
                },
                {
                        findViewById(R.id.button4),
                        findViewById(R.id.button5),
                        findViewById(R.id.button6)
                },
                {
                        findViewById(R.id.button7),
                        findViewById(R.id.button8),
                        findViewById(R.id.button9)
                }
        };
        this.buttons = buttonArray;
        clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j].setOnClickListener(this);
            }
        }

        Random random = new Random();
        if (random.nextInt(10) < 5) {
            currPlayer = Player.COMPUTER;
        } else {
            currPlayer = Player.HUMAN;
        }
        Toast.makeText(this, "Player: " + currPlayer, Toast.LENGTH_SHORT).show();

//        while (!isOver()) {
//            if (random.nextInt(10) < 5) {
//                humanTurn = true;
//            } else {
//                humanTurn = false;
//            }
//            if (humanTurn) {
//                humanPlay();
//            } else {
//                computerPlay();
//            }
//        }
    }

//    private void humanPlay() {
//
//    }
//
//    private void computerPlay() {
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(MainActivity.this, "Button 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "Button 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(MainActivity.this, "Button 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(MainActivity.this, "Button 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                Toast.makeText(MainActivity.this, "Button 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                Toast.makeText(MainActivity.this, "Button 6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button7:
                Toast.makeText(MainActivity.this, "Button 7", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button8:
                Toast.makeText(MainActivity.this, "Button 8", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button9:
                Toast.makeText(MainActivity.this, "Button 9", Toast.LENGTH_SHORT).show();
                break;
            default:
                System.out.println("none");
        }

        Move move = new Move(currPlayer, (Button) findViewById(v.getId()));
            if (move.isValid()) {
                Toast.makeText(MainActivity.this, "Valid", Toast.LENGTH_SHORT).show();
                move.getCell().setText("X");
                if (!checkWon()) {
                    Toast.makeText(MainActivity.this, currPlayer + " wins!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "OVERRRRR", Toast.LENGTH_SHORT).show();
                    // End game
                } else {
                    currPlayer = currPlayer.invert();
                    if (currPlayer == Player.COMPUTER) {
                        // My logic
                        Toast.makeText(this, "Sup", Toast.LENGTH_SHORT).show();
                    }
                    currPlayer = currPlayer.invert();
                }
            } else {
                Toast.makeText(MainActivity.this, "Invalid Cell", Toast.LENGTH_SHORT).show();
            }
    }
}
