package com.terveyssovellus.softa.fragments;

import android.app.Activity;
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

/**
 * This is the context class for settings fragment. It contains only a list of settings items in a
 * list view. It also has functionality for resetting the app/profile and viewing version number.
 *
 * @author Ville Kumpulainen
 * @author Jere Lampola
 */
public class SettingsFragment extends Fragment {
    /**
     * Mandatory constructor for the fragment
     */
    public SettingsFragment(){}

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

        ListView listView = (ListView) view.findViewById(R.id.Settings_List);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){ // position turns to 1 after long press
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

    /**
     * This method resets the data saved in profile and opens profile creation form.
     */
    private void resetProfile(){
        Profile.getInstance().resetProfile();
        Intent intent = new Intent(getContext(), ProfileCreationForm.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ((Activity)getContext()).finish();
        startActivity(intent);
    }
}

