package com.example.inclass04;

import android.content.Context;
import android.content.Intent;
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

    User user;
    EditText name_input, email_input, id_input;
    TextView dept_select;
    final static String DEPT = "department_selection";





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";


    // TODO: Rename and change types of parameters
    private String name, email, id, department;


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
    public static RegistrationFragment newInstance(String name, String email, String id, String department) {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM1, email);
        args.putString(ARG_PARAM1, id);
        args.putString(ARG_PARAM1, department);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.name = getArguments().getString(ARG_PARAM1);
            this.email = getArguments().getString(ARG_PARAM2);
            this.id = getArguments().getString(ARG_PARAM3);
            this.department = getArguments().getString(ARG_PARAM4);

        }

    }

    public void update(String name, String email, String id, String department){
        this.name = name;
        this.id = id;
        this.email = email;
        this.department = department;
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
                regint.gotoSelect();


            }
        });

            name_input = regView.findViewById(R.id.name);
            String name = name_input.getText().toString();

            email_input = regView.findViewById(R.id.email);
            String email = email_input.getText().toString();

            id_input = regView.findViewById(R.id.id);
            String id = id_input.getText().toString();

            dept_select = (TextView) regView.findViewById(R.id.dept_view);
            dept_select.setText(this.department);



        regView.findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( name.isEmpty() && email.isEmpty() && id.isEmpty() && dept_select.toString().isEmpty()) {
                    Toast toast = Toast.makeText(getActivity(), "Missing Information", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else{

                    user = new User(name,email, id, dept_select.toString());
                    regint2.gotoProfile(user);
                   /* FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentMain, new ProfileFragment(),"ProfileFragment");
                    transaction.addToBackStack(null);
                    transaction.commit();

                    */
                }


            }
        });

        return regView;
    }


    @Override
    public void onResume() {
        super.onResume();
        Bundle args = getArguments();
        if(args!=null){
            name_input.getText().toString();

            email_input.getText().toString();

            id_input.getText().toString();

            dept_select.setText(args.getString(DEPT));
        }
    }



    RegInt regint;
    public interface  RegInt{
        void gotoSelect();
    }

    RegInt2 regint2;
    public interface RegInt2{
        void gotoProfile(User user);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof RegInt ) {
            regint = (RegInt)context;
        } else {
            throw new RuntimeException(context.toString() + "must implement RegInt");
        }

        if (context instanceof RegInt2 ) {
            regint2 = (RegInt2)context;
        } else {
            throw new RuntimeException(context.toString() + "must implement RegInt");
        }
    }
}