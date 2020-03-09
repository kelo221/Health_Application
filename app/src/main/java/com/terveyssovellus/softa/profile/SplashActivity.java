package com.terveyssovellus.softa.profile;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.R;

public class SplashActivity extends Activity {
    /* timer (in millisecond, 1000 = 1s)
     This makes delay when you open the app at first to show the splashscreen long enough. */
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {setContentView(R.layout.background_splash_portrait);}
        else { setContentView(R.layout.background_splash_horizontal);}

        // If you want to make a timer disabled, delete handler brackets.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // MainActivity.class
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra("state", "launch");
                startActivity(intent);
                finish();
                ///
            }
        }, SPLASH_TIME_OUT);
    }
}
