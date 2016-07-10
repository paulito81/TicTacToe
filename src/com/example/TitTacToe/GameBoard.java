package com.example.TitTacToe;

import android.widget.Chronometer;

import java.util.ArrayList;

/**
 * Created by paul on 16.02.2015.
 */
public class GameBoard extends PlayActivity {
    public String sqr1= "1", sqr2= "2", sqr3 ="3", sqr4 ="4", sqr5="5", sqr6="6", sqr7="7", sqr8="8", sqr9="9";
    public ArrayList<String> playerOneGameList = new ArrayList<>();
    public ArrayList<String> playerTwoGameList = new ArrayList<>();
    public String gameWinner = "";
    public static Chronometer chrono;
    public ArrayList gameBoard = new ArrayList();

/*
     public boolean gameBoard(void aVoid) {
        if (gameBoard.size() == 9 && playrOneList.size() >=5 || playerTwoGameList.size() >=5) {
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
    */
}
