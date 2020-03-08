package com.terveyssovellus.softa.fragments.content;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.terveyssovellus.softa.R;
import com.yariksoffice.lingver.Lingver;

import java.util.Locale;

public class LanguageSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        Locale currentLocale;
        currentLocale = Locale.getDefault();
        initLang();


        final ImageButton USA = findViewById(R.id.lan_eng);
        ImageButton FIN = findViewById(R.id.lan_fi);
        ImageButton SWE = findViewById(R.id.lan_swe);

        USA.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {


                changeLang();




            }
        });

        }


        public void changeLang(){

            Lingver.getInstance().setLocale(this, Locale.US);

        }

    public void initLang(){

      //https://github.com/YarikSOffice/lingver

    }
}
