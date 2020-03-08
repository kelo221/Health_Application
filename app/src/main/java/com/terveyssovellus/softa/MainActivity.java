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
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;
import com.terveyssovellus.softa.fragments.AddFragment;
import com.terveyssovellus.softa.fragments.HomeFragment;
import com.terveyssovellus.softa.fragments.ListFragment;
import com.terveyssovellus.softa.fragments.SettingsFragment;
import com.terveyssovellus.softa.ui.Profile;
import com.terveyssovellus.softa.ui.ProfileCreationForm;
import com.yariksoffice.lingver.Lingver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    public static Profile profile;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button button3;


    private HomeFragment homeFragment;
    private ListFragment helpFragment;
    private AddFragment addFragment;
    private SettingsFragment settingsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);











        button3 = findViewById(R.id.button3);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        homeFragment = new HomeFragment();
        addFragment = new AddFragment();
        helpFragment = new ListFragment();
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

        prefs = getSharedPreferences("healthApp", Context.MODE_PRIVATE);
        openProfile();
    }

    private void openProfile(){
        String profileJSON = prefs.getString("savedProfile","");
        if(profileJSON.equals("")){
            profileCreationForm();
        }

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


        Intent intent = new Intent(this, CurrentProgram.class);
        startActivity(intent);


    }
}
