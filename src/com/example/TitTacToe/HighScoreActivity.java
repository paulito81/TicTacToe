package com.example.TitTacToe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by paul on 10.02.2015.
 */
public class HighScoreActivity extends PlayActivity {

    SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;
    ArrayAdapter<String> adapter;
    private ListView listView;
    PlayActivity play = new PlayActivity();
    public static final String PREFS_NAME = "playerInfo";
    SharedPreferences gamePreferences;
    String playerResult, gameResult,gameResult2, timeDate;
    TextView textView3;
    private static final String TAG = MainActivity.class.getSimpleName();
    ArrayList<String> values;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        initWidgets();
        getSaveGameList();
        listViewAdapter();

    }
    public void getSaveGameList(){

        values = saveGameList;
        String saves = " ";
        for(String s : PlayActivity.saveGameList){
            System.out.println("==" +s);
            saves = s;
        }
        System.out.print("**HI****************" + saves + "****SCORE***");

    }

    public void initWidgets() {
        listView = (ListView) findViewById(R.id.listView);
        textView3 = (TextView) findViewById(R.id.textView3);
        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(listener);
    }

    private void listViewAdapter() {
        gamePreferences = getSharedPreferences(PREFS_NAME, 0);
        playerResult = gamePreferences.getString("outcome", outCome);
        gameResult = gamePreferences.getString("winner", win);
        gameResult2 = gamePreferences.getString("lose", lose);
        timeDate = gamePreferences.getString("timeDate", timeDate);
      // values = new ArrayList<>();
     //   values.add(timeDate);
     //   values.add(gameResult + " vs " + gameResult2 + " " + playerResult );
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
        adapter.addAll();
        adapter.notifyDataSetChanged();
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btnMenu:
                    Intent intent = new Intent(getApplication(), MainActivity.class);
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
        android.os.Debug.stopMethodTracing();
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



