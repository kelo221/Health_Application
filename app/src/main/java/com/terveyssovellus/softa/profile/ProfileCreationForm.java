package com.terveyssovellus.softa.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.google.android.material.snackbar.Snackbar;
import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This is the context class for profile creation form. Profile creation form is shown to the user
 * when there is no profile detected, the profile is flagged as !hasBeenCreated or the app is
 * reset from the settings. This class contains methods for validating user inputs.
 *
 * @author Jere Lampola
 */
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

        activityFullScreen(); // set activity in full screen (hide top bar)
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

    /**
     * This method saves the profile, but only if inputs passes validations, then it'll close the
     * activity and give intent to MainActivity.
     *
     * @param caller View, the button that was pressed, will be passed on
     */
    public void saveProfile(View caller){
        hideKeyboard();
        if(noInputErrors(caller)){
            Profile profile = Profile.getInstance();
            List<Mood> emptyMoodList = new ArrayList<>();
            String lang = Locale.getDefault().getLanguage();
            profile.setProfile(name,age,position,false,lang,"",emptyMoodList); // default, empty profile
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // clear other activities
            finish();
            startActivity(intent);
        }
    }

    /**
     * This method will check all three inputs the user will give: name, age and position. Name
     * cannot be empty string, age must be an integer in the range of 1-150 and position must be
     * selected.
     *
     * @param caller View to attach Snackbar to
     * @return true if all the inputs pass validation
     */
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
}