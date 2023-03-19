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

public class DatabaseHandler1 extends SQLiteOpenHelper {

    public DatabaseHandler1(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //Создание БД
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + Util.TABLE_NAME1 + " ("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_DISTANCE + " INTEGER, "
                + Util.KEY_SH + " INTEGER" + " );";

        sqLiteDatabase.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME1 + ";");
        onCreate(sqLiteDatabase);
    }

    //Удаление всех данных
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME1, null, null);
        db.close();
    }

    //Возвращает продукт нам
    public Point getPoint(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME1, new String[]{Util.KEY_ID, Util.KEY_DISTANCE, Util.KEY_SH},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        /*
        if (cursor != null){
            cursor.moveToFirst();
        }
        */
        while (cursor != null && cursor.moveToNext()) {
            Point pr = new Point(Integer.parseInt(cursor.getString(0)),
                    cursor.getInt(1), cursor.getInt(2));
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
        return db.update(Util.TABLE_NAME1, contentValues, Util.KEY_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void addProd(Point point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Util.KEY_DISTANCE, point.getS());
        contentValues.put(Util.KEY_SH, point.getC());

        db.insert(Util.TABLE_NAME1, null, contentValues);
        db.close();
    }

}
