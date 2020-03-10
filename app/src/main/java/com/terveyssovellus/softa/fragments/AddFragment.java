package com.terveyssovellus.softa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.terveyssovellus.softa.R;

public class AddFragment extends Fragment {


    String programNumber;
    EditText usernameEditText;

    public AddFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add, container, false);

        int qrCodeResult = 0;

        usernameEditText = (EditText) view.findViewById(R.id.numberInput);





        if (qrCodeResult == 222) {
            return inflater.inflate(R.layout.activity_nasal_polyops, container, false);
        } else if (qrCodeResult == 444) {
            return inflater.inflate(R.layout.activity_septoplasty, container, false);
        } else {
            return inflater.inflate(R.layout.fragment_add, container, false);
        }






    }


    public void qrButtonPressed(View view) {
        programNumber = usernameEditText.getText().toString();
        if (programNumber.matches("")) {
            Toast.makeText(getContext(), "You did not enter a username", Toast.LENGTH_SHORT).show();
        }
    }
}