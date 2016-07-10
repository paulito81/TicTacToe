package com.example.TitTacToe;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by paul on 10.02.2015.
 */
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
    public Chronometer chrono;
    private Button btnPause;
    private TextView txtPlay;
    public String showTime;
    public ArrayList<String> highScore = new ArrayList<>();

    static long timer = 0;
    int playerOne, playerTwo;
    String gamePlayerOne = "Player One";
    String gamePlayerTwo = "Player Two";
    public static String inputOne = "";
    public static String inputTwo = "";
    public ArrayList<String> recentGameList = new ArrayList<>();
    private ArrayList<String> playerOneGameList = new ArrayList<>();
    private ArrayList<String> playerTwoGameList = new ArrayList<>();
    private ArrayList<String> gameBoard = new ArrayList<>();
    public static final String PREFS_NAME = "playerInfo";

    private static final String TAG = MainActivity.class.getSimpleName();
    Context context = this;
    String win;
    String lose = "";
    int countPlayeOne, countPlayerTwo;
    String outCome;
    static ArrayList<String> saveGameList = new ArrayList<>();

    private SharedPreferences preferences;
    Set<String> mySavedGameList = new HashSet<String>();
    private SharedPreferences.Editor preferencesEditor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        initWidgets();
        newGame();
        startChronometer();

    }

    public void recentGames() {
        mySavedGameList.add("One");
        mySavedGameList.add("Two");
        mySavedGameList.add("Three");
        mySavedGameList.add("Four");
        mySavedGameList.add("Five");

        preferencesEditor.putStringSet("mySave", mySavedGameList);
        preferencesEditor.apply();

        for (String s : recentGameList) {
            System.out.print(s);
        }
        System.out.println();
    }

    private void initWidgets() {

        chrono = (Chronometer) findViewById(R.id.chrono);
        txtPlay = (TextView) findViewById(R.id.txtPlay);

        btnSquareOne = (ImageButton) findViewById(R.id.btnSquareOne);
        btnSquareOne.setOnClickListener(listener);
        btnSquareOne.setEnabled(true);

        btnSquareTwo = (ImageButton) findViewById(R.id.btnSquareTwo);
        btnSquareTwo.setOnClickListener(listener);
        btnSquareTwo.setEnabled(true);

        btnSquareThree = (ImageButton) findViewById(R.id.btnSquareThree);
        btnSquareThree.setOnClickListener(listener);
        btnSquareThree.setEnabled(true);

        btnSquareFour = (ImageButton) findViewById(R.id.btnSquareFour);
        btnSquareFour.setOnClickListener(listener);
        btnSquareFour.setEnabled(true);

        btnSquareFive = (ImageButton) findViewById(R.id.btnSquareFive);
        btnSquareFive.setOnClickListener(listener);
        btnSquareFive.setEnabled(true);

        btnSquareSix = (ImageButton) findViewById(R.id.btnSquareSix);
        btnSquareSix.setOnClickListener(listener);
        btnSquareSix.setEnabled(true);

        btnSquareSeven = (ImageButton) findViewById(R.id.btnSquareSeven);
        btnSquareSeven.setOnClickListener(listener);
        btnSquareSeven.setEnabled(true);

        btnSquareEight = (ImageButton) findViewById(R.id.btnSquareEight);
        btnSquareEight.setOnClickListener(listener);
        btnSquareEight.setEnabled(true);

        btnSquareNine = (ImageButton) findViewById(R.id.btnSquareNine);
        btnSquareNine.setOnClickListener(listener);
        btnSquareNine.setEnabled(true);


    }
    public void calcDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" EEE MMM dd HH:mm:ss yyyy");
        showTime = simpleDateFormat.format(Calendar.getInstance().getTime());
    }


    public void sharedPreferences() { // send data -> GAME OVER


        System.out.println(outCome);
        calcDate();
        preferences = getSharedPreferences(PREFS_NAME, 0);
        preferencesEditor = preferences.edit();
        preferencesEditor.clear();
        preferencesEditor.putString("winner", win);
        preferencesEditor.putString("lose", lose);
        preferencesEditor.putString("outcome", outCome);
        preferencesEditor.putString("timeDate", showTime);

        saveGameList.add(win + " " + showTime+"\n " + outCome.toUpperCase() + " vs " + lose.toLowerCase());
        preferencesEditor.apply();
/*
        // PRINT OUT TEST
        recentGameList.add(win);
        recentGameList.add(lose + " vs: ");
        recentGameList.add(outCome);
        recentGameList.add(showTime);
        recentGames();
*/

    }


    public void getPreferencePlayerOne() {
        preferences = getSharedPreferences(PREFS_NAME, 0);
        TextView tvName = (TextView) findViewById(R.id.txtPlay);
        inputOne = tvName.getText().toString();
        tvName.setText(preferences.getString("name", inputOne));
        outCome = inputTwo;
    }

    public void getPreferencePlayerTwo() {
        gamePlayerTwo = "Player Two";
        preferences = getSharedPreferences(PREFS_NAME, 0);
        TextView tvName2 = (TextView) findViewById(R.id.txtPlay);
        inputTwo = tvName2.getText().toString();
        tvName2.setText(preferences.getString("name2", inputTwo));
        outCome = inputOne;
    }

    public void newGame() {
        gamePlayerOne = "Player One";
        gamePlayerTwo = "Player Two";
        resetPlayerOne();

    }

    private void resetPlayerOne() {
        if (!gameWinner() || playerOneGameList.size() >= 5) {
            getPreferencePlayerTwo();
            Context context = getApplicationContext();
            CharSequence text = outCome + "  get ready!";
            int duration = Toast.LENGTH_SHORT;
            System.out.println(outCome);
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            playerTwo = 1;
            playerOne = 0;
        } else
            changeActivity();

    }

    private void resetPlayerTwo() {

        if (!gameWinner() || playerTwoGameList.size() >= 5) {
            getPreferencePlayerOne();
            Context context2 = getApplicationContext();
            CharSequence text = outCome + "  get ready!";
            System.out.println(outCome);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context2, text, duration);
            toast.show();
            playerTwo = 0;
            playerOne = 1;
        } else
            changeActivity();
    }

    public void gameBoard() {
        if (gameBoard.size() == 9 && !gameWinner()) {
            for (String s : gameBoard)
                System.out.println("******** " + s + "*********");
            System.out.println("*****SHUTDOWN*********");
            System.out.println("P1: playerOneGameList" + "\n***\nP2: " + playerTwoGameList);
            printDraw();
        } else
            gameWinner();
    }

    public void gameWinnerTestPlayer1() {
        System.out.println("TRE PÅ RAD  **PLAYER**1***");
        for (String s : playerOneGameList)
            System.out.println("player1: " + s);

        Context context3 = getApplicationContext();
        CharSequence text = "PLAYER ONE GOT THREE IN A ROW!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context3, text, duration);
        toast.show();
    }

    public void gameWinnerTestPlayer2() {
        System.out.println("TRE PÅ RAD  **PLAYER**2**");
        for (String s : playerTwoGameList)
            System.out.println("player2: " + s);
        Context context3 = getApplicationContext();
        CharSequence text = "PLAYER TwO GOT THREE IN A ROW!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context3, text, duration);
        toast.show();
    }

    public boolean gameWinner() {
        if (playerOneGameList.contains("1") && playerOneGameList.contains("2") && playerOneGameList.contains("3")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;


        } else if (playerTwoGameList.contains("1") && playerTwoGameList.contains("2") && playerTwoGameList.contains("3")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("4") && playerOneGameList.contains("5") && playerOneGameList.contains("6")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("4") && playerTwoGameList.contains("5") && playerTwoGameList.contains("6")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("7") && playerOneGameList.contains("8") && playerOneGameList.contains("9")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("7") && playerTwoGameList.contains("8") && playerTwoGameList.contains("9")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("1") && playerOneGameList.contains("4") && playerOneGameList.contains("7")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("1") && playerTwoGameList.contains("4") && playerTwoGameList.contains("7")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("2") && playerOneGameList.contains("5") && playerOneGameList.contains("8")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("2") && playerTwoGameList.contains("5") && playerTwoGameList.contains("8")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("3") && playerOneGameList.contains("6") && playerOneGameList.contains("9")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("3") && playerTwoGameList.contains("6") && playerTwoGameList.contains("9")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("1") && playerOneGameList.contains("5") && playerOneGameList.contains("9")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("1") && playerTwoGameList.contains("5") && playerTwoGameList.contains("9")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerOneGameList.contains("7") && playerOneGameList.contains("5") && playerOneGameList.contains("3")) {
            gameWinnerTestPlayer1();
            printWinnerOne();
            changeActivity();
            onDestroy();
            return true;

        } else if (playerTwoGameList.contains("7") && playerTwoGameList.contains("5") && playerTwoGameList.contains("3")) {
            gameWinnerTestPlayer2();
            printWinnerTwo();
            changeActivity();
            onDestroy();
            return true;
        }
        return false;
    }

    public void changeActivity() {
        stopChronometer();
        sharedPreferences();
        Intent intent = new Intent(getApplicationContext(), GameOverActivity.class);
        startActivity(intent);
    }

    public String printWinnerOne() {
        win = " Player 1 wins!: ";
        lose = inputOne;
        Context context1 = getApplicationContext();
        CharSequence text = " Player One has won the game!!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context1, text, duration);
        toast.show();
        return win;

    }

    public String printWinnerTwo() {
        win = " Player 2 wins!: ";
        lose = inputTwo;
        Context context2 = getApplicationContext();
        CharSequence text = " Player Two has won the game!!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context2, text, duration);
        toast.show();
        return win;
    }

    public void printDraw() {
        stopChronometer();
        win = "draw!";
        Context context3 = getApplicationContext();
        CharSequence text = "GAME OVER!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context3, text, duration);
        toast.show();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        showTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println("**timeUpdate**" + timer + "**** !#!");
        SharedPreferences preferences1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = preferences1.edit();
        editor.clear();
        editor.putString("timeDate", showTime);
        editor.putString("winner", win);
        editor.putString("lose", lose);
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), GameOverActivity.class);
        startActivity(intent);
    }

    public void startChronometer() {
        chrono.setBase(SystemClock.elapsedRealtime() + timer);
        chrono.start();
    }


    public void stopChronometer() {
        timer = SystemClock.elapsedRealtime()- chrono.getBase() ;
        chrono.stop();
         timer = timer / 1000 ;
        System.out.println("STOPTIMER*******" + timer + " XXXXXX");

        Context context = getApplicationContext();
        CharSequence text = "game duration: " + timer + " seconds";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnSquareOne:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareOne.isEnabled()) {
                            btnSquareOne.setImageResource(R.drawable.v);
                        }
                        btnSquareOne.setEnabled(false);
                        playerOneGameList.add("1");
                        gameBoard.add("1");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareOne.isEnabled()) {
                            btnSquareOne.setImageResource(R.drawable.x4);
                        }
                        btnSquareOne.setEnabled(false);
                        playerTwoGameList.add("1");
                        gameBoard.add("1");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareTwo:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareTwo.isEnabled()) {
                            btnSquareTwo.setImageResource(R.drawable.v);
                        }
                        btnSquareTwo.setEnabled(false);
                        playerOneGameList.add("2");
                        gameBoard.add("2");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareTwo.isEnabled()) {
                            btnSquareTwo.setImageResource(R.drawable.x4);
                        }
                        btnSquareTwo.setEnabled(false);
                        playerTwoGameList.add("2");
                        gameBoard.add("2");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareThree:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareThree.isEnabled()) {
                            btnSquareThree.setImageResource(R.drawable.v);
                        }
                        btnSquareThree.setEnabled(false);
                        playerOneGameList.add("3");
                        gameBoard.add("3");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareThree.isEnabled()) {
                            btnSquareThree.setImageResource(R.drawable.x4);
                        }
                        btnSquareThree.setEnabled(false);
                        playerTwoGameList.add("3");
                        gameBoard.add("3");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareFour:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareFour.isEnabled()) {
                            btnSquareFour.setImageResource(R.drawable.v);
                        }
                        btnSquareFour.setEnabled(false);
                        playerOneGameList.add("4");
                        gameBoard.add("4");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareFour.isEnabled()) {
                            btnSquareFour.setImageResource(R.drawable.x4);
                        }
                        btnSquareFour.setEnabled(false);
                        playerTwoGameList.add("4");
                        gameBoard.add("4");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareFive:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareFive.isEnabled()) {
                            btnSquareFive.setImageResource(R.drawable.v);
                        }
                        btnSquareFive.setEnabled(false);
                        playerOneGameList.add("5");
                        gameBoard.add("5");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareFive.isEnabled()) {
                            btnSquareFive.setImageResource(R.drawable.x4);
                        }
                        btnSquareFive.setEnabled(false);
                        playerTwoGameList.add("5");
                        gameBoard.add("5");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareSix:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareSix.isEnabled()) {
                            btnSquareSix.setImageResource(R.drawable.v);
                        }
                        btnSquareSix.setEnabled(false);
                        playerOneGameList.add("6");
                        gameBoard.add("6");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareSix.isEnabled()) {
                            btnSquareSix.setImageResource(R.drawable.x4);
                        }
                        btnSquareSix.setEnabled(false);
                        playerTwoGameList.add("6");
                        gameBoard.add("6");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareSeven:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareSeven.isEnabled()) {
                            btnSquareSeven.setImageResource(R.drawable.v);
                        }
                        btnSquareSeven.setEnabled(false);
                        playerOneGameList.add("7");
                        gameBoard.add("7");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareSeven.isEnabled()) {
                            btnSquareSeven.setImageResource(R.drawable.x4);
                        }
                        btnSquareSeven.setEnabled(false);
                        playerTwoGameList.add("7");
                        gameBoard.add("7");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareEight:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareEight.isEnabled()) {
                            btnSquareEight.setImageResource(R.drawable.v);
                        }
                        btnSquareEight.setEnabled(false);
                        playerOneGameList.add("8");
                        gameBoard.add("8");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareEight.isEnabled()) {
                            btnSquareEight.setImageResource(R.drawable.x4);
                        }
                        btnSquareEight.setEnabled(false);
                        playerTwoGameList.add("8");
                        gameBoard.add("8");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;

                case R.id.btnSquareNine:
                    if (gamePlayerOne.equals("Player One") && playerOne > playerTwo) {
                        if (btnSquareNine.isEnabled()) {
                            btnSquareNine.setImageResource(R.drawable.v);
                        }
                        btnSquareNine.setEnabled(false);
                        playerOneGameList.add("9");
                        gameBoard.add("9");
                        gameBoard();
                        resetPlayerOne();
                    } else if (gamePlayerTwo.equals("Player Two") && playerTwo > playerOne) {
                        if (btnSquareNine.isEnabled()) {
                            btnSquareNine.setImageResource(R.drawable.x4);
                        }
                        btnSquareNine.setEnabled(false);
                        playerTwoGameList.add("9");
                        gameBoard.add("9");
                        gameBoard();
                        resetPlayerTwo();
                    }
                    break;


            }
        }
    };

    /*
    public boolean saveArray(String[] array, String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("PREFS_NAME", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.length);
        for(int i=0;i<array.length;i++)
            editor.putString(arrayName + "_" + i, array[i]);
        return editor.commit();
    }
    public String[] loadArray(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("PREFS_NAME", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }
*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        android.os.Debug.stopMethodTracing();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Resume..");
    }

    @Override
    protected void onRestart() {
        Intent mStartActivity = new Intent(getApplicationContext(), PlayActivity.class);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stopping..");
        preferences = getSharedPreferences(PREFS_NAME, 0);
        preferencesEditor= preferences.edit();
        preferencesEditor.clear();
        preferencesEditor.putString("winner", win);
        preferencesEditor.putString("loser", lose);
        preferencesEditor.putString("outcome", outCome);
        preferencesEditor.putString("timeDate", showTime);
        preferencesEditor.apply();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Pause..");
    }
}
