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
import android.widget.EditText;

/**
 * Created by paul on 09.02.2015.
 */
public class PlayNewGame extends Activity {


    public static final String PREFS_NAME = "playerInfo";
    private static final String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private EditText edtName1;
    private EditText edtName2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);
        initWidgets();
    }

    public void initWidgets() {

        edtName1 = (EditText) findViewById(R.id.edtName1);
        edtName2 = (EditText) findViewById(R.id.edtName2);
        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(listener);
    }
    private void sharedPreferences(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.putString("name", edtName1.getText().toString());
        editor.putString("name2", edtName2.getText().toString());

        editor.apply();

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnPlay:
                    sharedPreferences();
                    Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                    startActivity(intent);
                    break;
                default:
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
