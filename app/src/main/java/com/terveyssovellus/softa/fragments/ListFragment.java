package com.terveyssovellus.softa.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.terveyssovellus.softa.PlanView;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.plan.PlanList;
import com.terveyssovellus.softa.plan.SimplePlan;
import java.util.List;

/**
 * This is context class for list fragment. The fragment contains only a list of plans and will be
 * shown only to a doctor, not the patient. The list items have onClick events that'll open a new
 * activity containing the information needed to give the plan to a patient (QR-code and a numeric
 * code).
 *
 * @author Jere Lampola
 */
public class ListFragment extends Fragment {
    public static final String PLAN_VIEW_INDEX = "clickIndex";
    private ListView planList;
    private List<SimplePlan> plans;

    /**
     * Mandatory constructor for the fragment
     */
    public ListFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_list, container, false);

        plans = PlanList.getInstance().getPlans();    // list of all plans
        planList = view.findViewById(R.id.plan_list); // list the plans here
        planList.setAdapter(new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1, // use simple list item layout
                plans)
        );

        planList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent nextActivity = new Intent(getContext(), PlanView.class);
                nextActivity.putExtra(PLAN_VIEW_INDEX, i); // tell which plan to display
                startActivity(nextActivity);
            }
        });

        return view;
    }
}