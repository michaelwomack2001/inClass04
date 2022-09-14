package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SelectDepartmentFragment.DepartmentParse {

    String departmentSet;
    User profile;

    @Override
    public void getDeptName(String data) {

        RegistrationFragment regFragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(RegistrationFragment.DEPT,data);
        regFragment.setArguments(args);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,regFragment).commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentMain,new MainActivityFragment(),"MainFragment")
                .commit();

        RegistrationFragment regFrag = (RegistrationFragment) getSupportFragmentManager().findFragmentByTag("RegFragment");
        if (regFrag!=null){
            regFrag.update(departmentSet);
        }

        ProfileFragment profileFragment = (ProfileFragment) getSupportFragmentManager().findFragmentByTag("ProfileFragment");
        if (profileFragment!=null){
            profileFragment.updateProfile(profile);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }



}