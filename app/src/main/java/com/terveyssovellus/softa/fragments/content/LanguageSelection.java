package com.terveyssovellus.softa.fragments.content;

import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.profile.Profile;

/**
 * This class is used to handle language changing when the "change language" option is clicked in
 * settings menu and some language is selected in the activity that starts. It is also context for
 * that activity.
 *
 * @author Ville Kumpulainen
 * @author Jere Lampola
 */
public class LanguageSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);
    }

    /**
     * This method will change the language when called. Language ISO-code is stored in the buttons'
     * tag-attribute ("fi","en","sv"...), and it is used to set configuration locale in order change
     * the language. When the locale is changed, app will use strings.xml associated with the
     * country. Language is also stored in Profile to keep it when the app is closed and restarted,
     * language ISO-code will be saved with Profile in SharedPreferences.
     *
     * @param caller is the view that is clicked, tag will be read from it to determine language
     */
    public void changeLanguage(View caller){
        String lang = (String)caller.getTag();   // get view tag and convert it to string
        Profile.getInstance().setLanguage(lang); // set language for profile (and SharedPreferences)
        Locale locale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class); // open MainActivity after changing
        refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);      // clear other possible activities
        refresh.putExtra(MainActivity.TARGET_FRAGMENT,3);      // open to settings fragment
        finish();               // end this activity
        startActivity(refresh); // start next
    }
}