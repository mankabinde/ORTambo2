package com.example.admin.ortambo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 8/2/2017.
 */

public class CategoryAdapter  extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context Context, FragmentManager fm) {
        super(fm);
        mContext = Context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelFragment ();
            };
            return new HotelFragment();
        }


        @Override
        public int getCount () {
            return 3;

        }




    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Hotels";
        }
        if (position == 1) {
            return "Resturants";
        }

        if (position == 2) {
            return "Viewing_Deck";
        }else {
            return "Viewing_Deck";

        }

    }
}
