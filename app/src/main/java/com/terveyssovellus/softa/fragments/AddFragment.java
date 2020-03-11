package com.terveyssovellus.softa.fragments;

import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.terveyssovellus.softa.CurrentProgram;
import com.terveyssovellus.softa.QrReader;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.plan.Plan;
import com.terveyssovellus.softa.plan.PlanArchive;
import com.terveyssovellus.softa.profile.Profile;

import java.util.Arrays;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class AddFragment extends Fragment implements View.OnClickListener {

    EditText qrInput,codeInput;
    TextView planContents;
    Button qrButton,codeButton;
    ScrollView planWrapper;
    String value;

    public AddFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);

        Button qrButton2 = (Button) view.findViewById(R.id.listView_button);
        qrButton = (Button)view.findViewById(R.id.plan_select_qr);
        codeButton = (Button)view.findViewById(R.id.plan_select_code);
        codeInput = (EditText)view.findViewById(R.id.codeInput);
        planWrapper = (ScrollView)view.findViewById(R.id.plan_content_wrapper);
        planContents = (TextView)view.findViewById(R.id.plan_contents);

        setVisibility();

        qrButton.setOnClickListener(this);
        codeButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plan_select_qr:
                selectPlanQR();
                break;
            case R.id.plan_select_code:
                selectPlanCode();
                break;
        }
    }

    /**
     */
    private void setVisibility(){
        Profile profile = Profile.getInstance();
        if(profile.planSelected()){
            qrButton.setVisibility(View.INVISIBLE);
            codeButton.setVisibility(View.INVISIBLE);
            codeInput.setVisibility(View.INVISIBLE);
            planWrapper.setVisibility(View.VISIBLE);
            printPlanContents();
        } else {
            qrButton.setVisibility(View.VISIBLE);
            codeButton.setVisibility(View.VISIBLE);
            codeInput.setVisibility(View.VISIBLE);
            planWrapper.setVisibility(View.INVISIBLE);
        }
    }

    private void selectPlanQR(){
        Intent intent = new Intent(getContext(), QrReader.class);
        startActivity(intent);
    }

    private void hideKeyboard(){
        try {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        } catch (Exception e) {
            // keyboard was already hidden
        }
    }

    private void selectPlanCode(){
        String input = codeInput.getText().toString();
        if(TextUtils.isEmpty(input)){
            Toast.makeText(getContext(),"Input something!",Toast.LENGTH_SHORT).show(); // CHANGE TO STRING
        } else if(input.equals("222")||input.equals("444")){
            Profile.getInstance().setPlanString(input);
            setVisibility();
            hideKeyboard();
        } else {
            Toast.makeText(getContext(),"No such plan!",Toast.LENGTH_SHORT).show(); // CHANGE TO STRING
            /*
            List<Plan> plans = PlanArchive.getInstance().getPlans();
            for(int i=0;i<plans.size();i++){
                if(plans.get(i).getId() == 1){
                    Profile.getInstance().setPlan(plans.get(i));
                    setVisibility();
                    return;
                }
            }
            Toast.makeText(getContext(),"No such plan!",Toast.LENGTH_SHORT).show(); // CHANGE TO STRING
            */
        }
    }

    private void printPlanContents(){
        //Plan plan = Profile.getInstance().getPlan();
        Profile profile = Profile.getInstance();
        String plan = profile.getPlanString();
        switch(plan){
            case "222":
                planContents.setText(R.string.plan_content_septoplasty);
                break;
            case "444":
                planContents.setText(R.string.plan_content_nasal);
                break;
            default:
                profile.setPlanSelectedFalse();
                setVisibility();
        }
    }
}
