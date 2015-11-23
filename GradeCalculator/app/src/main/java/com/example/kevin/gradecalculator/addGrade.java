package com.example.kevin.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddGrade extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = (Spinner)findViewById(R.id.spinner);
        setContentView(R.layout.activity_add_grade);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_grade, menu);
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
        Intent results = new Intent();
        setResult(RESULT_CANCELED,results);
        finish();
    }

    public void addGrade(View view) {
        EditText name = (EditText)findViewById(R.id.gradeName);
        Course line = (Course)sp.getSelectedItem();
        EditText mark = (EditText)findViewById(R.id.Mark);

        Intent results = new Intent();
        results.putExtra("name", name.getText().toString());
        results.putExtra("course", line);
        results.putExtra("mark", mark.getText().toString());

        setResult(RESULT_OK,results);
        finish();
    }
}
