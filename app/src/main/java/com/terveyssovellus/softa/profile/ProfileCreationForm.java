package com.terveyssovellus.softa.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.google.android.material.snackbar.Snackbar;
import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.R;

public class ProfileCreationForm extends AppCompatActivity {
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

        activityFullScreen();
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
        if(noInputErrors(caller)){
            MainActivity.profile = new Profile(name,age,position);
            finish();
        }
    }

    private Boolean noInputErrors(View caller){
        name = nameView.getText().toString();
        String ageString = ageView.getText().toString();
        age = ageString.equals("")?-1:Integer.parseInt(ageString);
        int positionID = positionView.getCheckedRadioButtonId();
        if(name.equals("")){
            Snackbar snackbar = Snackbar.make(caller, R.string.name_error, Snackbar.LENGTH_LONG);
            snackbar.show();
        } else if(invalidAge(ageString)){
            Snackbar snackbar = Snackbar.make(caller, R.string.age_error, Snackbar.LENGTH_LONG);
            snackbar.show();
        } else if(positionID == -1){
            Snackbar snackbar = Snackbar.make(caller, R.string.position_error, Snackbar.LENGTH_LONG);
            snackbar.show();
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

    public void skip(View caller){
        finish();
    }
}