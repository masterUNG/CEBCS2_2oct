package com.example.administrator.cebcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.cebcs.fragment.ServiceFragment;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private String[] loginStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        loginStrings = getIntent().getStringArrayExtra("Login");

//        Show Text
        showText();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentService123, new ServiceFragment()).commit();
        }


    }   // Main Method

    private void showText() {

        TextView nameTextView = (TextView) findViewById(R.id.txtName);
        TextView idTextView = (TextView) findViewById(R.id.txtID);

        nameTextView.setText("ชื่อ " + loginStrings[2] + " " + loginStrings[3]);
        idTextView.setText("รหัส " + loginStrings[1]);

    }

}   // Main Class
