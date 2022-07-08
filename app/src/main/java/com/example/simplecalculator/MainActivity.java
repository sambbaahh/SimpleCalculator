package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentNavigation();

    }



    public void FragmentNavigation(){
        tablayout = findViewById(R.id.tableLayout);
        viewPager = findViewById(R.id.viewPager);

        tablayout.setupWithViewPager(viewPager);
        Adapter adapter = new Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new Calculator(), getResources().getString(R.string.calculate));
        adapter.addFragment(new History(), getResources().getString(R.string.history));
        viewPager.setAdapter(adapter);
    }
}