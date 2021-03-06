package com.example.kevin.gradecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ShowLicenseActivity extends AppCompatActivity implements LicenseListener{

    /*
    Async activity that accesses a web resource. Displays GNU license from url. implements fab button
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_license);
        TextView licenseText = (TextView) findViewById(R.id.licenseText);
        licenseText.setText("Loading");
        GetLicenseAsync getLicenseAsync = new GetLicenseAsync(this);
        getLicenseAsync.execute(getIntent().getStringExtra("licenseUrl"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.close);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    public void returnClose(View view) {
        Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_license, menu);
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
    public void showLicense(String license){
        TextView licenseText = (TextView) findViewById(R.id.licenseText);
        licenseText.setText(license + "\n\nMusic: www.bensound.com \n\n\n");
        licenseText.setMovementMethod(new ScrollingMovementMethod());
    }

}
