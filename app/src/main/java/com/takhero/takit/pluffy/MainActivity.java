package com.takhero.takit.pluffy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNewGame, btnOptions, btnCredits, btnQuit;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transparentStatusBar();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnNewGame = findViewById(R.id.btnNewGame);
        btnOptions = findViewById(R.id.btnOptions);
        btnCredits = findViewById(R.id.btnCredits);
        btnQuit = findViewById(R.id.btnQuit);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(),"fonts/Offroad.ttf");
        btnNewGame.setTypeface(buttonFont);
        btnOptions.setTypeface(buttonFont);
        btnCredits.setTypeface(buttonFont);
        btnQuit.setTypeface(buttonFont);

        btnNewGame.setText(R.string.playString);
        btnOptions.setText(R.string.optionsString);
        btnCredits.setText(R.string.creditsString);
        btnQuit.setText(R.string.quitString);

        dbHelper = new DBHelper(getApplicationContext());
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        quit();
    }

    public void goBasic(View view){
        Intent intent = new Intent(this, GameModesActivity.class);
        startActivity(intent);
    }

    public void goOptions(View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    public void goCredits(View view){
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void quit(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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
