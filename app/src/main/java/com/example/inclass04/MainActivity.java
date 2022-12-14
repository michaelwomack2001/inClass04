package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SelectDepartmentFragment.DepartmentParse, MainActivityFragment.MaintIn, RegistrationFragment.RegInt{

    String departmentSet;
    String gotoFrag = "MainFragment";
    User profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (gotoFrag.equals("MainFragment")){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentMain,new MainActivityFragment(),"MainFragment")
                    .commit();
        }

        else if (gotoFrag.equals("RegFragment")){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentMain,new RegistrationFragment(),"RegFragment")
                    .commit();
        }
        else if(gotoFrag== "SelectFragment"){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentMain,new SelectDepartmentFragment(),"SelectFragment")
                    .commit();
        }

        else if(gotoFrag== "ProfileFragment"){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentMain,new ProfileFragment(),"ProfileFragment")
                    .commit();
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


    @Override
    public void gotoRegFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentMain,new RegistrationFragment(),"RegFragment").addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSelect() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentMain,new SelectDepartmentFragment(),"SelectFragment").addToBackStack(null)
                        .commit();

    }


    @Override
    public void getDeptName(String data) {

        departmentSet = data;


        RegistrationFragment regFrag = (RegistrationFragment) getSupportFragmentManager().findFragmentByTag("RegFragment");
        if (regFrag!=null) {
            regFrag.update("","","",departmentSet);
        }
    }

    @Override
    public void gotoProfile(User dataUser) {

        profile = dataUser;
        ProfileFragment profFrag = (ProfileFragment) getSupportFragmentManager().findFragmentByTag("ProfileFragment");
            //profFrag.createProfile("Linh","@dff","hgfgg","cs");
            profFrag.createProfile(profile.getName(), profile.getEmail(), profile.getId(), profile.getDept());




    }

    @Override
    public void profile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentMain, new ProfileFragment(),"ProfileFragment")
                .commitNow();
    }
}