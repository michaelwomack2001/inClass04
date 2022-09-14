package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SelectDepartmentFragment.DepartmentParse, MainActivityFragment.MaintIn, RegistrationFragment.RegInt, RegistrationFragment.RegInt2 {

    String departmentSet;
    String gotoFrag = "MainFragment";
    User profile;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (gotoFrag.equals("MainFragment")){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentMain,new MainActivityFragment(),"RegFragment")
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


        /*
        RegistrationFragment regFrag = (RegistrationFragment) getSupportFragmentManager().findFragmentByTag("RegFragment");
        if (regFrag!=null){
            regFrag.update(departmentSet);
        }

        ProfileFragment profileFragment = (ProfileFragment) getSupportFragmentManager().findFragmentByTag("ProfileFragment");
        if (profileFragment!=null){
            profileFragment.updateProfile(profile);
        }
         */

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

        /*RegistrationFragment regFragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(RegistrationFragment.DEPT,data);
        regFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,regFragment).commit();
         */
        RegistrationFragment regFrag = (RegistrationFragment) getSupportFragmentManager().findFragmentByTag("RegFragment");
        if (regFrag!=null) {
            regFrag.update("","","",departmentSet);
        }

    }


    @Override
    public void gotoProfile(User user) {


        ProfileFragment profFrag = (ProfileFragment) getSupportFragmentManager().findFragmentByTag("ProfileFragment");
        if (profFrag!=null) {
            profFrag.createProfile(user.getName(), user.getEmail(), user.getId(), user.getDept());
        }

    }
}