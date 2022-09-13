package com.example.inclass04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {


    EditText name_input, email_input, id_input;
    TextView dept_select;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String deparment;


    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.

     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String department) {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, department);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.deparment = getArguments().getString(ARG_PARAM1);
        }

    }
    public void update(String department){
        this.deparment = department;
        dept_select.setText(department);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View regView =  inflater.inflate(R.layout.fragment_registration, container, false);
        regView.findViewById(R.id.select_reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentMain, new SelectDepartmentFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        name_input = regView.findViewById(R.id.name);
        String name = name_input.getText().toString();

        email_input = regView.findViewById(R.id.email);
        String email = email_input.getText().toString();

        id_input = regView.findViewById(R.id.id);
        String id = id_input.getText().toString();



        regView.findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((name.isEmpty()) || email.isEmpty() || id.isEmpty() || dept_select.toString().isEmpty()) {
                    Toast toast2 = Toast.makeText(getActivity(), "Missing Information", Toast.LENGTH_SHORT);
                    toast2.setGravity(Gravity.CENTER, 0, 0);
                    toast2.show();
                }

            }
        });

        return regView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}