package com.example.devanshjatinponda.wintactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttons[][];
    private void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
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
    }
}
