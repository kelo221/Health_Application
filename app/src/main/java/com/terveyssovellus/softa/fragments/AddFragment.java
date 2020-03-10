package com.terveyssovellus.softa.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.terveyssovellus.softa.CurrentProgram;
import com.terveyssovellus.softa.R;

public class AddFragment extends Fragment implements View.OnClickListener {

    EditText qrInput;
    Button qrButton;
    String value;

    public AddFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        Button qrButton = (Button) view.findViewById(R.id.listView_button);
        qrInput = view.findViewById(R.id.numberInput);
        qrInput.setText("");
        qrButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.listView_button:
                qrButtonPressed();
                break;
        }
    }

    public void qrButtonPressed() {

        if (TextUtils.isEmpty(qrInput.getText().toString())) {
            Toast.makeText(getContext(), "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
        } else {
            value = qrInput.getText().toString();
            setQrActivity();
        }
    }

    public void setQrActivity(){


        Intent intent = new Intent(getContext(), CurrentProgram.class);
        intent.putExtra("layout_selector", value.trim());
        startActivity(intent);


    }
}
