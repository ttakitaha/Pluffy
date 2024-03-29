package com.takhero.takit.pluffy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private Button btnNext, btnSkip;
    private IntroAdapter introAdapter;
    private TextView[] mDots;
    private PrefManager prefManager;
    private int currentItem;
    DBHelper dbHelper;
    int score = 0, current = 0, currentHigh = 0, currentEndless = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
// Check if the app is launched first time before setting layout
        prefManager=new PrefManager(this);
        if (!prefManager.isFirstLaunch()){
            launchMainScreen();// goto main activity and finish current
        }
        //dbHelper = new DBHelper(getApplicationContext());
        setContentView(R.layout.activity_intro);
        transparentStatusBar();// make status bar transparent
        findViews();// find xml views in java
        //resetHigh();
        setClickListener();// set on click listeners
        setupViewPager();// setup the viewpager, set adapter and page listener
        addDotsIndicator(0);// called for the first launch, after this handled in page listener
    }
    private void launchMainScreen() {
        prefManager.setIsFirstLaunch(false);
        startActivity(new Intent(IntroActivity.this,MainActivity.class));
        finish();
    }
    private void transparentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }
    private void setupViewPager() {
        introAdapter = new IntroAdapter(this);
        viewPager.setAdapter(introAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
    }
    private void findViews() {
        viewPager = findViewById( R.id.view_pager );
        dotsLayout = findViewById( R.id.layoutDots );
        btnNext = findViewById( R.id.btn_next );
        btnSkip = findViewById( R.id.btn_skip );
    }
    private void setClickListener() {
        btnSkip.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }
    public void addDotsIndicator(int position){
// Adding TetView dynamically
        mDots=new TextView[introAdapter.getCount()];
/* Remove aprvious views when called next time
if not called then views will keep on adding*/
        dotsLayout.removeAllViews();
// Set bullets in each dot text view
        for (int i=0; i< mDots.length; i++){
            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("•"));// Html code for bullet
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dot_inactive_color));
            dotsLayout.addView(mDots[i]);
        }
        if (mDots.length>0){
// change color of the current selected dot
            mDots[position].setTextColor(getResources().getColor(R.color.dot_active_color));
        }
    }
    ViewPager.OnPageChangeListener pageChangeListener= new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageSelected(int position) {
            currentItem=position; // currentItem used to get current position and then increase position on click on next button
            addDotsIndicator(position);
// change the next button text to "next" / "finish"
            if (position==introAdapter.getCount()-1){
// last page, make it "finish" and make the skip button invisible
                btnNext.setText(getString(R.string.finish));
                btnSkip.setVisibility(View.INVISIBLE);
            }else {
// not last page, set "next" text and make skip button visible
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next: if (currentItem<introAdapter.getCount()-1){
                ++currentItem; // increase the value by 1
                viewPager.setCurrentItem(currentItem); // set the layout at next position
            }else
                launchMainScreen(); // launch main screen on last page
                break;
            case R.id.btn_skip: launchMainScreen();
                break;
        }
    }

    /*public void resetHigh(){
        current = dbHelper.getAllCountries();
        currentHigh = dbHelper.getAllCountriesAction();
        currentEndless = dbHelper.getAllCountriesEndless();
        if (current != 0 ){
            dbHelper.insertHighScore(score);
        }
        if (currentHigh != 0){
            dbHelper.insertHighScoreAction(score);
        }
        if (currentEndless != 0){
            dbHelper.insertHighScoreEndless(score);
        }
    }*/
}
