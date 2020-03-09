package com.terveyssovellus.softa.fragments.content;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.R;
import java.util.Locale;

public class LanguageSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        ImageButton langButtonEN = findViewById(R.id.lan_eng);
        ImageButton langButtonFI = findViewById(R.id.lan_fi);
        ImageButton langButtonSV = findViewById(R.id.lan_swe);

        langButtonEN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View caller) {
                changeLang((String)caller.getTag());
            }
        });

        langButtonFI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View caller) {
                changeLang((String)caller.getTag());
            }
        });
    }

    public void changeLang(String lang){
        Locale locale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        refresh.putExtra(MainActivity.TARGET_FRAGMENT,3);
        finish();
        startActivity(refresh);
    }
}
