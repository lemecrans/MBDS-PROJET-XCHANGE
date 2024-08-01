package com.mbds.tpt_android.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "history1.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_HISTORY = "history";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TIMESTAMP = "timestamp";
    private static final String COLUMN_OBJECT_ID = "object_id";
    private static final String COLUMN_OBJECT_NAME = "object_name";
    private static final String COLUMN_PROPRIETAIRE = "proprietaire";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_HISTORY + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TIMESTAMP + " TEXT, " +
                    COLUMN_OBJECT_ID + " TEXT, " +
                    COLUMN_OBJECT_NAME + " TEXT, " +
                    COLUMN_PROPRIETAIRE + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
        onCreate(db);
    }

    public void addToHistory(String objectId, String objectName, String proprietaire) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        values.put(COLUMN_TIMESTAMP, timestamp);
        values.put(COLUMN_OBJECT_ID, objectId);
        values.put(COLUMN_OBJECT_NAME, objectName);
        values.put(COLUMN_PROPRIETAIRE, proprietaire);

        db.insert(TABLE_HISTORY, null, values);
        System.out.println("INSERT OK");
        db.close();
    }

    public List<HistoryItem> getAllHistory() {
        List<HistoryItem> historyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_HISTORY, // The table to query
                new String[]{COLUMN_TIMESTAMP, COLUMN_OBJECT_ID, COLUMN_OBJECT_NAME,COLUMN_PROPRIETAIRE},
                null,
                null,
                null,
                null,
                COLUMN_TIMESTAMP + " DESC"
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String timestamp = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIMESTAMP));
                String objectId = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OBJECT_ID));
                String objectName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OBJECT_NAME));
                String proprietaire = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PROPRIETAIRE));

                HistoryItem historyItem = new HistoryItem(timestamp, objectId, objectName,proprietaire);
                historyList.add(historyItem);
            }
            cursor.close();
        }
        db.close();
        return historyList;
    }
}
