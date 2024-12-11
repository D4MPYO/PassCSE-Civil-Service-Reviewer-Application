package com.example.passcsemidtermproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "exam_logs.db";
    private static final String TABLE_NAME = "logs_subprofessional";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "CORRECT_ANSWERS";
    private static final String COL_3 = "WRONG_ANSWERS";
    private static final String COL_4 = "TIME_SPENT";
    private static final String COL_5 = "DATE_TIME";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, CORRECT_ANSWERS INTEGER, WRONG_ANSWERS INTEGER, TIME_SPENT TEXT, DATE_TIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertLog(int correctAnswers, int wrongAnswers, String timeSpent, String dateTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, correctAnswers);
        contentValues.put(COL_3, wrongAnswers);
        contentValues.put(COL_4, timeSpent);
        contentValues.put(COL_5, dateTime);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1; // Return true if the insertion was successful
    }

    public Cursor getAllLogs() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}