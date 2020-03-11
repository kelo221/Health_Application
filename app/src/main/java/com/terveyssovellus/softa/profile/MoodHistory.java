package com.terveyssovellus.softa.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.terveyssovellus.softa.R;
import java.util.List;

public class MoodHistory extends AppCompatActivity {
    ListView moodList;
    List<Mood> moodHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        moodList = findViewById(R.id.mood_list);
        moodHistory = Profile.getInstance().getMoodList();
    }

    protected void onStart() {
        super.onStart();
        moodList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                moodHistory)
        );
    }
}