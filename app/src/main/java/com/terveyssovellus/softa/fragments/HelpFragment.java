package com.terveyssovellus.softa.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.terveyssovellus.softa.R;

/**
 * This is the context class for help fragment. It also handles the functionality for calling
 * emergency number.
 *
 * @author Ville Kumpulainen
 * @author Johanna Väisälä
 */
public class HelpFragment extends Fragment implements View.OnClickListener {
    final String alarmNumber = "tel:0400982662";

    /**
     * Mandatory constructor for the fragment
     */
    public HelpFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_help, container, false);

        Button button = (Button) view.findViewById(R.id.buttonCall);
        button.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View arg0) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(alarmNumber));

        if (ActivityCompat.checkSelfPermission(getContext(),
            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }
};
