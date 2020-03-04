package com.terveyssovellus.softa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;

    private HomeFragment homeFragment;
    private ListFragment listFragment;
    private AddFragment addFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        homeFragment = new HomeFragment();
        listFragment = new ListFragment();
        addFragment = new AddFragment();
        settingsFragment = new SettingsFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(homeFragment, "Home");
        viewPagerAdapter.addFragment(listFragment, "List");
        viewPagerAdapter.addFragment(addFragment, "Add");
        viewPagerAdapter.addFragment(settingsFragment, "Settings");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_list_alt_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_add_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_settings_24);




        /*  Can add certain number popup if needed for certain notifications
            getTabAt means the location of the number

        BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(0);

         */

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
}
