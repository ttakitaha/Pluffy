package com.takhero.takit.pluffy;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    DBHelper dbHelper;
    int score = 0, current = 0, currentHigh = 0, currentEndless = 0;
    Button btnResetHigh, btnHowToPlay, btnSound, btnBack;
    Typeface buttonBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        dbHelper = new DBHelper(getApplicationContext());
        transparentStatusBar();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnBack = findViewById(R.id.btnBack);
        btnResetHigh = findViewById(R.id.btnResetHigh);
        btnHowToPlay = findViewById(R.id.btnHowToPlay);
        btnSound = findViewById(R.id.btnSound);
        buttonBottom = Typeface.createFromAsset(getAssets(),"fonts/Offroad.ttf");

        btnBack.setTypeface(buttonBottom);
        btnSound.setTypeface(buttonBottom);
        btnResetHigh.setTypeface(buttonBottom);
        btnHowToPlay.setTypeface(buttonBottom);

        btnBack.setText(R.string.backString);
        btnResetHigh.setText(R.string.resetHighString);
        btnHowToPlay.setText(R.string.howToPlayString);

        if (dbHelper.getSound()==1){
            btnSound.setText(R.string.muteString);
        }
        if (dbHelper.getSound()==0){
            btnSound.setText(R.string.unmuteString);
        }
        /*else{
            btnSound.setText(R.string.unmuteString);
        }*/
        /*if (dbHelper.getBackup1()==1){
            btnSound.setText(R.string.unmuteString);
        }
        else {
            btnSound.setText(R.string.muteString);
        }*/
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(OptionsActivity.this, MainActivity.class));
        finish();
    }

    public void resetHigh(View view){
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
        Toast.makeText(this, R.string.successString, Toast.LENGTH_LONG).show();
    }

    public void goMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void howToPlay(View view){
        Intent intent = new Intent(this, HowToPlayActivity.class);
        startActivity(intent);
    }

    public void setSound(View view){
        System.out.println(dbHelper.getSound());
        if (dbHelper.getSound()==1){
            dbHelper.insertSound(0);
            btnSound.setText(R.string.unmuteString);
        }
        else if(dbHelper.getSound()==0){
            dbHelper.insertSound(1);
            btnSound.setText(R.string.muteString);
        }
        recreate();
    }

    public static void reviewOnGooglePlay(Activity activity) {
        final String appPackageName = activity.getPackageName();
        try {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
        }
        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
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

}
