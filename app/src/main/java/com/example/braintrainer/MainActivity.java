package com.example.braintrainer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int randomNumber1;
    private int randomNumber2;
    private int result;
    private int recordedHighScore;
    private TextView timeDisplay;
    private TextView arithmeticDisplay;
    private TextView turnsDisplay;
    private TextView gameResults;
    private TextView highScore;
    private Button buttonRed;
    private Button buttonPurple;
    private Button buttonBlue;
    private Button buttonGreen;
    private Button playAgain;
    private MediaPlayer mediaPlayer;
    private int rightAnswers = 0;
    private int totalQuestions = 0;
    private Random random;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("score", MODE_PRIVATE);
        recordedHighScore = Integer.parseInt(sharedPreferences.getString("score", "30"));
        random = new Random();
        playAgain = findViewById(R.id.button_play_again);
        gameResults = findViewById(R.id.game_results);
        arithmeticDisplay = findViewById(R.id.arithmetic_display);
        turnsDisplay = findViewById(R.id.turns_display);
        timeDisplay = findViewById(R.id.time_display);
        highScore = findViewById(R.id.high_score);
        buttonRed = findViewById(R.id.button_red);
        buttonPurple = findViewById(R.id.button_purple);
        buttonBlue = findViewById(R.id.button_blue);
        buttonGreen = findViewById(R.id.button_green);
        mediaPlayer = MediaPlayer.create(this, R.raw.gameover);
        randomNumber1 = random.nextInt(50);
        randomNumber2 = random.nextInt(50);
        result = randomNumber1 + randomNumber2;
        buttonRed.setText("" + result);
        buttonGreen.setText("" + random.nextInt(100));
        buttonBlue.setText("" + random.nextInt(100));
        buttonPurple.setText("" + random.nextInt(100));
        countDownTimer = new CountDownTimer(31000, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeDisplay.setText("0:" + millisUntilFinished / 1000);
                turnsDisplay.setText(rightAnswers + "/" + totalQuestions);
                arithmeticDisplay.setText(randomNumber1 + " + " + randomNumber2);
            }

            @Override
            public void onFinish() {
                mediaPlayer.start();
                playAgain.setVisibility(View.VISIBLE);
                highScore.setText("High Sore - " + recordedHighScore + '\n' + "Your Score - " + rightAnswers);
                buttonRed.setClickable(false);
                buttonGreen.setClickable(false);
                buttonBlue.setClickable(false);
                buttonPurple.setClickable(false);
                if (rightAnswers > recordedHighScore) {
                    editor = sharedPreferences.edit();
                    editor.putString("score", rightAnswers+"");
                    editor.commit();
                }
            }
        }.start();

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(buttonRed.getText().toString()) == result) {
                    rightAnswers++;
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("RIGHT");
                    buttonBlue.setText("" + result);
                    buttonRed.setText("" + random.nextInt(100));
                    buttonGreen.setText("" + random.nextInt(100));
                    buttonPurple.setText("" + random.nextInt(100));
                } else {
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("WRONG");
                    buttonGreen.setText("" + result);
                    buttonRed.setText("" + random.nextInt(100));
                    buttonBlue.setText("" + random.nextInt(100));
                    buttonPurple.setText("" + random.nextInt(100));
                }
            }
        });
        buttonPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(buttonPurple.getText().toString()) == result) {
                    rightAnswers++;
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("RIGHT");
                    buttonGreen.setText("" + result);
                    buttonRed.setText("" + random.nextInt(100));
                    buttonBlue.setText("" + random.nextInt(100));
                    buttonPurple.setText("" + random.nextInt(100));
                } else {
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("WRONG");
                    buttonRed.setText("" + result);
                    buttonGreen.setText("" + random.nextInt(100));
                    buttonBlue.setText("" + random.nextInt(100));
                    buttonPurple.setText("" + random.nextInt(100));
                }
            }
        });
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(buttonBlue.getText().toString()) == result) {
                    rightAnswers++;
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("RIGHT");
                    buttonPurple.setText("" + result);
                    buttonRed.setText("" + random.nextInt(100));
                    buttonBlue.setText("" + random.nextInt(100));
                    buttonGreen.setText("" + random.nextInt(100));
                } else {
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("WRONG");
                    buttonRed.setText("" + result);
                    buttonGreen.setText("" + random.nextInt(100));
                    buttonBlue.setText("" + random.nextInt(100));
                    buttonPurple.setText("" + random.nextInt(100));
                }
            }
        });
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(buttonGreen.getText().toString()) == result) {
                    rightAnswers++;
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("RIGHT");
                    buttonBlue.setText("" + result);
                    buttonRed.setText("" + random.nextInt(100));
                    buttonGreen.setText("" + random.nextInt(100));
                    buttonPurple.setText("" + random.nextInt(100));
                } else {
                    totalQuestions++;
                    randomNumber1 = random.nextInt(50);
                    randomNumber2 = random.nextInt(50);
                    result = randomNumber1 + randomNumber2;
                    gameResults.setText("WRONG");
                    buttonPurple.setText("" + result);
                    buttonRed.setText("" + random.nextInt(100));
                    buttonBlue.setText("" + random.nextInt(100));
                    buttonGreen.setText("" + random.nextInt(100));
                }
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             sharedPreferences = getSharedPreferences("score", MODE_PRIVATE);
                                             recordedHighScore = Integer.parseInt(sharedPreferences.getString("score", "30"));
                                             playAgain.setVisibility(View.INVISIBLE);
                                             highScore.setText("");
                                             gameResults.setText("");
                                             rightAnswers = 0;
                                             totalQuestions = 0;
                                             randomNumber1 = random.nextInt(50);
                                             randomNumber2 = random.nextInt(50);
                                             result = randomNumber1 + randomNumber2;
                                             buttonBlue.setText("" + result);
                                             buttonGreen.setText("" + random.nextInt(100));
                                             buttonRed.setText("" + random.nextInt(100));
                                             buttonPurple.setText("" + random.nextInt(100));
                                             buttonRed.setClickable(true);
                                             buttonGreen.setClickable(true);
                                             buttonBlue.setClickable(true);
                                             buttonPurple.setClickable(true);
                                             countDownTimer.start();
                                         }
                                     }
        );
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
        a.setTitle("Exit Application");
        a.setMessage("Are You Sure you want to Exit Application");
        a.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                countDownTimer.cancel();
                finish();
            }
        });
        a.show();
    }
}