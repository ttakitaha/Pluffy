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

public class GameModesActivity extends AppCompatActivity {

    Button btnClassic, btnBack, btnAction, btnEndless;
    Typeface buttonFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_modes);
        transparentStatusBar();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnBack = findViewById(R.id.btnBack);
        btnAction = findViewById(R.id.btnAction);
        btnClassic = findViewById(R.id.btnClassic);
        btnEndless = findViewById(R.id.btnEndless);
        buttonFont = Typeface.createFromAsset(getAssets(),"fonts/Offroad.ttf");

        btnBack.setTypeface(buttonFont);
        btnAction.setTypeface(buttonFont);
        btnClassic.setTypeface(buttonFont);
        btnEndless.setTypeface(buttonFont);

        btnBack.setText(R.string.backString);
        btnAction.setText(R.string.actionString);
        btnClassic.setText(R.string.classicString);
        btnEndless.setText(R.string.endlessString);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(GameModesActivity.this, MainActivity.class));
        finish();
    }

    public void goBasic(View view){
        Intent intent = new Intent(this, BasicActivity.class);
        startActivity(intent);
    }

    public void goAdventure(View view){
        Intent intent = new Intent(this, ActionActivity.class);
        startActivity(intent);
    }

    public void goEndless(View view){
        Intent intent = new Intent(this, EndlessActivity.class);
        startActivity(intent);
    }

    public void goMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
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
