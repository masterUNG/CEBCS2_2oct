package com.example.administrator.cebcs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.cebcs.R;
import com.example.administrator.cebcs.unity.MyAlert;

/**
 * Created by Administrator on 11/9/2560.
 */

public class MainFrangment extends Fragment {

    private  String edtuserString, edtPasswordString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }   //onCreatView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register Controller
        registerController();

        //Login Controller
        loginController();


    }   //onActivityCreat

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userFditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                edtuserString = userFditText.getText().toString().trim();
                edtPasswordString = passwordEditText.getText().toString().trim();

                if (edtuserString.equals("") || edtPasswordString.equals("")) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getResources().getString(R.string.message_have_space),
                            getResources().getString(R.string.message_have_space));

                } else {
                    checkUsrtAndFass();
                }

            }
        });
    }

    private void checkUsrtAndFass() {

        boolean bolStatus = true; // true ==> UserFalse


    }   // Main Class

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
    }
}   // Main Class
