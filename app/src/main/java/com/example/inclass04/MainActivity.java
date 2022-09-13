package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SelectDepartmentFragment.DepartmentReceiver {

    String departmentSet;

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


    @Override
    public void getData(String data) {
        departmentSet = data;
    }
}