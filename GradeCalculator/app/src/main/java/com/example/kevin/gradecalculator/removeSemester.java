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
import java.util.Scanner;

public class removeSemester extends AppCompatActivity {

    public ArrayAdapter<Semester> adapter;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_semester);

        sp = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<Semester>(this,android.R.layout.simple_spinner_item,MainActivity.semesterList);
        sp.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remove_semester, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deleteSemester(View view) {
        String line = sp.getSelectedItem().toString();
        Scanner scanner = new Scanner(line);
        String id = scanner.next();

        Intent results = new Intent();
        results.putExtra("term", id);

        setResult(RESULT_OK,results);
        finish();

    }
}
