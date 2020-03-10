package com.terveyssovellus.softa.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.terveyssovellus.softa.profile.Profile;
import com.terveyssovellus.softa.profile.ProfileCreationForm;

import static android.content.Context.MODE_PRIVATE;

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
                    SharedPreferences.Editor prefEditor = getActivity()
                            .getSharedPreferences(MainActivity.HAOMA_DATA, MODE_PRIVATE).edit();
                    prefEditor.remove(MainActivity.PROFILE_DATA);
                    prefEditor.commit();
                    resetProfile();
                }
                return true;
            }
        });

        return view;
    }

    private void resetProfile(){
        Profile.getInstance().resetProfile();
        Intent refresh = new Intent(getContext(), ProfileCreationForm.class);
        refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ((Activity)getContext()).finish();
        ((Activity)getContext()).overridePendingTransition(0, 0);
        startActivity(refresh);
    }
}
