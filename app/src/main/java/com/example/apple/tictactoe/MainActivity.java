package com.example.apple.tictactoe;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int turn = 0;
    int counter = 0;
    // Turn 0 = x and turn 1 = 0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b1, 1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b2, 2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b3, 3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b4, 4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b5, 5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b6, 6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b7, 7);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b8, 8);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTurnAndSetValue(b9, 9);
            }
        });
    }
    private Boolean checkDiagonal(int i) {
        Boolean wins = false;
        String bT1, bT9, bT3, bT7, bT5;
        switch (i) {
            case 1:
            case 9:
                bT5 = b5.getText().toString().isEmpty() ? "" : b5.getText().toString();
                bT1 = b1.getText().toString();
                bT9 = b9.getText().toString();
                if (bT1.equals(bT5) && bT5.equals(bT9)) {
                    wins = true;
                } else {
                    wins = false;
                }
                break;
            case 3:
            case 7:
                bT5 = b5.getText().toString().isEmpty() ? "" : b5.getText().toString();
                bT3 = b3.getText().toString();
                bT7 = b7.getText().toString();
                if (bT3.equals(bT5) && bT5.equals(bT7)) {
                    wins = true;
                } else {
                    wins = false;
                }
                break;
            case 5:
                bT5 = b5.getText().toString().isEmpty() ? "" : b5.getText().toString();
                bT1 = b1.getText().toString();
                bT9 = b9.getText().toString();
                bT3 = b3.getText().toString();
                bT7 = b7.getText().toString();
                if (bT3.equals(bT5) && bT5.equals(bT7) || bT1.equals(bT5) && bT5.equals(bT9)) {
                    wins = true;
                } else {
                    wins = false;
                }
                break;
        }
        return wins;
    }
    private Boolean checkCol(int i) {
        Boolean wins = false;
        switch (i) {
            case 1:
            case 4:
            case 7:
                String bT1, bT4, bT7;
                bT1 = b1.getText().toString();
                bT4 = b4.getText().toString();
                bT7 = b7.getText().toString();
                wins = getBooleanResult(bT1, bT4, bT7);
                break;
            case 2:
            case 5:
            case 8:
                String bT2, bT5, bT8;
                bT2 = b2.getText().toString();
                bT5 = b5.getText().toString();
                bT8 = b8.getText().toString();
                wins = getBooleanResult(bT2, bT5, bT8);
                break;
            case 3:
            case 6:
            case 9:
                String bT3, bT6, bT9;
                bT3 = b3.getText().toString();
                bT6 = b6.getText().toString();
                bT9 = b9.getText().toString();
                wins = getBooleanResult(bT3, bT6, bT9);
                break;
        }
        return wins;
    }
    private Boolean checkRow(int i) {
        Boolean wins = false;
        switch (i) {
            case 1:
            case 2:
            case 3:
                String bT1, bT2, bT3;
                bT1 = b1.getText().toString();
                bT2 = b2.getText().toString();
                bT3 = b3.getText().toString();
                wins = getBooleanResult(bT1, bT2, bT3);
                break;
            case 4:
            case 5:
            case 6:
                String bT4, bT5, bT6;
                bT4 = b4.getText().toString();
                bT5 = b5.getText().toString();
                bT6 = b6.getText().toString();
                wins = getBooleanResult(bT4, bT5, bT6);
                break;
            case 7:
            case 8:
            case 9:
                String bT7, bT8, bT9;
                bT7 = b7.getText().toString();
                bT8 = b8.getText().toString();
                bT9 = b9.getText().toString();
                wins = getBooleanResult(bT7, bT8, bT9);
                break;
        }
        return wins;
    }
    @NonNull
    private Boolean getBooleanResult(String bT1, String bT2, String bT3) {
        Boolean wins;
        if (bT1.equals(bT2) && bT2.equals(bT3)) {
            wins = true;
        } else {
            wins = false;
        }
        return wins;
    }
    private void checkTurnAndSetValue(Button button, int buttonNumber) {
        String text = button.getText().toString();
        if (text.equals("X") || text.equals("0")) {
            Toast.makeText(this, "Try another place", Toast.LENGTH_SHORT).show();
            return;
        }
        counter++;
        if (turn == 0) {
            turn = 1;
            button.setText("X");
        } else {
            turn = 0;
            button.setText("0");
        }
        if (counter == 9) {
            winnerMessage("Its a draw...");
        } else if (counter > 4) {
            Boolean row = checkRow(buttonNumber);
            if (!row) {
                Boolean col = checkCol(buttonNumber);
                if (!col) {
                    Boolean diagonal = checkDiagonal(buttonNumber);
                    if (diagonal) {
                        makeClickableFalse();
                        winnerMessage("Congratz you won");
                    }
                } else {
                    makeClickableFalse();
                    winnerMessage("Congratz you won");
                }
            } else {
                makeClickableFalse();
                winnerMessage("Congratz you won");
            }
        }
    }
    /**
     * Writing success message here
     */
    private void winnerMessage(String messgae) {
        Snackbar.make(b1, messgae, Snackbar.LENGTH_INDEFINITE).setAction("Try Again", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        }).show();
    }
    /**
     * Making button clickable false here
     */
    private void makeClickableFalse() {
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
        b5.setClickable(false);
        b6.setClickable(false);
        b7.setClickable(false);
        b8.setClickable(false);
        b9.setClickable(false);
    }
}