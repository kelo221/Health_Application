package com.terveyssovellus.softa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.terveyssovellus.softa.fragments.AddFragment;
import com.terveyssovellus.softa.fragments.HomeFragment;
import com.terveyssovellus.softa.fragments.HelpFragment;
import com.terveyssovellus.softa.fragments.SettingsFragment;
import com.terveyssovellus.softa.profile.Profile;
import com.terveyssovellus.softa.profile.ProfileCreationForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button button3;

    private HomeFragment homeFragment;
    private HelpFragment helpFragment;
    private AddFragment addFragment;
    private SettingsFragment settingsFragment;

    public static final String TARGET_FRAGMENT = "targetFragment";
    public static final String NEW_LANGUAGE = "newLanguage";

    public static final String HAOMA_DATA = "haomaData";
    public static final String PROFILE_DATA = "profiledata";
    public static final String FIRST_USE = "firstUse";

    private Boolean appHasStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(HAOMA_DATA, Context.MODE_PRIVATE);
        writePrefs();
        loadProfile();

        button3 = findViewById(R.id.positive);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        homeFragment = new HomeFragment();
        addFragment = new AddFragment();
        helpFragment = new HelpFragment();
        settingsFragment = new SettingsFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(homeFragment, getString(R.string.fragment_name_home));
        viewPagerAdapter.addFragment(addFragment, getString(R.string.fragment_name_add));
        viewPagerAdapter.addFragment(helpFragment, getString(R.string.fragment_name_help));
        viewPagerAdapter.addFragment(settingsFragment, getString(R.string.fragment_name_settings));
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_add_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_help_outline_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_settings_24);

        /*  Can add certain number popup if needed for certain notifications
            getTabAt means the location of the number

        BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(0);
         */
    }

    protected void onStart(){
        writePrefs();
        //Profile profile = Profile.getInstance();
        //setLanguage(profile.getLanguage());
        viewPager.setCurrentItem(getIntent().getIntExtra(MainActivity.TARGET_FRAGMENT,0));
        super.onStart();
    }

    protected void onRestart(){
        super.onRestart();
    }

    protected void onPause(){
        writePrefs();
        super.onPause();
    }

    public void setLanguage(String language){
        Locale locale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf,dm);
        setContentView(R.layout.activity_main);
    }

    private void writePrefs(){
        Profile profile = Profile.getInstance();
        if(profile.hasBeenCreated() != null){
            Gson gson = new Gson();
            String profileJSON = gson.toJson(profile);
            SharedPreferences.Editor prefEditor = prefs.edit();
            prefEditor.putString(PROFILE_DATA,profileJSON);
            prefEditor.putBoolean(FIRST_USE,!profile.hasBeenCreated());
            prefEditor.commit();
        }
    }

    private void loadProfile(){
        Gson gson = new Gson();
        if(prefs.contains(PROFILE_DATA)){
            String profileJSON = prefs.getString(PROFILE_DATA,"");
            Profile tempProfile = gson.fromJson(profileJSON,Profile.class);
            if(tempProfile.hasBeenCreated()){
                Profile.getInstance().setProfile(tempProfile);
            } else {
                profileCreationForm();
            }
        } else {
            profileCreationForm();
        }
        //appHasStarted = true;
        Profile profile = Profile.getInstance();
        setLanguage(profile.getLanguage());
    }

    private void profileCreationForm(){
        Intent intent = new Intent(this, ProfileCreationForm.class);
        startActivity(intent);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }

    public void test(View view) {
        //setContentView(R.layout.current_program);

        //Intent intent = new Intent(this, CurrentProgram.class);
        //startActivity(intent);
    }

    public void testQR(View caller){
        Intent intent = new Intent(this, QR_reader.class);
        startActivity(intent);
    }
}
