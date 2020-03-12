package com.terveyssovellus.softa.fragments;

import java.util.List;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.QrReader;
import com.terveyssovellus.softa.plan.PlanList;
import com.terveyssovellus.softa.plan.SimplePlan;
import com.terveyssovellus.softa.profile.Profile;
import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * This is the context class for the fragment that view current plan, or alternatively shows
 * options for selecting it. This fragment will be shown only to patient, not a doctor.
 *
 * @author Minji Choi
 * @author Jere Lampola
 */
public class AddFragment extends Fragment implements View.OnClickListener {
    EditText codeInput;
    TextView planContents;
    ImageView planImage;
    Button qrButton,codeButton;
    ScrollView planWrapper;

    /**
     * Mandatory constructor for the fragment
     */
    public AddFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);

        qrButton = (Button)view.findViewById(R.id.plan_select_qr);      // starts QR-reader activity
        codeButton = (Button)view.findViewById(R.id.plan_select_code);  // submits plan code
        codeInput = (EditText)view.findViewById(R.id.codeInput);        // for inputting plan code
        planWrapper = (ScrollView)view.findViewById(R.id.plan_content_wrapper); // wraps plan views
        planImage = (ImageView)view.findViewById(R.id.plan_image);      // replaced with plan image
        planContents = (TextView)view.findViewById(R.id.plan_contents); // filled with text content

        setVisibility(); // check current status and toggle visibility accordingly

        qrButton.setOnClickListener(this);
        codeButton.setOnClickListener(this);

        codeInput.setOnEditorActionListener(new EditText.OnEditorActionListener(){ // "enter" press
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    codeButton.performClick();
                    return true;
                }
                return false;
            }
        });
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
     * This method toggles visibility of plan contents and elements for selecting a new plan.
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
        try { // avoid null pointer exceptions
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        } catch (Exception e) {
            // keyboard was already hidden
        }
    }

    /**
     * This method is called when user inputs plan code in the EditText view. If the input field is
     * empty or invalid plan code is inputted user will be alerted with Toast-message, otherwise the
     * plan is stored in Profile and visibility is toggled so that elements for selecting the plan
     * are hidden and plan contents are shown instead.
     */
    private void selectPlanCode(){
        String input = codeInput.getText().toString();
        if(TextUtils.isEmpty(input)){
            Toast.makeText(getContext(),"Input something!",Toast.LENGTH_SHORT).show(); // CHANGE TO STRING TODO
        } else if(PlanList.getInstance().planExists(input)){
            Profile.getInstance().setPlanString(input);
            setVisibility();
            hideKeyboard();
        } else {
            Toast.makeText(getContext(),"No such plan!",Toast.LENGTH_SHORT).show(); // CHANGE TO STRING TODO
        }
    }

    /**
     * This method prints the plan contents in the activity. First it will loop through all the
     * plans in PlanList, if the plan id saved in profile doesn't match any of the plans the profile
     * will be set as it doesn't have a plan selected and visibility is toggled. If the plan exists
     * its contents are placed in the corresponding elements.
     */
    private void printPlanContents(){
        Profile profile = Profile.getInstance();
        String planString = profile.getPlanString();
        boolean planFound = false;

        List<SimplePlan> plans = PlanList.getInstance().getPlans();

        for(int i=0;i<plans.size();i++){
            if(plans.get(i).getId().equals(planString)){
                planContents.setText(plans.get(i).getContents());
                planImage.setImageResource(plans.get(i).getImage());
                planFound = true;
            }
        }
        if(!planFound) {
            profile.setPlanSelectedFalse();
            setVisibility();
        }
    }
}

