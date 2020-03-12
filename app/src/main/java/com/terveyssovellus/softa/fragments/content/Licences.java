package com.terveyssovellus.softa.fragments.content;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.R;

/**
 * This is the context class for activity that shows the licence disclaimer.
 *
 * @author Ville Kumpulainen
 * @author Jere Lampola
 */
public class Licences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licences);
    }

    protected void onDestroy(){
        Intent settings = new Intent(this, MainActivity.class);
        settings.putExtra(MainActivity.TARGET_FRAGMENT,3); // open back to settings fragment
        finish();
        super.onDestroy();
    }

    /**
     * This method overrides the method that is called when the user presses "back"-button. We do
     * this because we want to give intent some extra, so that correct fragment is opened when the
     * MainActivity starts again.
     * @return true
     */
    @Override
    public boolean onSupportNavigateUp(){
        Intent settings = new Intent(this, MainActivity.class);
        settings.putExtra(MainActivity.TARGET_FRAGMENT,3); // open back to settings fragment
        finish();
        return true;
    }
}