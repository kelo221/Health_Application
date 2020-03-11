package com.terveyssovellus.softa.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.profile.Mood;
import com.terveyssovellus.softa.profile.MoodHistory;
import com.terveyssovellus.softa.profile.Profile;

public class HomeFragment extends Fragment implements View.OnClickListener {
    TextView greeting, question;

    public HomeFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        greeting = (TextView)view.findViewById(R.id.home_greeting);
        question = (TextView)view.findViewById(R.id.home_question);
        Button positive = (Button)view.findViewById(R.id.positive);
        Button neutral = (Button)view.findViewById(R.id.neutral);
        Button negative = (Button)view.findViewById(R.id.negative);
        Button history = (Button)view.findViewById(R.id.mood_history_button);

        positive.setOnClickListener(this);
        negative.setOnClickListener(this);
        neutral.setOnClickListener(this);
        history.setOnClickListener(this);

        return view;
    }

    @Override
    public void onStart(){
       greeting.setText(getResources().getString(R.string.hei) + " " + Profile.getInstance().getName());
       question.setText(R.string.greetings);
       super.onStart();
    }

    @Override
    public void onClick(View caller) {
        switch (caller.getId()){
            case R.id.positive:
                Toast.makeText(getContext(), R.string.feeling_good, Toast.LENGTH_LONG).show();
                saveMood(caller);
                break;
            case R.id.neutral:
                Toast.makeText(getContext(), R.string.feeling_neut, Toast.LENGTH_LONG).show();
                saveMood(caller);
                break;
            case R.id.negative:
                Toast.makeText(getContext(), R.string.feeling_bad, Toast.LENGTH_LONG).show();
                saveMood(caller);
                break;
            case R.id.mood_history_button:
                showMoodHistory();
                break;
        }
    }

    private void saveMood(View caller){
        int moodInt = Integer.parseInt((String)caller.getTag());
        Profile.getInstance().addMood(new Mood(moodInt));
    }

    private void showMoodHistory(){
        Intent intent = new Intent(getContext(), MoodHistory.class);
        startActivity(intent);
    }
}