package com.example.administrator.cebcs;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.administrator.cebcs.fragment.ServiceFragment;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private String[] loginStrings;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        loginStrings = getIntent().getStringArrayExtra("Login");

//        Show Text
        showText();

//        Create Toolber
        createToolber();

//        Add Fragmant
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentService123, ServiceFragment.serviceInstance(loginStrings)).commit();
        }


    }   // Main Method

    private void createToolber() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolberService);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("เมนู");

        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(ServiceActivity.this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }   // create Toolber

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showText() {

        TextView nameTextView = (TextView) findViewById(R.id.txtName);
        TextView idTextView = (TextView) findViewById(R.id.txtID);

        nameTextView.setText("ชื่อ " + loginStrings[2] + " " + loginStrings[3]);
        idTextView.setText("รหัส " + loginStrings[1]);

    }

}   // Main Class
