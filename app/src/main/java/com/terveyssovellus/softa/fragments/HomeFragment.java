package com.terveyssovellus.softa.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.terveyssovellus.softa.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;



public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        TextView patientName = (TextView) view.findViewById(R.id.patient_name);
        Button positive = (Button) view.findViewById(R.id.positive);
        Button neutral = (Button) view.findViewById(R.id.neutral);
        Button negative = (Button) view.findViewById(R.id.negative);

        ArrayList<String> userData = new ArrayList<>();

       positive.setOnClickListener(this);
       negative.setOnClickListener(this);
       neutral.setOnClickListener(this);

        //patientName.setText(Profile.getName());
        return view;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.positive:
                savePositive();
                break;
            case R.id.neutral:
                saveNeutral();
                break;
            case R.id.negative:
                saveNegative();
                break;
        }
    }

            public String getDate(){

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZZ");
            String  currentDate = simpleDateFormat.format(new Date());
            return currentDate;
        }

        public void savePositive(){
           // userData.add(1, getDate());
            Toast.makeText(getContext(), "DEBUG1 "+ getDate(), Toast.LENGTH_SHORT).show();
        }
        public void saveNeutral(){
            //userData.add(0, getDate());
            Toast.makeText(getContext(), "DEBUG0" + getDate(), Toast.LENGTH_SHORT).show();
        }
        public void saveNegative(){
            //userData.add(-1, getDate());
            Toast.makeText(getContext(), "DEBUG-1 "+ getDate(), Toast.LENGTH_SHORT).show();
        }

}