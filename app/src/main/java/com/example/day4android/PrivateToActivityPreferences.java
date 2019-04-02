package com.example.day4android;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PrivateToActivityPreferences extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences2;
    //private TextView res=null;
    private final String TAG = SharedPreferencesMainActivity.class.getCanonicalName();
    private ConstraintLayout myCLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_to_preferences);
        //res.setTextSize(15.0f);
        //res.setTextColor(Color.rgb( 0, 0, 200));
        //myCLayout= findViewById(R.id.myConstraintLayout);
        sharedPreferences= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor mEditor = sharedPreferences.edit();
        sharedPreferences2=getSharedPreferences("myPref",MODE_PRIVATE);
        String name = sharedPreferences2.getString("name", null);
        if(name!=null){
            Log.e(TAG,name);
            //res.setText(name);
            //myCLayout.addView(res);
        }
        mEditor.putString("test", "Lambton College in Toronto");
        mEditor.apply();
    }
}
