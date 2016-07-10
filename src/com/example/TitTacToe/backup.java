/*
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.TitTacToe.GameOverActivity;
import com.example.TitTacToe.MainActivity;
import com.example.TitTacToe.PauseActivity;
import com.example.TitTacToe.R;

import java.util.ArrayList;
import java.util.Random;



package com.example.TitTacToe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Random;



public class PlayActivity extends Activity {
    private ImageButton btnSquareOne;
    private ImageButton btnSquareTwo;
    private ImageButton btnSquareThree;
    private ImageButton btnSquareFour;
    private ImageButton btnSquareFive;
    private ImageButton btnSquareSix;
    private ImageButton btnSquareSeven;
    private ImageButton btnSquareEight;
    private ImageButton btnSquareNine;
    private Button btnPause;
    private TextView txtPlay;
    // public TextView txtOut;
    public Chronometer chrono;
    public String gameWinner = "";
    // GAME LOOP
    public ArrayList<String> gameBoard = new ArrayList<>();
    private ArrayList<String> playerOneGameList = new ArrayList<>();
    private ArrayList<String>  playerTwoGameList =new  ArrayList<>();
    public String sqr1= "1", sqr2= "2", sqr3 ="3", sqr4 ="4", sqr5="5", sqr6="6", sqr7="7", sqr8="8", sqr9="9";

    public int playerOne;
    public int playerTwo;
    public String name;
    public String gamePlayer = "";

    private static final String TAG = MainActivity.class.getSimpleName();
    Context context = this;

    //Player player = new Player();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        randomPlayer();
        initWidgets();

    }

    private void initWidgets() {

        chrono = (Chronometer) findViewById(R.id.chrono);
        txtPlay = (TextView) findViewById(R.id.txtPlay);

        btnSquareOne = (ImageButton) findViewById(R.id.btnSquareOne);
        btnSquareOne.setOnClickListener(listener);

        btnSquareTwo = (ImageButton) findViewById(R.id.btnSquareTwo);
        btnSquareTwo.setOnClickListener(listener);

        btnSquareThree = (ImageButton) findViewById(R.id.btnSquareThree);
        btnSquareThree.setOnClickListener(listener);

        btnSquareFour = (ImageButton) findViewById(R.id.btnSquareFour);
        btnSquareFour.setOnClickListener(listener);

        btnSquareFive = (ImageButton) findViewById(R.id.btnSquareFive);
        btnSquareFive.setOnClickListener(listener);

        btnSquareSix = (ImageButton) findViewById(R.id.btnSquareSix);
        btnSquareSix.setOnClickListener(listener);

        btnSquareSeven = (ImageButton) findViewById(R.id.btnSquareSeven);
        btnSquareSeven.setOnClickListener(listener);

        btnSquareEight = (ImageButton) findViewById(R.id.btnSquareEight);
        btnSquareEight.setOnClickListener(listener);

        btnSquareNine = (ImageButton) findViewById(R.id.btnSquareNine);
        btnSquareNine.setOnClickListener(listener);

        btnPause = (Button) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(listener);

    }

    public void randomPlayer() {

        Random random = new Random();
        int randomPlay = random.nextInt();

        Log.e(TAG, "Errror: " + randomPlay);
        if (randomPlay ==0) {
            gamePlayer = "Player One";
            resetPlayerTwo();
        }
        if(randomPlay ==1){
            gamePlayer = "Player Two";
            resetPlayerOne();
        }

    }

    public void resetPlayerOne() {
        name = "Player One";
        final TextView mTextView = (TextView) findViewById(R.id.txtPlay);
        mTextView.setText("Player one your up!");
        playerOne = 0;
        playerTwo = 1;
    }


    public void resetPlayerTwo() {
        name = "Player Two";
        final TextView mTextView = (TextView) findViewById(R.id.txtPlay);
        mTextView.setText("Player two your up!");
        playerTwo = 0;
        playerOne = 1;
    }

    public String gameWinner() {
        if (playerOneGameList.contains("1") && playerOneGameList.contains("2") && playerOneGameList.contains("3")) {
            System.out.println(playerOneGameList);
            Context context1 = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1, text, duration);
            toast.show();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            chrono.stop();
            onDestroy();

        } else if (playerTwoGameList.contains("1") && playerTwoGameList.contains("2") && playerTwoGameList.contains("3")) {
            System.out.println(playerTwoGameList);
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            //     Intent intent = new Intent(context, GameOverActivity.class);
            //   PlayActivity.this.startActivity(intent);
            //     final TextView mTextView = (TextView) findViewById(R.id.txtOut);
            //    mTextView.setText("Player two wins!!");
            onDestroy();

        }else if (playerOneGameList.contains("4") && playerOneGameList.contains("5") && playerOneGameList.contains("6")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("4") && playerTwoGameList.contains("5") && playerTwoGameList.contains("6")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("7") && playerOneGameList.contains("8") && playerOneGameList.contains("9")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("7") && playerTwoGameList.contains("8") && playerTwoGameList.contains("9")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("1") && playerOneGameList.contains("4") && playerOneGameList.contains("7")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("1") && playerTwoGameList.contains("4") && playerTwoGameList.contains("7")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("2") && playerOneGameList.contains("5") && playerOneGameList.contains("8")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("2") && playerTwoGameList.contains("5") && playerTwoGameList.contains("8")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("3") && playerOneGameList.contains("6") && playerOneGameList.contains("9")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("3") && playerTwoGameList.contains("6") && playerTwoGameList.contains("9")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("1") && playerOneGameList.contains("5") && playerOneGameList.contains("9")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("1") && playerTwoGameList.contains("5") && playerTwoGameList.contains("9")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("7") && playerOneGameList.contains("5") && playerOneGameList.contains("3")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("7") && playerTwoGameList.contains("5") && playerTwoGameList.contains("3")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerOneGameList.contains("3") && playerOneGameList.contains("5") && playerOneGameList.contains("8")) {
            Context context1  = getApplicationContext();
            CharSequence text = "Player One has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context1 , text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();

        } else if (playerTwoGameList.contains("3") && playerTwoGameList.contains("5") && playerTwoGameList.contains("8")) {
            Context context2 = getApplicationContext();
            CharSequence text = "Player Two has won the game!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            chrono.stop();
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            onDestroy();
        }

        return gameWinner = "";

    }

    public boolean gameBoard() {
        if (gameBoard.size() == 9 && playerOneGameList.size() >=5 || playerTwoGameList.size() >=5) {
            chrono.stop();
            Context context2 = getApplicationContext();
            CharSequence text = "GAME OVER!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            //   final TextView mTextView = (TextView) findViewById(R.id.txtOut);
            //  mTextView.setText("Draw!");
            Intent intent = new Intent(context, GameOverActivity.class);
            PlayActivity.this.startActivity(intent);
            return true;
        }
        gameWinner();

        return false;
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            chrono.start();
            switch (v.getId()) {

                case R.id.btnSquareOne:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareOne.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr1);
                        gameBoard.add(sqr1);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareOne.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr1);
                        gameBoard.add(sqr1);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareTwo:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareTwo.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr2);
                        gameBoard.add(sqr2);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareTwo.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr2);
                        gameBoard.add(sqr2);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareThree:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareThree.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr3);
                        gameBoard.add(sqr3);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareThree.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr3);
                        gameBoard.add(sqr3);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareFour:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareFour.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr4);
                        gameBoard.add(sqr4);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareFour.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr4);
                        gameBoard.add(sqr4);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareFive:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareFive.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr5);
                        gameBoard.add(sqr5);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareFive.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr5);
                        gameBoard.add(sqr5);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareSix:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareSix.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr6);
                        gameBoard.add(sqr6);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareSix.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr6);
                        gameBoard.add(sqr6);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareSeven:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo || playerOne> playerTwo && gamePlayer.contains("Player One")){
                        btnSquareSeven.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr7);
                        gameBoard.add(sqr7);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")){
                        btnSquareSeven.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr7);
                        gameBoard.add(sqr7);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareEight:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo|| playerOne> playerTwo && gamePlayer.contains("Player One")){
                        btnSquareEight.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr8);
                        gameBoard.add(sqr8);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareEight.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr8);
                        gameBoard.add(sqr8);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareNine:
                    if (gamePlayer.contains("Player One") || playerOne > playerTwo|| playerOne> playerTwo && gamePlayer.contains("Player One")) {
                        btnSquareNine.setImageResource(R.drawable.v);
                        playerOneGameList.add(sqr9);
                        gameBoard.add(sqr9);
                        gameBoard();
                        resetPlayerOne();

                    } else if (gamePlayer.contains("Player Two") || playerTwo > playerOne || playerTwo > playerOne && gamePlayer.contains("Player Two")) {
                        btnSquareNine.setImageResource(R.drawable.x2);
                        playerTwoGameList.add(sqr9);
                        gameBoard.add(sqr9);
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnPause:
                    Intent intent = new Intent(context, PauseActivity.class);
                    PlayActivity.this.startActivity(intent);
                    break;

            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        android.os.Debug.stopMethodTracing();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Resume..");
        if (PlayActivity.class == null) {
            onDestroy();
        }
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Stopping..");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Pause..");
        super.onPause();
    }



    public boolean pressed(View view) {
        return true;
    }
}


*/
