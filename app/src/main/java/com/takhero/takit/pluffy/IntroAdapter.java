package com.takhero.takit.pluffy;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IntroAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public IntroAdapter(Context context){
        this.context=context;
    }

    //Array of screen layouts
    public int[] layouts={
            R.layout.intro_one,
            R.layout.intro_two,
            R.layout.intro_three
    };


    // Returns total number of screens
    @Override
    public int getCount() {
        return layouts.length;
    }

    // assign the view to the object
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // Returns the layout at the given position of the view pager
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view= layoutInflater.inflate(layouts[position],container,false);
        container.addView(view);

        return view;
    }

    // stop slide on last screen
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}