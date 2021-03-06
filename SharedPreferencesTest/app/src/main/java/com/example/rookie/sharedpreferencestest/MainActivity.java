package com.example.rookie.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveDataBtn = (Button) findViewById(R.id.save_data);
        saveDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "刘亚芳");
                editor.putInt("age", 28);
                editor.putBoolean("married", true);
                editor.apply();
            }
        });
        
        Button restoreDataBtn = (Button) findViewById(R.id.restore_data);
        restoreDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = preferences.getString("name","");
                int age = preferences.getInt("age",0);
                boolean married = preferences.getBoolean("married", false);

                Log.d(TAG, "onClick: name is " + name);
                Log.d(TAG, "onClick: age is" + age);
                Log.d(TAG, "onClick: married is" + married);
            }
        });

    }
}
