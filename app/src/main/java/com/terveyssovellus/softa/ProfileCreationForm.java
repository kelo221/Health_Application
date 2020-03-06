package com.terveyssovellus.softa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProfileCreationForm extends AppCompatActivity {
    private TextView   nameError, ageError, defaultError, positionError;
    private EditText   nameView, ageView;
    private RadioGroup positionView;
    private String     name;
    private int        age, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_creation_form);

        nameView = findViewById(R.id.profile_form_name);
        ageView = findViewById(R.id.profile_form_age);
        positionView = findViewById(R.id.profile_form_position);

        nameError = findViewById(R.id.name_error);
        ageError = findViewById(R.id.age_error);
        positionError = findViewById(R.id.position_error);
        defaultError = findViewById(R.id.default_error);

        activityFullScreen();
        hideErrors();
    }

    private void activityFullScreen(){
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void hideKeyboard(){
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        } catch (Exception e) {
            // keyboard was already hidden
        }
    }

    public void saveProfile(View caller){
        hideKeyboard();
        if(noInputErrors()){
            MainActivity.profile = new Profile(name,age,position);
            finish();
        }
    }

    private Boolean noInputErrors(){
        name = nameView.getText().toString();
        String ageString = ageView.getText().toString();
        age = ageString.equals("")?-1:Integer.parseInt(ageString);
        int positionID = positionView.getCheckedRadioButtonId();
        if(name.equals("")){
            showErrorMessage("name");
        } else if(invalidAge(ageString)){
            showErrorMessage("age");
        } else if(positionID == -1){
            showErrorMessage("position");
        } else {
            position = Integer.parseInt((String)findViewById(positionID).getTag());
            return true;
        }
        return false;
    }

    private Boolean invalidAge(String ageString){
        return     age < 1
                || age > 150
                || !ageString.equals(String.valueOf(age))
                || ageString.equals("");
    }

    private void showErrorMessage(String reason){
        hideErrors();
        switch(reason){
            case "name":
                nameError.setVisibility(View.VISIBLE);
                break;
            case "age":
                ageError.setVisibility(View.VISIBLE);
                break;
            case "position":
                positionError.setVisibility(View.VISIBLE);
                break;
            default:
                defaultError.setVisibility(View.VISIBLE);
        }
    }

    private void hideErrors(){
        nameError.setVisibility(View.INVISIBLE);
        ageError.setVisibility(View.INVISIBLE);
        positionError.setVisibility(View.INVISIBLE);
        defaultError.setVisibility(View.INVISIBLE);
    }
}