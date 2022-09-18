package com.example.simplecalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.simplecalculator.Adapters.FragmentAdapter;
import com.example.simplecalculator.fragments.Calculator;
import com.example.simplecalculator.fragments.History;
import com.google.android.material.tabs.TabLayout;

/**
 * Pääluokka, jossa alustetaan koko ohjelman näkymä
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Näyttää sivut
     */
    private ViewPager viewPager;
    /**
     * Ylhäällä sijaitseva navigointi palkki
     */
    private TabLayout tabLayout;

    /**
     * Alustus metodi
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentNavigation();

    }


    /**
     * Syötetään tarvittavat elementit ja tiedot tablayoutille
     */
    public void FragmentNavigation(){
        tabLayout = findViewById(R.id.tableLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentAdapter.addFragment(new Calculator(), getResources().getString(R.string.calculate));
        fragmentAdapter.addFragment(new History(), getResources().getString(R.string.history));

        viewPager.setAdapter(fragmentAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_calculate_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_history_24);

    }
}