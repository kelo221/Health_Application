package com.terveyssovellus.softa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CurrentProgram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String layout = "default";
        int chooseProgram;
        try {
            layout = getIntent().getStringExtra("layout_selector");
        } catch (Exception e){
            e.printStackTrace();
        }

        Toast.makeText(this,layout, Toast.LENGTH_SHORT).show();
        chooseProgram = Integer.valueOf(layout);

        switch(chooseProgram) {
            case 222:
                setContentView(R.layout.activity_nasal_polyops);
                break;
            case 444:
                setContentView(R.layout.activity_septoplasty);
                break;
            default:
                setContentView(R.layout.activity_nasal_polyops);
                break;
        }
    }
}