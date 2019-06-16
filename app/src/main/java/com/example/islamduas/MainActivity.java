package com.example.islamduas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.islamduas.adapter.ListDuaAdapter;
import com.example.islamduas.database.DatabaseHelper;
import com.example.islamduas.model.Dua;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvDua;
    private ListDuaAdapter adapter;
    private List<Dua> mDuaList;
    private DatabaseHelper mDBHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDua = (ListView)findViewById(R.id.listviewduas);
        mDBHelper = new DatabaseHelper(this);

        //check exists database
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if (false == database.exists()){
            mDBHelper.getReadableDatabase();
            //copydb
            if (copyDatabase(this)){
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy database error", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        mDuaList = mDBHelper.getListDua();
        adapter = new ListDuaAdapter(this, mDuaList);
        lvDua.setAdapter(adapter);
    }
    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff))> 0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

    }
}
