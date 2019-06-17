package com.takhero.takit.pluffy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class EndlessActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7,
            button8, button9, button10, button11, button12, button13, button14,
            button15, button16, button17, button18, button19, button20, button21,
            button22, button23, button24, button25, button26, button27, button28,
            button29, button30, button31, button32, button33, button34, button35,
            button36, button37, button38, button39, button40, button41, button42,
            button43, button44, button45, button46, button47, button48, button49,
            btnRestart, btnBack, btnOptions;
    TextView textMoves, textMovesScore, textHigh, textHighTxt, textScore, textScoreTxt;
    Button[][] buttonArray;
    int [][] boom;
    int startNumber = 128, zero = 0, result1 = 0, result2 = 0, result3 = 0,
            result4 = 0, counter = 0, add = 0, total = 0, sound;
    String startNumberString = "", zeroString = "";
    DBHelper dbHelper;
    AdView mAdView;
    MediaPlayer mediaPlayer;
    Typeface splatch, amperzand, buttonFont, buttonBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);                      // FULLSCREEN BU İKİ SATIR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_endless);
        transparentStatusBar();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dbHelper = new DBHelper(getApplicationContext());
        MobileAds.initialize(this,"ca-app-pub-2916081203297616~2694224833");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        button26 = findViewById(R.id.button26);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29 = findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        button34 = findViewById(R.id.button34);
        button35 = findViewById(R.id.button35);
        button36 = findViewById(R.id.button36);
        button37 = findViewById(R.id.button37);
        button38 = findViewById(R.id.button38);
        button39 = findViewById(R.id.button39);
        button40 = findViewById(R.id.button40);
        button41 = findViewById(R.id.button41);
        button42 = findViewById(R.id.button42);
        button43 = findViewById(R.id.button43);
        button44 = findViewById(R.id.button44);
        button45 = findViewById(R.id.button45);
        button46 = findViewById(R.id.button46);
        button47 = findViewById(R.id.button47);
        button48 = findViewById(R.id.button48);
        button49 = findViewById(R.id.button49);
        btnBack = findViewById(R.id.btnBack);
        textHigh = findViewById(R.id.textHigh);
        textScore = findViewById(R.id.textScore);
        textScoreTxt = findViewById(R.id.textScoreTxt);
        textMoves = findViewById(R.id.textMoves);
        btnRestart = findViewById(R.id.btnRestart);
        btnOptions = findViewById(R.id.btnOptions);
        textHighTxt = findViewById(R.id.textHighTxt);
        textMovesScore = findViewById(R.id.textMovesScore);
        mediaPlayer = MediaPlayer.create(this,R.raw.blip);
        splatch = Typeface.createFromAsset(getAssets(),"fonts/Splatch.ttf");
        amperzand = Typeface.createFromAsset(getAssets(),"fonts/Neon.ttf");
        buttonFont = Typeface.createFromAsset(getAssets(),"fonts/Neon.ttf");
        buttonBottom = Typeface.createFromAsset(getAssets(),"fonts/Offroad.ttf");

        textScore.setTypeface(splatch);
        textHigh.setTypeface(amperzand);
        textMoves.setTypeface(amperzand);
        btnBack.setTypeface(buttonBottom);
        textHighTxt.setTypeface(amperzand);
        textScoreTxt.setTypeface(amperzand);
        btnOptions.setTypeface(buttonBottom);
        btnRestart.setTypeface(buttonBottom);
        textMovesScore.setTypeface(amperzand);

        textScore.setText("<0>");
        btnBack.setText(R.string.backString);
        btnOptions.setText(R.string.menuString);
        btnRestart.setText(R.string.restartString);
        textMoves.setText(R.string.totalScoreLeft);
        textHighTxt.setText(R.string.highScoreString);

        buttonArray = new Button[][]{
                {button1, button2, button3, button4, button5, button6, button7},
                {button8, button9, button10, button11, button12, button13, button14},
                {button15, button16, button17, button18, button19, button20, button21},
                {button22, button23, button24, button25, button26, button27, button28},
                {button29, button30, button31, button32, button33, button34, button35},
                {button36, button37, button38, button39, button40, button41, button42},
                {button43, button44, button45, button46, button47, button48, button49}};

        for (int i=0; i<7; i++){
            for (int j=0; j<7; j++){
                buttonArray[i][j].setText("");
                buttonArray[i][j].setTypeface(buttonFont);
            }
        }

        dbHelper = new DBHelper(getApplicationContext());
        sound = dbHelper.getSound();

        boom = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}};

        textMovesScore.setText(Integer.toString(startNumber));
        textHigh.setText(Integer.toString(dbHelper.getAllCountriesEndless()));
        startNumberString = Integer.toString(startNumber);
        zeroString = Integer.toString(zero);
        button25.setText(startNumberString);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(EndlessActivity.this, GameModesActivity.class));
        finish();
    }

    public void Boom(View view){
        int id = view.getId();
        for (int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                if (buttonArray[i][j].getText().equals("")){
                    buttonArray[i][j].setText("0");
                }
            }
        }

        switch (id){
            case R.id.button1:
                if (boom[0][0] == 1 && !button1.getText().equals("0")){
                    boomDouble(0,0);
                }
                break;
            case R.id.button2:
                if (boom[0][1] == 1 && !button2.getText().equals("0")){
                    boomSingle(0,1);
                }
                break;
            case R.id.button3:
                if (boom[0][2] == 1 && !button3.getText().equals("0")){
                    boomSingle(0,2);
                }
                break;
            case R.id.button4:
                if (boom[0][3] == 1 && !button4.getText().equals("0")){
                    boomSingle(0,3);
                }
                break;
            case R.id.button5:
                if (boom[0][4] == 1 && !button5.getText().equals("0")){
                    boomSingle(0,4);
                }
                break;
            case R.id.button6:
                if (boom[0][5] == 1 && !button6.getText().equals("0")){
                    boomSingle(0,5);
                }
                break;
            case R.id.button7:
                if (boom[0][6] == 1 && !button7.getText().equals("0")){
                    boomDouble(0,6);
                }
                break;
            case R.id.button8:
                if (boom[1][0] == 1 && !button8.getText().equals("0")){
                    boomSingle(1,0);
                }
                break;
            case R.id.button9:
                if (boom[1][1] == 1 && !button9.getText().equals("0")){
                    boomStd(1,1);
                }
                break;
            case R.id.button10:
                if (boom[1][2] == 1 && !button10.getText().equals("0")){
                    boomStd(1,2);
                }
                break;
            case R.id.button11:
                if (boom[1][3] == 1 && !button11.getText().equals("0")){
                    boomStd(1,3);
                }
                break;
            case R.id.button12:
                if (boom[1][4] == 1 && !button12.getText().equals("0")){
                    boomStd(1,4);
                }
                break;
            case R.id.button13:
                if (boom[1][5] == 1 && !button13.getText().equals("0")){
                    boomStd(1,5);
                }
                break;
            case R.id.button14:
                if (boom[1][6] == 1 && !button14.getText().equals("0")){
                    boomSingle(1,6);
                }
                break;
            case R.id.button15:
                if (boom[2][0] == 1 && !button15.getText().equals("0")){
                    boomSingle(2,0);
                }
                break;
            case R.id.button16:
                if (boom[2][1] == 1 && !button16.getText().equals("0")){
                    boomStd(2,1);
                }
                break;
            case R.id.button17:
                if (boom[2][2] == 1 && !button17.getText().equals("0")){
                    boomStd(2,2);
                }
                break;
            case R.id.button18:
                if (boom[2][3] == 1 && !button18.getText().equals("0")){
                    boomStd(2,3);
                }
                break;
            case R.id.button19:
                if (boom[2][4] == 1 && !button19.getText().equals("0")){
                    boomStd(2,4);
                }
                break;
            case R.id.button20:
                if (boom[2][5] == 1 && !button20.getText().equals("0")){
                    boomStd(2,5);
                }
                break;
            case R.id.button21:
                if (boom[2][6] == 1 && !button21.getText().equals("0")){
                    boomSingle(2,6);
                }
                break;
            case R.id.button22:
                if (boom[3][0] == 1 && !button22.getText().equals("0")){
                    boomSingle(3,0);
                }
                break;
            case R.id.button23:
                if (boom[3][1] == 1 && !button23.getText().equals("0")){
                    boomStd(3,1);
                }
                break;
            case R.id.button24:
                if (boom[3][2] == 1 && !button24.getText().equals("0")){
                    boomStd(3,2);
                }
                break;
            case R.id.button25:
                if (boom[3][3] == 1 && !button25.getText().equals("0")){
                    boomStd(3,3);
                }
                break;
            case R.id.button26:
                if (boom[3][4] == 1 && !button26.getText().equals("0")){
                    boomStd(3,4);
                }
                break;
            case R.id.button27:
                if (boom[3][5] == 1 && !button27.getText().equals("0")){
                    boomStd(3,5);
                }
                break;
            case R.id.button28:
                if (boom[3][6] == 1 && !button28.getText().equals("0")){
                    boomSingle(3,6);
                }
                break;
            case R.id.button29:
                if (boom[4][0] == 1 && !button29.getText().equals("0")){
                    boomSingle(4,0);
                }
                break;
            case R.id.button30:
                if (boom[4][1] == 1 && !button30.getText().equals("0")){
                    boomStd(4,1);
                }
                break;
            case R.id.button31:
                if (boom[4][2] == 1 && !button31.getText().equals("0")){
                    boomStd(4,2);
                }
                break;
            case R.id.button32:
                if (boom[4][3] == 1 && !button32.getText().equals("0")){
                    boomStd(4,3);
                }
                break;
            case R.id.button33:
                if (boom[4][4] == 1 && !button33.getText().equals("0")){
                    boomStd(4,4);
                }
                break;
            case R.id.button34:
                if (boom[4][5] == 1 && !button34.getText().equals("0")){
                    boomStd(4,5);
                }
                break;
            case R.id.button35:
                if (boom[4][6] == 1 && !button35.getText().equals("0")){
                    boomSingle(4,6);
                }
                break;
            case R.id.button36:
                if (boom[5][0] == 1 && !button36.getText().equals("0")){
                    boomSingle(5,0);
                }
                break;
            case R.id.button37:
                if (boom[5][1] == 1 && !button37.getText().equals("0")){
                    boomStd(5,1);
                }
                break;
            case R.id.button38:
                if (boom[5][2] == 1 && !button38.getText().equals("0")){
                    boomStd(5,2);
                }
                break;
            case R.id.button39:
                if (boom[5][3] == 1 && !button39.getText().equals("0")){
                    boomStd(5,3);
                }
                break;
            case R.id.button40:
                if (boom[5][4] == 1 && !button40.getText().equals("0")){
                    boomStd(5,4);
                }
                break;
            case R.id.button41:
                if (boom[5][5] == 1 && !button41.getText().equals("0")){
                    boomStd(5,5);
                }
                break;
            case R.id.button42:
                if (boom[5][6] == 1 && !button42.getText().equals("0")){
                    boomSingle(5,6);
                }
                break;
            case R.id.button43:
                if (boom[6][0] == 1 && !button43.getText().equals("0")){
                    boomDouble(6,0);
                }
                break;
            case R.id.button44:
                if (boom[6][1] == 1 && !button44.getText().equals("0")){
                    boomSingle(6,1);
                }
                break;
            case R.id.button45:
                if (boom[6][2] == 1 && !button45.getText().equals("0")){
                    boomSingle(6,2);
                }
                break;
            case R.id.button46:
                if (boom[6][3] == 1 && !button46.getText().equals("0")){
                    boomSingle(6,3);
                }
                break;
            case R.id.button47:
                if (boom[6][4] == 1 && !button47.getText().equals("0")){
                    boomSingle(6,4);
                }
                break;
            case R.id.button48:
                if (boom[6][5] == 1 && !button48.getText().equals("0")){
                    boomSingle(6,5);
                }
                break;
            case R.id.button49:
                if (boom[6][6] == 1 && !button49.getText().equals("0")){
                    boomDouble(6,6);
                }
                break;
        }
        total=0;
        for (int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                if (buttonArray[i][j].getText().equals("0")){
                    buttonArray[i][j].setText("");
                }
                if (!buttonArray[i][j].getText().equals("")){
                    total+= Integer.parseInt(buttonArray[i][j].getText().toString());
                }
            }
        }

        result1=0;
        result2=0;
        result3=0;
        result4=0;
        textMovesScore.setText(Integer.toString(total));
        textScore.setText("<" + Integer.toString(counter) + ">");


        if (total == 0){
            for (int i=0;i<7;i++){
                for (int j=0;j<7;j++){
                    if (buttonArray[i][j].getText().equals("")){
                        buttonArray[i][j].setText("0");
                    }
                }
            }
            textScoreTxt.setText(R.string.yourScoreString);

            for (int i=0;i<7;i++){
                for (int j=0;j<7;j++){
                    if (buttonArray[i][j].getText().equals("0")){
                        buttonArray[i][j].setText("");
                    }
                    buttonArray[i][j].setEnabled(false);
                }
            }
            int a = dbHelper.getAllCountriesEndless();
            if(a>counter || a == 0)
            {
                dbHelper.insertHighScoreEndless(counter);
                textScoreTxt.setText(R.string.highScorePanelString);
                textHigh.setText(Integer.toString(counter));
            }
        }
    }

    public void boomStd(int col, int row){
        if (sound==1)mediaPlayer.start();
        result1 = Integer.valueOf(buttonArray[col][row].getText().toString())/4;
        result2= result1;
        result3= result1;
        result4= result1;
        buttonArray[col][row+1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[col][row+1].getText().toString())));
        buttonArray[col][row-1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[col][row-1].getText().toString())));
        buttonArray[col+1][row].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[col+1][row].getText().toString())));
        buttonArray[col-1][row].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[col-1][row].getText().toString())));
        boom[col][row] = 0;
        boom[col][row+1] = 1;
        boom[col][row-1] = 1;
        boom[col+1][row] = 1;
        boom[col-1][row] = 1;
        buttonArray[col][row].setText("");
        counter++;
    }

    public void boomSingle(int col, int row){
        if (sound==1)mediaPlayer.start();
        result1 = Integer.valueOf(buttonArray[col][row].getText().toString())/4;
        result2= result1;
        result3= result1;
        result4= result1;
        if (row+1<7) buttonArray[col][row+1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[col][row+1].getText().toString())));
        if (row-1>=0) buttonArray[col][row-1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[col][row-1].getText().toString())));
        if (col+1<7) buttonArray[col+1][row].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[col+1][row].getText().toString())));
        if (col-1>=0) buttonArray[col-1][row].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[col-1][row].getText().toString())));
        boom[col][row] = 0;
        if (row+1<7) boom[col][row+1] = 1;
        if (row-1>=0) boom[col][row-1] = 1;
        if (col+1<7) boom[col+1][row] = 1;
        if (col-1>=0) boom[col-1][row] = 1;
        buttonArray[col][row].setText("");
        counter++;
    }

    public void boomDouble(int col, int row){
        if (sound==1)mediaPlayer.start();
        result1 = Integer.valueOf(buttonArray[col][row].getText().toString())/4;
        result2= result1;
        result3= result1;
        result4= result1;
        if (row+1<7) buttonArray[col][row+1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[col][row+1].getText().toString())));
        if (row-1>=0) buttonArray[col][row-1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[col][row-1].getText().toString())));
        if (col+1<7) buttonArray[col+1][row].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[col+1][row].getText().toString())));
        if (col-1>=0) buttonArray[col-1][row].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[col-1][row].getText().toString())));
        boom[col][row] = 0;
        if (row+1<7) boom[col][row+1] = 1;
        if (row-1>=0) boom[col][row-1] = 1;
        if (col+1<7) boom[col+1][row] = 1;
        if (col-1>=0) boom[col-1][row] = 1;
        buttonArray[col][row].setText("");
        counter++;
    }

    public void NewGame(View view){
        recreate();
    }

    public void goBack(View view){
        Intent intent = new Intent(this,GameModesActivity.class);
        startActivity(intent);
    }

    public void goMenu(View view){
        Intent intent = new Intent(this,MainActivity.class);
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
