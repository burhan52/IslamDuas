package com.example.islamduas.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.islamduas.model.Dua;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Duas.db";
    public static final String DBLOCATION = "/data/data/com.example.islamduas/database/database";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context,DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()){
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath,null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase()
    {
        if (mDatabase!=null){
            mDatabase.close();
        }
    }
    public List<Dua> getListDua () {
        Dua dua = null;
        List<Dua> duaList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM DUA", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            dua = new Dua(cursor.getInt(0), cursor.getString(1), cursor.getString(2),   cursor.getString(3), cursor.getString(4), cursor.getString(5));
            duaList.add(dua);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return duaList;
    }
}
