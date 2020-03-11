package com.terveyssovellus.softa.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.terveyssovellus.softa.PlanView;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.plan.PlanList;
import com.terveyssovellus.softa.plan.SimplePlan;

import java.util.List;
import java.util.Objects;

public class ListFragment extends Fragment {
    public static final String PLAN_VIEW_INDEX = "clickIndex";
    ListView planList;
    List<SimplePlan> plans;

    public ListFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_list, container, false);

        plans = PlanList.getInstance().getPlans();

        planList = view.findViewById(R.id.plan_list);
        planList.setAdapter(new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                plans)
        );

        planList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent nextActivity = new Intent(getContext(), PlanView.class);
                nextActivity.putExtra(PLAN_VIEW_INDEX, i);
                startActivity(nextActivity);
            }
        });

        return view;
    }
}