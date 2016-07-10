package com.example.TitTacToe;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Context context = this;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String PREFS_NAME = "playerInfo";
    SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initWidgets();
    }

    private void initWidgets() {

        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(listener);

        Button btnHighScore = (Button) findViewById(R.id.btnHighScore);
        btnHighScore.setOnClickListener(listener);

        Button btnQuit = (Button) findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(listener);

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
                    Intent intent1 = new Intent(getApplicationContext(), HighScoreActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.btnQuit:
                    finish();
                    System.exit(0);
                    break;

            }
        }
    };

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Destroying");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stopping..");
        preferences = getSharedPreferences(PREFS_NAME, 0);
        preferencesEditor = preferences.edit();
        preferencesEditor.clear();
        preferencesEditor.putString("winner", null);
        preferencesEditor.putString("loser", null);
        preferencesEditor.putString("outcome", null);
        preferencesEditor.putString("timeDate", null);
        preferencesEditor.apply();

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
