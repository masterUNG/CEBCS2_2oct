package com.example.administrator.cebcs.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.administrator.cebcs.MainActivity;
import com.example.administrator.cebcs.R;
import com.example.administrator.cebcs.unity.MyAlert;

/**
 * Created by Administrator on 12/9/2560.
 */

public class RegisterFragment extends Fragment{

    //Explicit
    private String idStudentString, nameString, surnameString, genderString, passwordString, rePasswordString;
    private boolean aBoolean = true;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register,container,false);
        return view;
        //OnCreevied
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Toolbar Controller
        toolbarController();

        //Save Controller
        saveController();

        //Radio Controller
        radioController();


    }//onActivityCreat

    private void radioController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                aBoolean = false;
                switch (i) {
                    case R.id.radMale:
                        genderString = "Male";
                        break;
                    case R.id.radFemale:
                        genderString = "Female";
                        break;
                }
            }
        });
    }

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From EditText
                EditText idStudentEditText = getView().findViewById(R.id.edtIDstudent);
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText surnameEditText = getView().findViewById(R.id.edtSurName);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);
                EditText repasswordEditText = getView().findViewById(R.id.edtRePassword);

                //Change Data Type to String
                idStudentString = idStudentEditText.getText().toString().trim();
                nameString = nameEditText.getText().toString().trim();
                surnameString = surnameEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                rePasswordString = repasswordEditText.getText().toString().trim();

                //Check Space
                if (idStudentString.equals("") ||
                        nameString.equals("") ||
                        surnameString.equals("") ||
                        passwordString.equals("") ||
                        rePasswordString.equals("")) {
                    //True
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.have_space), getString(R.string.message_have_space) );

                } else if (idStudentString.length() != 13) {
                    //idStuudent False
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.id_false), getString(R.string.mess_id_false));


                } else if (aBoolean) {
                    //Non Checked Gender
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.gender_false), getString(R.string.mass_gender_false));
                } else if (passwordString.equals(rePasswordString)) {
                    //True Password
                } else {
                    //False Password
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.pass_false), getString(R.string.mass_pass_false));
                }



            } // on Click
        });



    }

    private void toolbarController() {
        Toolbar toolbar = getView().findViewById(R.id.ToobarRegister);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getResources().getString(R.string.register));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });



    }

}//Main Class