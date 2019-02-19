package com.example.devanshjatinponda.wintactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttons[][];
    private int operated;
    private boolean humanTurn;

    private void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
    private boolean isValid(Button button) {
        return button.getText().equals("");
    }
    private boolean isOver() {
        return operated != 9;
    }
    private boolean checkWon() {
        for (int i = 0; i < 3; i++) {
                if (buttons[i][0].getText().equals(buttons[i][1].getText())
                        && buttons[i][0].getText().equals(buttons[i][2].getText())
                        && !buttons[i][0].equals("")) {
                    return true;
                }
        }
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText())
                    && buttons[0][i].getText().equals(buttons[2][i].getText())
                    && !buttons[0][i].equals("")) {
                return true;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonArray[][] = {
                {
                        findViewById(R.id.button8),
                        findViewById(R.id.button9),
                        findViewById(R.id.button10)
                },
                {
                        findViewById(R.id.button4),
                        findViewById(R.id.button5),
                        findViewById(R.id.button6)
                },
                {
                        findViewById(R.id.button),
                        findViewById(R.id.button2),
                        findViewById(R.id.button3)
                }
        };
        this.buttons = buttonArray;
        clear();

        Random random = new Random();
        while (!isOver()) {
            if (random.nextInt(10) < 5) {
                humanTurn = true;
            } else {
                humanTurn = false;
            }
            if (humanTurn) {
                humanPlay();
            } else {
                computerPlay();
            }
        }
    }

    private void humanPlay() {

    }

    private void computerPlay() {

    }
}
