package com.mobile.psc.temperatureconvertortdd;

import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText editCelsius,editFahrenheit;
    double celsius,fahrenheit;
    TextWatcher watcherCelsius,watcherFahrenheit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCelsius = (EditText)findViewById(R.id.editCelsius);
        editFahrenheit = (EditText)findViewById(R.id.editFahrenheit);
        watcherCelsius = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("DEBUG", "before:" + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("DEBUG","on:"+s.toString());
                String result = "";
                if (!s.toString().trim().equals("")) {
                    result = Double.toString((Double.parseDouble(s.toString()) * (9.0 / 5.0))+ 32 );
                }
                //TODO : change to check focus
                editFahrenheit.removeTextChangedListener(watcherFahrenheit);
                editFahrenheit.setText(result);
                editFahrenheit.addTextChangedListener(watcherFahrenheit);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("DEBUG","after:"+s.toString());
            }
        };
        watcherFahrenheit = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("DEBUG", "before:" + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("DEBUG", "on:" + s.toString());
                String result = "";
                if (!s.toString().trim().equals("")) {
                    result = Double.toString((Double.parseDouble(s.toString()) - 32) * (5.0 / 9.0));
                }
                editCelsius.removeTextChangedListener(watcherCelsius);
                editCelsius.setText(result);
                editCelsius.addTextChangedListener(watcherCelsius);
            }


            @Override
            public void afterTextChanged(Editable s) {
                Log.d("DEBUG","after:"+s.toString());
            }
        };
    }
    private void printCurrentTemp()
    {
        Log.d("DEBUG","C,F :"+Double.toString(celsius)+","+Double.toString(fahrenheit));
    }
    @Override
    protected void onStart() {
        super.onStart();
        editCelsius.addTextChangedListener(watcherCelsius);
        editFahrenheit.addTextChangedListener(watcherFahrenheit);
    }
}

