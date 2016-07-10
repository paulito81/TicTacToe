package com.example.TitTacToe;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by paul on 11.02.2015.
 */
public class Player extends Activity {

    private int time;
    private String name;
    public int playerOne;
    public int playerTwo;
     String gamePlayerOne;
    String gamePlayerTwo;

    GameBoard gameBoard = new GameBoard();

    public Player(int time, String name) {
        super();
        this.time = time;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }


    public int setPlayerOne(int playOne, int playerIcon) {
        playOne = playerOne;
        playerIcon = R.drawable.v;
        return playOne;
    }

    public int setPlayerTwo(int playTwo, int playerIcon) {
        playTwo = playerTwo;
        playerIcon = R.drawable.x2;
        return playTwo;
    }

    public void getName(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player[ name= " + name + " ,time=" + time + "]";
    }

    public ArrayList getPlayerOne() {
        return gameBoard.playerOneGameList;
    }

    public ArrayList getPlayerTwo() {
        return gameBoard.playerTwoGameList;
    }

    /*
    public String newGame() {
        String gamePlayerOne;
        String gamePlayerTwo;
        Random random = new Random();
        int randomPlay = random.nextInt(2);


        Log.e(TAG, "Error: " + randomPlay);
        if (randomPlay == 0) {
        //   btnSquareOne.setImageResource(R.drawable.v);
            gamePlayerOne= "Player One";
            System.out.println(gamePlayerOne);
            resetPlayerTwo();
            return gamePlayerOne;
        }
        if(randomPlay == 1){
        //    btnSquareOne.setImageResource(R.drawable.x2);
            gamePlayerTwo = "Player Two";
            System.out.println(gamePlayerTwo);
            resetPlayerOne();
            return gamePlayerTwo;
        }
            return "";
    }

    public String getStartPlayer(){
        return newGame();
    }

    private void resetPlayerOne() {
        gamePlayerOne = "Player One";
        Context context = getApplicationContext();
        CharSequence text = gamePlayerTwo + "  get ready!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        playerOne = 0;
        playerTwo = 1;
    }



    private void resetPlayerTwo() {
        gamePlayerTwo = "Player Two";
        Context context2 = getApplicationContext();
        CharSequence text = gamePlayerOne + "  get ready!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context2, text, duration);
        toast.show();
        playerOne = 1;
        playerTwo = 0;
    }
    */


}