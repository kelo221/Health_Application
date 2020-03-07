package com.terveyssovellus.softa.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.terveyssovellus.softa.fragments.content.LanguageSelection;
import com.terveyssovellus.softa.R;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {


    public SettingsFragment() {
    }

    String items[] = new String[]{"Language", "About", "Licences"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final ArrayList<String> data = new ArrayList<>();
        data.add("Language");
        data.add("About");
        data.add("Licence");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data);

        ListView lvdata = (ListView) view.findViewById(R.id.Settings_List);
        lvdata.setAdapter(adapter);

       lvdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //Toast.makeText(getContext(), items[position], Toast.LENGTH_SHORT).show();


               Intent intent = new Intent(getContext(), LanguageSelection.class);
               startActivity(intent);
           }
       });




        return view;


    }


    }
