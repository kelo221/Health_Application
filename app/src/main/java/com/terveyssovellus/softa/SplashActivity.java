package com.terveyssovellus.softa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
    /* timer (in millisecond, 1000 = 1s)
     This makes delay when you open the app at first to show the splashscreen long enough. */
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.background_splash);


        // If you want to make a timer disabled, delete handler brackets.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // MainActivity.class
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra("state", "launch");
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
