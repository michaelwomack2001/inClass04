package com.example.inclass04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectDepartmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectDepartmentFragment extends Fragment {

    RadioGroup department;
    String dept_out;

    /*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

     */

    public SelectDepartmentFragment() {
        // Required empty public constructor
    }

    /*
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectDepartmentFragment.
     */
    /*
    // TODO: Rename and change types and number of parameters
    public static SelectDepartmentFragment newInstance(String param1, String param2) {
        SelectDepartmentFragment fragment = new SelectDepartmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

     */


    public interface DepartmentParse{
        public void getDeptName(String data);
    }

    DepartmentParse selectedDept;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DepartmentParse){
            selectedDept = (DepartmentParse) context;
        }
        else{
            throw new RuntimeException(context.toString()+"must implement the interface");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View deptView =  inflater.inflate(R.layout.fragment_select_department, container, false);

        department = deptView.findViewById(R.id.concentration);


        deptView.findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int checked = department.getCheckedRadioButtonId();
                if(checked==R.id.cs){
                    selectedDept.getDeptName("Computer Science");
                }
                else if (checked==R.id.software){
                    selectedDept.getDeptName("Software Info. Systems");
                }
                else if (checked==R.id.bio){
                    selectedDept.getDeptName("Bio Informatics");
                }
                else {
                    selectedDept.getDeptName("Data Science");
                }

                //getActivity().getSupportFragmentManager().popBackStack();


            }

        });

        deptView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return deptView;
    }
}