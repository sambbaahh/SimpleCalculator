package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tableLayout);
        tabLayout.getResources().getColor(R.color.FunctionAndOtherButtons);
        FragmentNavigation();

    }



    public void FragmentNavigation(){
        tabLayout = findViewById(R.id.tableLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentAdapter.addFragment(new Calculator(), getResources().getString(R.string.calculate));
        fragmentAdapter.addFragment(new History(), getResources().getString(R.string.history));
        viewPager.setAdapter(fragmentAdapter);
    }
}