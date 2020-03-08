package com.terveyssovellus.softa.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.terveyssovellus.softa.MainActivity;
import com.terveyssovellus.softa.fragments.content.LanguageSelection;
import com.terveyssovellus.softa.R;
import com.terveyssovellus.softa.fragments.content.Licences;

import org.json.JSONArray;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {


    public SettingsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_settings, container, false);
/*
        final ArrayList<String> data = new ArrayList<>();
        data.add("Language");
        data.add("Reset");
        data.add("About");
        data.add("Licence");


 */
        String[] Content = getResources().getStringArray(R.array.fragment_settings_content);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Content);

        ListView lvdata = (ListView) view.findViewById(R.id.Settings_List);
        lvdata.setAdapter(adapter);

       lvdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //Toast.makeText(getContext(), items[position], Toast.LENGTH_SHORT).show();




               switch(position) {
                   case 0:
                       Intent intent = new Intent(getContext(), LanguageSelection.class);
                       startActivity(intent);
                       break;
                   case 1:
                       Toast.makeText(getContext(), R.string.fragment_settings_content_reset, Toast.LENGTH_SHORT).show();
                       break;
                   case 2:
                       Toast.makeText(getContext(), R.string.fragment_settings_content_versio, Toast.LENGTH_SHORT).show();
                       break;
                   case 3:
                       Intent intent2 = new Intent(getContext(), Licences.class);
                       startActivity(intent2);
                       break;
                   default:

                       break;
               }

           }
       });

        lvdata.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {



                if(position == 1){

                        //Toast.makeText(getContext(), "TEST", Toast.LENGTH_SHORT).show(); // debug


                    JSONArray otherJsonArray = new JSONArray();     // resets the array?

                    Intent mStartActivity = new Intent(getContext(), MainActivity.class);
                    int mPendingIntentId = 123456;
                    PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(), mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
                    AlarmManager mgr = (AlarmManager)getContext().getSystemService(Context.ALARM_SERVICE);
                    mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                    System.exit(0);

                }

                return true;



            }
        });




        return view;


    }


    }
