package com.example.kevin.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class RemoveDistribution extends AppCompatActivity {
    public ArrayAdapter<String> adapter;
    Spinner sp;

    /*
    Class that renders remove course distribution activity. Returns course distribution to be removed and results ok
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_distribution);


        //TODO change the array list
        sp = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, (ArrayList<String>)getIntent().getSerializableExtra("list"));
        sp.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remove_distribution, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //cancels activity, return result canceled
        Intent results = new Intent();
        setResult(RESULT_CANCELED,results);
        finish();
    }

    public void deleteDistribution(View view) {
        //parses user input from spinner, packs intent, returns result ok
        String line = (String)sp.getSelectedItem();
        Intent results = new Intent();
        results.putExtra("distribution", line);

        setResult(RESULT_OK,results);
        finish();
    }
}
