package com.mbds.tpt_android.Util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HistoryManager {
    private static DatabaseHelper dbHelper;

    public HistoryManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public List<HistoryItem> getAllHistory() {
        return dbHelper.getAllHistory();
    }

    public static void addToHistory(String objectId, String objectName, String proprietaire) {
        dbHelper.addToHistory(objectId, objectName, proprietaire);
    }
}
