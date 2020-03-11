package com.terveyssovellus.softa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.terveyssovellus.softa.fragments.ListFragment;
import com.terveyssovellus.softa.plan.Plan;
import com.terveyssovellus.softa.plan.PlanList;
import com.terveyssovellus.softa.plan.SimplePlan;

public class PlanView extends AppCompatActivity {
    private int planIndex;
    private ImageView qrCode;
    private TextView planCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_view);

        Bundle b = getIntent().getExtras();
        planIndex = b.getInt(ListFragment.PLAN_VIEW_INDEX,0);
        SimplePlan plan = PlanList.getInstance().getPlans().get(planIndex);

        qrCode = findViewById(R.id.plan_view_qr);
        planCode = findViewById(R.id.plan_view_code);

        qrCode.setImageResource(plan.getQrCode());
        planCode.setText(plan.getId());

        activityFullScreen();
    }

    private void activityFullScreen(){
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public boolean onSupportNavigateUp(){
        Intent settings = new Intent(this, MainActivity.class);
        settings.putExtra(MainActivity.TARGET_FRAGMENT,1);
        finish();
        return true;
    }
}