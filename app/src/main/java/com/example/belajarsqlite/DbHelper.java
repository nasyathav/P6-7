package com.example.belajarsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "mhsdb";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_NOHP = "nohp";
    public static final String TABLE_NAME = "mhstb";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stmt = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAMA + " TEXT, " + COLUMN_NIM + " TEXT, " + COLUMN_NOHP + " TEXT)";
        sqLiteDatabase.execSQL(stmt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean simpan(Mhs mm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAMA, mm.getNama());
        cv.put(COLUMN_NIM, mm.getNim());
        cv.put(COLUMN_NOHP, mm.getNoHp());

        long stts = db.insert(TABLE_NAME, null, cv);

        if (stts == -1)
            return false;
        else
            return true;
    }

    public ArrayList<Mhs> List(){
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Mhs> mhsList = new ArrayList<>();

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String nim = cursor.getString(2);
                String noHp = cursor.getString(3);

                Mhs mm = new Mhs(id, nama, nim, noHp);
                mhsList.add(mm);
            }
        }
        return mhsList;
    }
}
