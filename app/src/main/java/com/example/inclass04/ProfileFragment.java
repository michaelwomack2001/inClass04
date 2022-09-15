package com.example.inclass04;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters

    TextView name_out, email_out, id_out, department_out;
    private String name, email, id, department;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
    // * @param param1 Parameter 1.
    // * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String name, String email, String id, String department) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM2, email);
        args.putString(ARG_PARAM3, id);
        args.putString(ARG_PARAM4, department);
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

    public void createProfile(String name, String email, String id, String department){
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
        name_out.setText(name);
        email_out.setText(email);
        id_out.setText(id);
        department_out.setText(department);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View profileView = inflater.inflate(R.layout.fragment_profile, container, false);

        name_out = (TextView)profileView.findViewById(R.id.nameResult);
        email_out = (TextView)profileView.findViewById(R.id.emailResult);
        id_out = (TextView)profileView.findViewById(R.id.IdResult);
        department_out = (TextView)profileView.findViewById(R.id.deptResult);

        name_out.setText(this.name);
        email_out.setText(this.email);
        id_out.setText(this.id);
        department_out.setText(this.department);
        getActivity().getSupportFragmentManager().beginTransaction();



        return profileView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}