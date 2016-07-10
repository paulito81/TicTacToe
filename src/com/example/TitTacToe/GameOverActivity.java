package com.example.TitTacToe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by paul on 09.02.2015.
 */
public class GameOverActivity extends Activity {
    private final String TAG = MainActivity.class.getSimpleName();
    private Context context = this;
    TextView txtPlayer;
    TextView txtOut;
    TextView txtClock;

    String playerResult, gameResult, timeDate;
    public static final String PREFS_NAME = "playerInfo";
    SharedPreferences gamePreferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        initWidgets();
        sharedGamePreferences();
    }

    private void initWidgets() {

        txtPlayer = (TextView) findViewById(R.id.txtPlay);
        txtOut = (TextView) findViewById(R.id.txtOut);
        txtClock = (TextView) findViewById(R.id.txtClock);

        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(listener);

        Button btnHighScore = (Button) findViewById(R.id.btnHighScore);
        btnHighScore.setOnClickListener(listener);

        Button btnQuit = (Button) findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(listener);

    }

    private void sharedGamePreferences() {
        gamePreferences = getSharedPreferences(PREFS_NAME, 0);

        TextView gameWindow = (TextView) findViewById(R.id.txtOut);
        gameResult = gameWindow.getText().toString();
        gameWindow.setText(gamePreferences.getString("winner", gameResult));

        TextView dateWindow = (TextView) findViewById(R.id.txtClock);
        timeDate = dateWindow.getText().toString();
        dateWindow.setText(gamePreferences.getString("timeDate", timeDate));

        TextView playerWindow = (TextView) findViewById(R.id.txtPlayer);
        playerResult = playerWindow.getText().toString();
        playerWindow.setText(gamePreferences.getString("outcome", playerResult));


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnNewGame:
                    Intent intent = new Intent(context, PlayNewGame.class);
                    startActivity(intent);
                    break;
                case R.id.btnHighScore:
                    Intent intent1 = new Intent(context, HighScoreActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.btnQuit:
                    onDestroy();
                    break;

            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Destroy..");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Resume..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stopping..");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Pause..");
        super.onPause();
    }
}
