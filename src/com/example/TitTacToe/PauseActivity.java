package com.example.TitTacToe;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by paul on 09.02.2015.
 */
public class PauseActivity extends Activity {

    private Button btnResume;
    private Button btnNewGame;
    private Button btnHighScore;
    private Button btnQuit;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause);

        initWidgets();
    }

    private void initWidgets() {

        btnResume = (Button) findViewById(R.id.btnResume);
        btnResume.setOnClickListener(listener);

        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(listener);

        btnHighScore = (Button) findViewById(R.id.btnHighScore);
        btnHighScore.setOnClickListener(listener);

        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnResume:
                    Intent intent0 = new Intent(context, PlayActivity.class);
                    PauseActivity.this.startActivity(intent0);
                    break;
                case R.id.btnNewGame:
                    Intent intent = new Intent(context, PlayNewGame.class);
                    PauseActivity.this.startActivity(intent);
                    break;
                case R.id.btnHighScore:
                    Intent intent1 = new Intent(context, HighScoreActivity.class);
                    PauseActivity.this.startActivity(intent1);
                    break;
                case R.id.btnQuit:
                    PauseActivity.this.onDestroy();
                    break;

            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Destroying");
        System.exit(0);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Stopping..");
        super.onStop();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Resume..");
        if(PlayActivity.class == null){

        }
    }
    @Override
    protected void onRestart(){
        Intent mStartActivity = new Intent(context, MainActivity.class);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager mgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);
    }
}
