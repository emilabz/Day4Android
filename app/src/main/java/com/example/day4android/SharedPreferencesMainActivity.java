package com.example.day4android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class SharedPreferencesMainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final String TAG = PrivateToActivityPreferences.class.getCanonicalName();
    private EditText edtName;
    private SharedPreferences sharedPreferences;
    private Spinner countrySpin= findViewById(R.id.spnCountry);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtText);


        List <String> CountryList = new ArrayList<String>();
        CountryList.add("India");
        CountryList.add("China");
        CountryList.add("USA");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,CountryList);
        countrySpin.setAdapter(dataAdapter);



        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        if(name!=null){
            Log.d(TAG,name);
            edtName.setText(name);
        }
    }
    public void btnSaveClick(View view){
        SharedPreferences.Editor mEditor = sharedPreferences.edit();
        if(edtName.getText().length()!=0){
            String name=edtName.getText().toString();
            mEditor.putString("name",name);
            mEditor.apply();
            Intent mIntent=new Intent(SharedPreferencesMainActivity.this,PrivateToActivityPreferences.class);
            startActivity(mIntent);
            //mEditor.clear();   //removes all keys and pref xml
            //mEditor.remove();   //removes specific key value
        }
    }
  @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String item=parent.getItemAtPosition(position).toString();
      Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
  }
    public void onNothingSelected(AdapterView<?> arg0){

    }
}
