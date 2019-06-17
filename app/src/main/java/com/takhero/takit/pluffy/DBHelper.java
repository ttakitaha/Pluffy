package com.takhero.takit.pluffy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME   = "gametable";
    // Contacts table name
    private static final String TABLE_Score = "highscore";
    private static final String TABLE_Score_Action = "highscoreAction";
    private static final String TABLE_Score_Endless = "highscoreEndless";
    private static final String TABLE_Sound= "sound";
    private static final String TABLE_Backup1= "backup1";
    private static final String TABLE_Backup2= "backup2";
    private static final String TABLE_Backup3= "backup3";
    private static final String TABLE_Backup4= "backup4";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
        String sql = "CREATE TABLE " + TABLE_Score + "(id INTEGER PRIMARY KEY AUTOINCREMENT,highscore INTEGER, highscoreAction INTEGER " + ")";
        Log.d("DBHelper", "SQL : " + sql);
        db.execSQL(sql);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL 1: " + ex.getMessage());}
        try{
        String sqlAction = "CREATE TABLE " + TABLE_Score_Action + "(id INTEGER PRIMARY KEY AUTOINCREMENT,highscoreAction INTEGER" + ")";
        Log.d("DBHelper", "SQL : " + sqlAction);
        db.execSQL(sqlAction);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL 2: " + ex.getMessage());}
        try{
        String sqlEndless = "CREATE TABLE " + TABLE_Score_Endless + "(id INTEGER PRIMARY KEY AUTOINCREMENT,highscoreEndless INTEGER" + ")";
        Log.d("DBHelper", "SQL : " + sqlEndless);
        db.execSQL(sqlEndless);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL 3: " + ex.getMessage());}
        try{
            String sql3 = "CREATE TABLE " + TABLE_Sound + "(id INTEGER PRIMARY KEY AUTOINCREMENT,sound INTEGER" + ")";
            Log.d("DBHelper", "SQL : " + sql3);
            db.execSQL(sql3);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL 4: " + ex.getMessage());}
        try{
            String sqlB1 = "CREATE TABLE " + TABLE_Backup1 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,backup1 INTEGER" + ")";
            Log.d("DBHelper", "SQL : " + sqlB1);
            db.execSQL(sqlB1);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL b1: " + ex.getMessage());}
        try{
            String sqlB2 = "CREATE TABLE " + TABLE_Backup2 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,backup2 INTEGER" + ")";
            Log.d("DBHelper", "SQL : " + sqlB2);
            db.execSQL(sqlB2);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL b2: " + ex.getMessage());}
        try{
            String sqlB3 = "CREATE TABLE " + TABLE_Backup3 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,backup3 INTEGER" + ")";
            Log.d("DBHelper", "SQL : " + sqlB3);
            db.execSQL(sqlB3);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL b3: " + ex.getMessage());}
        try{
            String sqlB4 = "CREATE TABLE " + TABLE_Backup4 + "(id INTEGER PRIMARY KEY AUTOINCREMENT,backup4 INTEGER" + ")";
            Log.d("DBHelper", "SQL : " + sqlB4);
            db.execSQL(sqlB4);
        }catch (Exception ex){Log.d("Err: DBHelper", "SQL b4: " + ex.getMessage());}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Score);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Score_Action);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Score_Endless);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Sound);
        onCreate(db);
    }
    public void insertHighScore(int val)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("highscore", val);
        db.insert(TABLE_Score, null, values);
        db.close();
    }

    public void insertHighScoreAction(int val)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("highscoreAction", val);
        db.insert(TABLE_Score_Action, null, values);
        db.close();
    }

    public void insertHighScoreEndless(int val)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("highscoreEndless", val);
        db.insert(TABLE_Score_Endless, null, values);
        db.close();
    }

    public void insertSound(int val)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("sound", val);
        db.insert(TABLE_Sound, null, values);
        db.close();
    }

    public void insertBackup1(int val)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("backup1", val);
        db.insert(TABLE_Backup1, null, values);
        db.close();
    }

    public void getHighScore()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();



        db.insert(TABLE_Score, null, values);
        db.close();
    }

    public int getAllCountries() {
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_Score, new String[]{"id", "highscore"}, null, null, null, null, "id DESC");
            cursor.moveToNext();
            return cursor.getInt(1);
        }catch (Exception ex){return 0;}
    }

    public int getAllCountriesAction() {
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_Score_Action, new String[]{"id", "highscoreAction"}, null, null, null, null, "id DESC");
            cursor.moveToNext();
            return cursor.getInt(1);
        }catch (Exception ex){return 0;}
    }

    public int getAllCountriesEndless() {
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_Score_Endless, new String[]{"id", "highscoreEndless"}, null, null, null, null, "id DESC");
            cursor.moveToNext();
            return cursor.getInt(1);
        }catch (Exception ex){return 0;}
    }

    public int getSound() {
        SQLiteDatabase db = this.getWritableDatabase();
        try{

            Cursor cursor = db.query(TABLE_Sound, new String[]{"id", "sound"}, null, null, null, null, "id DESC");
            cursor.moveToNext();
            return cursor.getInt(1);
        }catch (Exception ex){
            try{
                String sql3 = "CREATE TABLE " + TABLE_Sound + "(id INTEGER PRIMARY KEY AUTOINCREMENT,sound INTEGER " + ")";
                Log.d("DBHelper", "SQL : " + sql3);
                db.execSQL(sql3);

            }catch (Exception ex1){System.out.println( "SQL 4: " + ex1.getMessage());
                ContentValues values = new ContentValues();
                values.put("sound", 1);
                db.insert(TABLE_Sound, null, values);
                db.close();}
            System.out.println(ex.getMessage());
            return 0;}
    }

    public int getBackup1() {
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(TABLE_Backup1, new String[]{"id", "backup1"}, null, null, null, null, "id DESC");
            cursor.moveToNext();
            return cursor.getInt(1);
        }catch (Exception ex){return 0;}
    }
}