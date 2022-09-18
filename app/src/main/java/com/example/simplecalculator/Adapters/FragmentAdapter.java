package com.example.simplecalculator.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Luokka, jossa tehdään sivujen vaihto mahdolliseksi
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    /**
     * Lista, johon kerätään fragmentit
     */
    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    /**
     * Lista, johon kerätään fragmenttejen nimet
     */
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    /**
     * ALustus metodi
     * @param fm
     * @param behavior
     */
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    /**
     * Saadaan tämän hetkinen "sivunumero"
     * @param position
     * @return sivunumero
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    /**
     * Saadaan fragmenttejen määrä
     * @return fragmentArrayList.size()
     */
    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    /**
     * Lisätään listoihin fragmentit ja niiden nimet
     * @param fragment
     * @param title
     */
    public void addFragment(Fragment fragment, String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    /**
     * palauttaa sivun nimen paikan
     * @param position
     * @return fragmentTitle.get(position)
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
