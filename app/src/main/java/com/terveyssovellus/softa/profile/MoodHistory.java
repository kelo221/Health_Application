package com.terveyssovellus.softa.profile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.terveyssovellus.softa.R;
import java.util.List;

/**
 * This is the context class for mood history list view. It does nothing but shows the list of
 * profiles moodList in a list view.
 *
 * @author Jere Lampola
 */

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
                android.R.layout.simple_list_item_1, // use simple list item layout
                moodHistory)
        );
    }
}