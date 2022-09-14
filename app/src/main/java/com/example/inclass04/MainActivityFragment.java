package com.example.inclass04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityFragment extends Fragment {




    public MainActivityFragment() {
        // Required empty public constructor
    }

    MaintIn mainint;
    public interface MaintIn{
        void gotoRegFragment();
    }






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View mainView =  inflater.inflate(R.layout.fragment_main_activity, container, false);
       mainView.findViewById(R.id.registerBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainint.gotoRegFragment();

                /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentMain, new RegistrationFragment(),"RegFragment");
                transaction.commit();
                 */
            }
        });


        return mainView;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MaintIn) {
            mainint = (MaintIn)context;
        } else {
            throw new RuntimeException(context.toString() + "must implement MaintIn");
        }
    }


}