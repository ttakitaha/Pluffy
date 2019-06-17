package com.takhero.takit.pluffy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class AdventureActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    Button button19;
    Button button20;
    Button button21;
    Button button22;
    Button button23;
    Button button24;
    Button button25;
    Button button26;
    Button button27;
    Button button28;
    Button button29;
    Button button30;
    Button button31;
    Button button32;
    Button button33;
    Button button34;
    Button button35;
    Button button36;
    Button button37;
    Button button38;
    Button button39;
    Button button40;
    Button button41;
    Button button42;
    Button button43;
    Button button44;
    Button button45;
    Button button46;
    Button button47;
    Button button48;
    Button button49;
    Button btnRestart, btnBack, btnOptions;
    TextView textMoves;
    TextView textMovesScore;
    TextView textHigh;
    TextView textHightxt;
    TextView textScore;
    Button[][] buttonArray;
    int [][] boom;
    int [][] multiple;
    int startNumber = 4096, result = 0, zero = 0, result1 = 0, result2 = 0, result3 = 0, result4 = 0, counter = 40, score = 0, add = 0, rndCol, rndRow;
    Random random;
    String startNumberString = "", zeroString = "", resultString = "";
    DBHelper dbHelper;
    AdView mAdView;
    MediaPlayer mediaPlayer;
    int red = Color.parseColor("#FF0000");
    int buttonRed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);                      // FULLSCREEN BU İKİ SATIR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_adventure);
        dbHelper = new DBHelper(getApplicationContext());
        MobileAds.initialize(this,"ca-app-pub-2916081203297616~2694224833");
        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("5495751CE55AB5952647E88308DE8EA9").build();
        mAdView.loadAd(adRequest);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button17 = (Button) findViewById(R.id.button17);
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        button20 = (Button) findViewById(R.id.button20);
        button21 = (Button) findViewById(R.id.button21);
        button22 = (Button) findViewById(R.id.button22);
        button23 = (Button) findViewById(R.id.button23);
        button24 = (Button) findViewById(R.id.button24);
        button25 = (Button) findViewById(R.id.button25);
        button26 = (Button) findViewById(R.id.button26);
        button27 = (Button) findViewById(R.id.button27);
        button28 = (Button) findViewById(R.id.button28);
        button29 = (Button) findViewById(R.id.button29);
        button30 = (Button) findViewById(R.id.button30);
        button31 = (Button) findViewById(R.id.button31);
        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);
        button34 = (Button) findViewById(R.id.button34);
        button35 = (Button) findViewById(R.id.button35);
        button36 = (Button) findViewById(R.id.button36);
        button37 = (Button) findViewById(R.id.button37);
        button38 = (Button) findViewById(R.id.button38);
        button39 = (Button) findViewById(R.id.button39);
        button40 = (Button) findViewById(R.id.button40);
        button41 = (Button) findViewById(R.id.button41);
        button42 = (Button) findViewById(R.id.button42);
        button43 = (Button) findViewById(R.id.button43);
        button44 = (Button) findViewById(R.id.button44);
        button45 = (Button) findViewById(R.id.button45);
        button46 = (Button) findViewById(R.id.button46);
        button47 = (Button) findViewById(R.id.button47);
        button48 = (Button) findViewById(R.id.button48);
        button49 = (Button) findViewById(R.id.button49);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnOptions = (Button) findViewById(R.id.btnOptions);
        textMoves = (TextView) findViewById(R.id.textMoves);
        textMovesScore = (TextView) findViewById(R.id.textMovesScore);
        textHightxt = (TextView) findViewById(R.id.textHightxt);
        textHigh = (TextView) findViewById(R.id.textHigh);
        textScore = (TextView) findViewById(R.id.textScore);
        mediaPlayer = MediaPlayer.create(this,R.raw.blip);

        Typeface splatch = Typeface.createFromAsset(getAssets(),"fonts/Splatch.ttf");
        Typeface amperzand = Typeface.createFromAsset(getAssets(),"fonts/Amperzand.ttf");
        Typeface buttonFont = Typeface.createFromAsset(getAssets(),"fonts/Amperzand.ttf");
        Typeface buttonBottom = Typeface.createFromAsset(getAssets(),"fonts/Offroad.ttf");
        textScore.setTypeface(splatch);
        textMoves.setTypeface(amperzand);
        textMovesScore.setTypeface(amperzand);
        textHigh.setTypeface(amperzand);
        textHightxt.setTypeface(amperzand);
        btnRestart.setTypeface(buttonBottom);
        btnBack.setTypeface(buttonBottom);
        btnOptions.setTypeface(buttonBottom);
        button1.setTypeface(buttonFont);
        button2.setTypeface(buttonFont);
        button3.setTypeface(buttonFont);
        button4.setTypeface(buttonFont);
        button5.setTypeface(buttonFont);
        button6.setTypeface(buttonFont);
        button7.setTypeface(buttonFont);
        button8.setTypeface(buttonFont);
        button9.setTypeface(buttonFont);
        button10.setTypeface(buttonFont);
        button11.setTypeface(buttonFont);
        button12.setTypeface(buttonFont);
        button13.setTypeface(buttonFont);
        button14.setTypeface(buttonFont);
        button15.setTypeface(buttonFont);
        button16.setTypeface(buttonFont);
        button17.setTypeface(buttonFont);
        button18.setTypeface(buttonFont);
        button19.setTypeface(buttonFont);
        button20.setTypeface(buttonFont);
        button21.setTypeface(buttonFont);
        button22.setTypeface(buttonFont);
        button23.setTypeface(buttonFont);
        button24.setTypeface(buttonFont);
        button25.setTypeface(buttonFont);
        button26.setTypeface(buttonFont);
        button27.setTypeface(buttonFont);
        button28.setTypeface(buttonFont);
        button29.setTypeface(buttonFont);
        button30.setTypeface(buttonFont);
        button31.setTypeface(buttonFont);
        button32.setTypeface(buttonFont);
        button33.setTypeface(buttonFont);
        button34.setTypeface(buttonFont);
        button35.setTypeface(buttonFont);
        button36.setTypeface(buttonFont);
        button37.setTypeface(buttonFont);
        button38.setTypeface(buttonFont);
        button39.setTypeface(buttonFont);
        button40.setTypeface(buttonFont);
        button41.setTypeface(buttonFont);
        button42.setTypeface(buttonFont);
        button43.setTypeface(buttonFont);
        button44.setTypeface(buttonFont);
        button45.setTypeface(buttonFont);
        button46.setTypeface(buttonFont);
        button47.setTypeface(buttonFont);
        button48.setTypeface(buttonFont);
        button49.setTypeface(buttonFont);

        textScore.setText("<0>");
        textMoves.setText("moves left");
        textHightxt.setText("high score");
        btnRestart.setText("RESTART");
        btnBack.setText("BACK");
        btnOptions.setText("OPTIONS");

        buttonArray = new Button[][]{
                {button1, button2, button3, button4, button5, button6, button7},
                {button8, button9, button10, button11, button12, button13, button14},
                {button15, button16, button17, button18, button19, button20, button21},
                {button22, button23, button24, button25, button26, button27, button28},
                {button29, button30, button31, button32, button33, button34, button35},
                {button36, button37, button38, button39, button40, button41, button42},
                {button43, button44, button45, button46, button47, button48, button49}};
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button13.setText("");
        button14.setText("");
        button15.setText("");
        button16.setText("");
        button17.setText("");
        button18.setText("");
        button19.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        button23.setText("");
        button24.setText("");
        button25.setText("");
        button26.setText("");
        button27.setText("");
        button28.setText("");
        button29.setText("");
        button30.setText("");
        button31.setText("");
        button32.setText("");
        button33.setText("");
        button34.setText("");
        button35.setText("");
        button36.setText("");
        button37.setText("");
        button38.setText("");
        button39.setText("");
        button40.setText("");
        button41.setText("");
        button42.setText("");
        button43.setText("");
        button44.setText("");
        button45.setText("");
        button46.setText("");
        button47.setText("");
        button48.setText("");
        button49.setText("");

        boom = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}};

        multiple = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}};
        textMovesScore.setText(Integer.toString(counter));
        textHigh.setText(Integer.toString(dbHelper.getAllCountries()));
        startNumberString = Integer.toString(startNumber);
        zeroString = Integer.toString(zero);
        button25.setText(startNumberString);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(AdventureActivity.this, GameModesActivity.class));
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
                if (boom[0][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][1].getText().toString())));
                    buttonArray[1][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][0].getText().toString())));
                    result1*=multiple[0][0];
                    result2= result1;
                    score+=result1;
                    score+=result2;
                    boom[0][0] = 0;
                    boom[0][1] = 1;
                    boom[1][0] = 1;
                    buttonArray[0][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button2:
                if (boom[0][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][2].getText().toString())));
                    buttonArray[0][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[0][0].getText().toString())));
                    buttonArray[1][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][1].getText().toString())));
                    result1*=multiple[0][1];
                    score+=result1;
                    boom[0][1] = 0;
                    boom[0][2] = 1;
                    boom[0][0] = 1;
                    boom[1][1] = 1;
                    buttonArray[0][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button3:
                if (boom[0][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][3].getText().toString())));
                    buttonArray[0][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[0][1].getText().toString())));
                    buttonArray[1][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][2].getText().toString())));
                    result1*=multiple[0][2];
                    score+=result1;
                    boom[0][2] = 0;
                    boom[0][3] = 1;
                    boom[0][1] = 1;
                    boom[1][2] = 1;
                    buttonArray[0][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button4:
                if (boom[0][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][4].getText().toString())));
                    buttonArray[0][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[0][2].getText().toString())));
                    buttonArray[1][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][3].getText().toString())));
                    result1*=multiple[0][3];
                    score+=result1;
                    boom[0][3] = 0;
                    boom[0][4] = 1;
                    boom[0][2] = 1;
                    boom[1][3] = 1;
                    buttonArray[0][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button5:
                if (boom[0][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][5].getText().toString())));
                    buttonArray[0][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[0][3].getText().toString())));
                    buttonArray[1][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][4].getText().toString())));
                    result1*=multiple[0][4];
                    score+=result1;
                    boom[0][4] = 0;
                    boom[0][5] = 1;
                    boom[0][3] = 1;
                    boom[1][4] = 1;
                    buttonArray[0][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button6:
                if (boom[0][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][6].getText().toString())));
                    buttonArray[0][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[0][4].getText().toString())));
                    buttonArray[1][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][5].getText().toString())));
                    result1*=multiple[0][5];
                    score+=result1;
                    boom[0][5] = 0;
                    boom[0][6] = 1;
                    boom[0][4] = 1;
                    boom[1][5] = 1;
                    buttonArray[0][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button7:
                if (boom[0][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[0][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[0][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[0][5].getText().toString())));
                    buttonArray[1][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][6].getText().toString())));
                    result1*=multiple[0][6];
                    result2= result1;
                    score+=result1;
                    score+=result2;
                    boom[0][6] = 0;
                    boom[0][5] = 1;
                    boom[1][6] = 1;
                    buttonArray[0][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button8:
                if (boom[1][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][1].getText().toString())));
                    buttonArray[2][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][0].getText().toString())));
                    buttonArray[0][0].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[0][0].getText().toString())));
                    result1*=multiple[1][0];
                    score+=result1;
                    boom[1][0] = 0;
                    boom[1][1] = 1;
                    boom[2][0] = 1;
                    boom[0][0] = 1;
                    buttonArray[1][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button9:
                if (boom[1][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][2].getText().toString())));
                    buttonArray[1][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][0].getText().toString())));
                    buttonArray[2][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][1].getText().toString())));
                    buttonArray[0][1].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[0][1].getText().toString())));
                    boom[1][1] = 0;
                    boom[1][2] = 1;
                    boom[1][0] = 1;
                    boom[2][1] = 1;
                    boom[0][1] = 1;
                    buttonArray[1][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button10:
                if (boom[1][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][3].getText().toString())));
                    buttonArray[1][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][1].getText().toString())));
                    buttonArray[2][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][2].getText().toString())));
                    buttonArray[0][2].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[0][2].getText().toString())));
                    boom[1][2] = 0;
                    boom[1][3] = 1;
                    boom[1][1] = 1;
                    boom[2][2] = 1;
                    boom[0][2] = 1;
                    buttonArray[1][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button11:
                if (boom[1][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][4].getText().toString())));
                    buttonArray[1][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][2].getText().toString())));
                    buttonArray[2][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][3].getText().toString())));
                    buttonArray[0][3].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[0][3].getText().toString())));
                    boom[1][3] = 0;
                    boom[1][4] = 1;
                    boom[1][2] = 1;
                    boom[2][3] = 1;
                    boom[0][3] = 1;
                    buttonArray[1][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button12:
                if (boom[1][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][5].getText().toString())));
                    buttonArray[1][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][3].getText().toString())));
                    buttonArray[2][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][4].getText().toString())));
                    buttonArray[0][4].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[0][4].getText().toString())));
                    boom[1][4] = 0;
                    boom[1][5] = 1;
                    boom[1][3] = 1;
                    boom[2][4] = 1;
                    boom[0][4] = 1;
                    buttonArray[1][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button13:
                if (boom[1][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][6].getText().toString())));
                    buttonArray[1][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[1][4].getText().toString())));
                    buttonArray[2][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][5].getText().toString())));
                    buttonArray[0][5].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[0][5].getText().toString())));
                    boom[1][5] = 0;
                    boom[1][6] = 1;
                    boom[1][4] = 1;
                    boom[2][5] = 1;
                    boom[0][5] = 1;
                    buttonArray[1][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button14:
                if (boom[1][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[1][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[1][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[1][5].getText().toString())));
                    buttonArray[2][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][6].getText().toString())));
                    buttonArray[0][6].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[0][6].getText().toString())));
                    result1*=multiple[1][6];
                    score+=result1;
                    boom[1][6] = 0;
                    boom[1][5] = 1;
                    boom[2][6] = 1;
                    boom[0][6] = 1;
                    buttonArray[1][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button15:
                if (boom[2][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][1].getText().toString())));
                    buttonArray[3][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][0].getText().toString())));
                    buttonArray[1][0].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][0].getText().toString())));
                    result1*=multiple[2][0];
                    score+=result1;
                    boom[2][0] = 0;
                    boom[2][1] = 1;
                    boom[3][0] = 1;
                    boom[1][0] = 1;
                    buttonArray[2][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button16:
                if (boom[2][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][2].getText().toString())));
                    buttonArray[2][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][0].getText().toString())));
                    buttonArray[3][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][1].getText().toString())));
                    buttonArray[1][1].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[1][1].getText().toString())));
                    boom[2][1] = 0;
                    boom[2][2] = 1;
                    boom[2][0] = 1;
                    boom[3][1] = 1;
                    boom[1][1] = 1;
                    buttonArray[2][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button17:
                if (boom[2][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][3].getText().toString())));
                    buttonArray[2][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][1].getText().toString())));
                    buttonArray[3][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][2].getText().toString())));
                    buttonArray[1][2].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[1][2].getText().toString())));
                    boom[2][2] = 0;
                    boom[2][3] = 1;
                    boom[2][1] = 1;
                    boom[3][2] = 1;
                    boom[1][2] = 1;
                    buttonArray[2][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button18:
                if (boom[2][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][4].getText().toString())));
                    buttonArray[2][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][2].getText().toString())));
                    buttonArray[3][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][3].getText().toString())));
                    buttonArray[1][3].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[1][3].getText().toString())));
                    boom[2][3] = 0;
                    boom[2][4] = 1;
                    boom[2][2] = 1;
                    boom[3][3] = 1;
                    boom[1][3] = 1;
                    buttonArray[2][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button19:
                if (boom[2][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][5].getText().toString())));
                    buttonArray[2][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][3].getText().toString())));
                    buttonArray[3][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][4].getText().toString())));
                    buttonArray[1][4].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[1][4].getText().toString())));
                    boom[2][4] = 0;
                    boom[2][5] = 1;
                    boom[2][3] = 1;
                    boom[3][4] = 1;
                    boom[1][4] = 1;
                    buttonArray[2][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button20:
                if (boom[2][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][6].getText().toString())));
                    buttonArray[2][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[2][4].getText().toString())));
                    buttonArray[3][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][5].getText().toString())));
                    buttonArray[1][5].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[1][5].getText().toString())));
                    boom[2][5] = 0;
                    boom[2][6] = 1;
                    boom[2][4] = 1;
                    boom[3][5] = 1;
                    boom[1][5] = 1;
                    buttonArray[2][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button21:
                if (boom[2][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[2][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[2][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[2][5].getText().toString())));
                    buttonArray[3][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][6].getText().toString())));
                    buttonArray[1][6].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[1][6].getText().toString())));
                    result1*=multiple[2][6];
                    score+=result1;
                    boom[2][6] = 0;
                    boom[2][5] = 1;
                    boom[3][6] = 1;
                    boom[1][6] = 1;
                    buttonArray[2][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button22:
                if (boom[3][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][1].getText().toString())));
                    buttonArray[4][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][0].getText().toString())));
                    buttonArray[2][0].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][0].getText().toString())));
                    result1*=multiple[3][0];
                    score+=result1;
                    boom[3][0] = 0;
                    boom[3][1] = 1;
                    boom[4][0] = 1;
                    boom[2][0] = 1;
                    buttonArray[3][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button23:
                if (boom[3][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][2].getText().toString())));
                    buttonArray[3][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][0].getText().toString())));
                    buttonArray[4][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][1].getText().toString())));
                    buttonArray[2][1].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[2][1].getText().toString())));
                    boom[3][1] = 0;
                    boom[3][2] = 1;
                    boom[3][0] = 1;
                    boom[4][1] = 1;
                    boom[2][1] = 1;
                    buttonArray[3][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button24:
                if (boom[3][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][3].getText().toString())));
                    buttonArray[3][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][1].getText().toString())));
                    buttonArray[4][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][2].getText().toString())));
                    buttonArray[2][2].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[2][2].getText().toString())));
                    boom[3][2] = 0;
                    boom[3][3] = 1;
                    boom[3][1] = 1;
                    boom[4][2] = 1;
                    boom[2][2] = 1;
                    buttonArray[3][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button25:
                if (boom[3][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][4].getText().toString())));
                    buttonArray[3][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][2].getText().toString())));
                    buttonArray[4][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][3].getText().toString())));
                    buttonArray[2][3].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[2][3].getText().toString())));
                    boom[3][3] = 0;
                    boom[3][4] = 1;
                    boom[3][2] = 1;
                    boom[4][3] = 1;
                    boom[2][3] = 1;
                    buttonArray[3][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button26:
                if (boom[3][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][5].getText().toString())));
                    buttonArray[3][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][3].getText().toString())));
                    buttonArray[4][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][4].getText().toString())));
                    buttonArray[2][4].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[2][4].getText().toString())));
                    boom[3][4] = 0;
                    boom[3][5] = 1;
                    boom[3][3] = 1;
                    boom[4][4] = 1;
                    boom[2][4] = 1;
                    buttonArray[3][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button27:
                if (boom[3][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][6].getText().toString())));
                    buttonArray[3][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][4].getText().toString())));
                    buttonArray[4][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][5].getText().toString())));
                    buttonArray[2][5].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[2][5].getText().toString())));
                    boom[3][5] = 0;
                    boom[3][6] = 1;
                    boom[3][4] = 1;
                    boom[4][5] = 1;
                    boom[2][5] = 1;
                    buttonArray[3][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button28:
                if (boom[3][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[3][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[3][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[3][5].getText().toString())));
                    buttonArray[4][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][6].getText().toString())));
                    buttonArray[2][6].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[2][6].getText().toString())));
                    result1*=multiple[3][6];
                    score+=result1;
                    boom[3][6] = 0;
                    boom[3][5] = 1;
                    boom[4][6] = 1;
                    boom[2][6] = 1;
                    buttonArray[3][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button29:
                if (boom[4][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][1].getText().toString())));
                    buttonArray[5][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][0].getText().toString())));
                    buttonArray[3][0].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][0].getText().toString())));
                    result1*=multiple[4][0];
                    score+=result1;
                    boom[4][0] = 0;
                    boom[4][1] = 1;
                    boom[5][0] = 1;
                    boom[3][0] = 1;
                    buttonArray[4][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button30:
                if (boom[4][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][2].getText().toString())));
                    buttonArray[4][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][0].getText().toString())));
                    buttonArray[3][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][1].getText().toString())));
                    buttonArray[5][1].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[5][1].getText().toString())));
                    boom[4][1] = 0;
                    boom[4][2] = 1;
                    boom[4][0] = 1;
                    boom[3][1] = 1;
                    boom[5][1] = 1;
                    buttonArray[4][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button31:
                if (boom[4][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][3].getText().toString())));
                    buttonArray[4][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][1].getText().toString())));
                    buttonArray[3][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][2].getText().toString())));
                    buttonArray[5][2].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[5][2].getText().toString())));
                    boom[4][2] = 0;
                    boom[4][3] = 1;
                    boom[4][1] = 1;
                    boom[3][2] = 1;
                    boom[5][2] = 1;
                    buttonArray[4][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button32:
                if (boom[4][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][4].getText().toString())));
                    buttonArray[4][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][2].getText().toString())));
                    buttonArray[3][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][3].getText().toString())));
                    buttonArray[5][3].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[5][3].getText().toString())));
                    boom[4][3] = 0;
                    boom[4][4] = 1;
                    boom[4][2] = 1;
                    boom[3][3] = 1;
                    boom[5][3] = 1;
                    buttonArray[4][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button33:
                if (boom[4][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][5].getText().toString())));
                    buttonArray[4][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][3].getText().toString())));
                    buttonArray[3][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][4].getText().toString())));
                    buttonArray[5][4].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[5][4].getText().toString())));
                    boom[4][4] = 0;
                    boom[4][5] = 1;
                    boom[4][3] = 1;
                    boom[3][4] = 1;
                    boom[5][4] = 1;
                    buttonArray[4][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button34:
                if (boom[4][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][6].getText().toString())));
                    buttonArray[4][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][4].getText().toString())));
                    buttonArray[3][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[3][5].getText().toString())));
                    buttonArray[5][5].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[5][5].getText().toString())));
                    boom[4][5] = 0;
                    boom[4][6] = 1;
                    boom[4][4] = 1;
                    boom[3][5] = 1;
                    boom[5][5] = 1;
                    buttonArray[4][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button35:
                if (boom[4][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[4][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[4][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[4][5].getText().toString())));
                    buttonArray[3][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[3][6].getText().toString())));
                    buttonArray[5][6].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[5][6].getText().toString())));
                    result1*=multiple[4][6];
                    score+=result1;
                    boom[4][6] = 0;
                    boom[4][5] = 1;
                    boom[3][6] = 1;
                    boom[5][6] = 1;
                    buttonArray[4][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button36:
                if (boom[5][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][1].getText().toString())));
                    buttonArray[6][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[6][0].getText().toString())));
                    buttonArray[4][0].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][0].getText().toString())));
                    result1*=multiple[5][0];
                    score+=result1;
                    boom[5][0] = 0;
                    boom[5][1] = 1;
                    boom[6][0] = 1;
                    boom[4][0] = 1;
                    buttonArray[5][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button37:
                if (boom[5][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][2].getText().toString())));
                    buttonArray[5][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][0].getText().toString())));
                    buttonArray[4][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][1].getText().toString())));
                    buttonArray[6][1].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[6][1].getText().toString())));
                    boom[5][1] = 0;
                    boom[5][2] = 1;
                    boom[5][0] = 1;
                    boom[4][1] = 1;
                    boom[6][1] = 1;
                    buttonArray[5][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button38:
                if (boom[5][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][3].getText().toString())));
                    buttonArray[5][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][1].getText().toString())));
                    buttonArray[4][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][2].getText().toString())));
                    buttonArray[6][2].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[6][2].getText().toString())));
                    boom[5][2] = 0;
                    boom[5][3] = 1;
                    boom[5][1] = 1;
                    boom[4][2] = 1;
                    boom[6][2] = 1;
                    buttonArray[5][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button39:
                if (boom[5][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][4].getText().toString())));
                    buttonArray[5][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][2].getText().toString())));
                    buttonArray[4][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][3].getText().toString())));
                    buttonArray[6][3].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[6][3].getText().toString())));
                    boom[5][3] = 0;
                    boom[5][4] = 1;
                    boom[5][2] = 1;
                    boom[4][3] = 1;
                    boom[6][3] = 1;
                    buttonArray[5][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button40:
                if (boom[5][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][5].getText().toString())));
                    buttonArray[5][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][3].getText().toString())));
                    buttonArray[4][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][4].getText().toString())));
                    buttonArray[6][4].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[6][4].getText().toString())));
                    boom[5][4] = 0;
                    boom[5][5] = 1;
                    boom[5][3] = 1;
                    boom[4][4] = 1;
                    boom[6][4] = 1;
                    buttonArray[5][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button41:
                if (boom[5][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][6].getText().toString())));
                    buttonArray[5][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][4].getText().toString())));
                    buttonArray[4][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[4][5].getText().toString())));
                    buttonArray[6][5].setText(Integer.toString(result4+= Integer.parseInt(buttonArray[6][5].getText().toString())));
                    boom[5][5] = 0;
                    boom[5][6] = 1;
                    boom[5][4] = 1;
                    boom[4][5] = 1;
                    boom[6][5] = 1;
                    buttonArray[5][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button42:
                if (boom[5][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[5][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[5][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[5][5].getText().toString())));
                    buttonArray[4][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[4][6].getText().toString())));
                    buttonArray[6][6].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[6][6].getText().toString())));
                    result1*=multiple[5][6];
                    score+=result1;
                    boom[5][6] = 0;
                    boom[5][5] = 1;
                    boom[4][6] = 1;
                    boom[6][6] = 1;
                    buttonArray[5][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button43:
                if (boom[6][0] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][0].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][1].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][1].getText().toString())));
                    buttonArray[5][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][0].getText().toString())));
                    result1*=multiple[6][0];
                    result2= result1;
                    score+=result1;
                    score+=result2;
                    boom[6][0] = 0;
                    boom[6][1] = 1;
                    boom[5][0] = 1;
                    buttonArray[6][0].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button44:
                if (boom[6][1] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][1].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][2].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][2].getText().toString())));
                    buttonArray[6][0].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[6][0].getText().toString())));
                    buttonArray[5][1].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[5][1].getText().toString())));
                    result1*=multiple[6][1];
                    score+=result1;
                    boom[6][1] = 0;
                    boom[6][2] = 1;
                    boom[6][0] = 1;
                    boom[5][1] = 1;
                    buttonArray[6][1].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button45:
                if (boom[6][2] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][2].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][3].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][3].getText().toString())));
                    buttonArray[6][1].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[6][1].getText().toString())));
                    buttonArray[5][2].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[5][2].getText().toString())));
                    result1*=multiple[6][2];
                    score+=result1;
                    boom[6][2] = 0;
                    boom[6][3] = 1;
                    boom[6][1] = 1;
                    boom[5][2] = 1;
                    buttonArray[6][2].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button46:
                if (boom[6][3] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][3].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][4].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][4].getText().toString())));
                    buttonArray[6][2].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[6][2].getText().toString())));
                    buttonArray[5][3].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[5][3].getText().toString())));
                    result1*=multiple[6][3];
                    score+=result1;
                    boom[6][3] = 0;
                    boom[6][4] = 1;
                    boom[6][2] = 1;
                    boom[5][3] = 1;
                    buttonArray[6][3].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button47:
                if (boom[6][4] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][4].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][5].getText().toString())));
                    buttonArray[6][3].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[6][3].getText().toString())));
                    buttonArray[5][4].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[5][4].getText().toString())));
                    result1*=multiple[6][4];
                    score+=result1;
                    boom[6][4] = 0;
                    boom[6][5] = 1;
                    boom[6][3] = 1;
                    boom[5][4] = 1;
                    buttonArray[6][4].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button48:
                if (boom[6][5] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][5].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][6].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][6].getText().toString())));
                    buttonArray[6][4].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[6][4].getText().toString())));
                    buttonArray[5][5].setText(Integer.toString(result3+= Integer.parseInt(buttonArray[5][5].getText().toString())));
                    result1*=multiple[6][5];
                    score+=result1;
                    boom[6][5] = 0;
                    boom[6][6] = 1;
                    boom[6][4] = 1;
                    boom[5][5] = 1;
                    buttonArray[6][5].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
            case R.id.button49:
                if (boom[6][6] == 1){
                    mediaPlayer.start();
                    result1 = Integer.valueOf(buttonArray[6][6].getText().toString())/4;
                    result2= result1;
                    result3= result1;
                    result4= result1;
                    resultString = Integer.toString(result);
                    buttonArray[6][5].setText(Integer.toString(result1+= Integer.parseInt(buttonArray[6][5].getText().toString())));
                    buttonArray[5][6].setText(Integer.toString(result2+= Integer.parseInt(buttonArray[5][6].getText().toString())));
                    result1*=multiple[6][6];
                    result2= result1;
                    score+=result1;
                    score+=result2;
                    boom[6][6] = 0;
                    boom[6][5] = 1;
                    boom[5][6] = 1;
                    buttonArray[6][6].setText("");
                    counter--;
                    if (counter != 0 ) getRnd();
                }
                break;
        }
        for (int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                if (buttonArray[i][j].getText().equals("0")){
                    buttonArray[i][j].setText("");
                }
            }
        }
        result1=0;
        result2=0;
        result3=0;
        result4=0;
        textMovesScore.setText(Integer.toString(counter));

        textScore.setText("<"+Integer.toString(score)+">");

        if (counter == 0){
            for (int i=0;i<7;i++){
                for (int j=0;j<7;j++){
                    if (buttonArray[i][j].getText().equals("")){
                        buttonArray[i][j].setText("0");
                    }
                }
            }
            Toast.makeText(this, "Your Score: " + score,
                    Toast.LENGTH_LONG).show();

            for (int i=0;i<7;i++){
                for (int j=0;j<7;j++){
                    if (buttonArray[i][j].getText().equals("0")){
                        buttonArray[i][j].setText("");
                    }
                    buttonArray[i][j].setEnabled(false);
                }
            }
            int a = dbHelper.getAllCountries();
            if(a<score)
            {
                dbHelper.insertHighScore(score);
                Toast.makeText(this, "High Score: " + score +"!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void NewGame(View view){
        recreate();
    }

    public void goBack(View view){
        Intent intent = new Intent(this,GameModesActivity.class);
        startActivity(intent);
    }

    public void getRnd(){
        if (counter%5 == 0){
            random = new Random();
            rndCol = random.nextInt(7);
            if (rndCol == 0 || rndCol == 6){
                rndRow = random.nextInt(7);
                if (multiple[rndCol][rndRow]==1) multiple[rndCol][rndRow]*=2;
            }
            else {
                rndRow = random.nextInt(2);
                if (rndRow == 0){
                    if (multiple[rndCol][rndRow]==1) multiple[rndCol][0]*=2;
                }
                else {
                    if (multiple[rndCol][rndRow]==1) multiple[rndCol][1]*=2;
                }
            }
            switch (rndCol){
                case 0:
                    if (rndRow==0)button1.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button2.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==2)button3.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==3)button4.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==4)button5.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==5)button6.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==6)button7.setBackgroundResource(R.drawable.buttonshapered); break;

                case 1:
                    if (rndRow==0)button8.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button14.setBackgroundResource(R.drawable.buttonshapered); break;

                case 2:
                    if (rndRow==0)button15.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button21.setBackgroundResource(R.drawable.buttonshapered); break;

                case 3:
                    if (rndRow==0)button22.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button28.setBackgroundResource(R.drawable.buttonshapered); break;

                case 4:
                    if (rndRow==0)button29.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button35.setBackgroundResource(R.drawable.buttonshapered); break;

                case 5:
                    if (rndRow==0)button36.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button42.setBackgroundResource(R.drawable.buttonshapered); break;

                case 6:
                    if (rndRow==0)button43.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==1)button44.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==2)button45.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==3)button46.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==4)button47.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==5)button48.setBackgroundResource(R.drawable.buttonshapered);
                    else if (rndRow==6)button49.setBackgroundResource(R.drawable.buttonshapered); break;
            }
            System.out.println(rndCol + " | " + rndRow);

            for (int i = 0; i<7; i++){
                for (int j =0; j<7; j++){
                    System.out.println(i +"|"+j+" -- "+ multiple[i][j] + " ");
                }
                System.out.println("\n");
            }
        }

    }
}
