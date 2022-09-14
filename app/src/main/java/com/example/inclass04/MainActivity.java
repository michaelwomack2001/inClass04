package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SelectDepartmentFragment.DepartmentParse {

    String departmentSet;

    @Override
    public void getDeptName(String data) {
        /*RegistrationFragment regFrag = (RegistrationFragment)getSupportFragmentManager().findFragmentByTag("RegFragment");
        ((TextView)regFrag.getView().findViewById(R.id.dept_view)).setText(data);

         */
        departmentSet = data;
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







    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    /*@Override
    public void getData(String data) {
        departmentSet = data;
    }

     */
}