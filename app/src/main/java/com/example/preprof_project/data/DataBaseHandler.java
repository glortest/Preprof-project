package com.example.preprof_project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.preprof_project.Point;
import com.example.preprof_project.User;
import com.example.preprof_project.utils.Util;


import java.util.ArrayList;

public class DataBaseHandler extends SQLiteOpenHelper {

    public DataBaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //Создание БД
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + Util.TABLE_NAME + " ("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_OXID + " INTEGER, "
                + Util.KEY_MASS + " INTEGER, "
                + Util.KEY_SH + " INTEGER, "
                + Util.KEY_T + " INTEGER, "
                + Util.KEY_POWER + " INTEGER, "
                + Util.KEY_TOPLIVO + " INTEGER" + " );";

        sqLiteDatabase.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }

    //Удаление всех данных
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, null, null);
        db.close();
    }

    //Возвращает продукт нам
    public User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_OXID, Util.KEY_MASS, Util.KEY_SH, Util.KEY_T, Util.KEY_POWER, Util.KEY_TOPLIVO},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        /*
        if (cursor != null){
            cursor.moveToFirst();
        }
        */
        while (cursor != null && cursor.moveToNext()) {
            User pr = new User(Integer.parseInt(cursor.getString(0)),
                    cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6));
            cursor.close();
            return pr;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }


    //Обновляет информацию о продукте
    public int updateProd(User user, long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_OXID, user.getOxygen());
        contentValues.put(Util.KEY_TOPLIVO, user.getNuclearOil());
        contentValues.put(Util.KEY_MASS, user.getM());
        contentValues.put(Util.KEY_SH, user.getSh());
        contentValues.put(Util.KEY_POWER, user.getW());
        contentValues.put(Util.KEY_T, user.getT());
        return db.update(Util.TABLE_NAME, contentValues, Util.KEY_ID + "=?", new String[]{String.valueOf(id)});
    }



}
