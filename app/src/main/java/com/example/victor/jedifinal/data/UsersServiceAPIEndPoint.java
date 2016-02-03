package com.example.victor.jedifinal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by inlab on 01/02/2016.
 */
public class UsersServiceAPIEndPoint extends SQLiteOpenHelper{

    //Declaracion del nombre de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Declaracion global de la version de la base de datos
    public static final String DATABASE_NAME = "AppDB";

    //Declaracion del nombre de la tabla
    public static final String TABLE_NAME ="Users";

    //sentencia global de cracion de la base de datos
    public static final String USERS_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "username VARCHAR(255) PRIMARY KEY, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "prof_pic_locat TEXT " +
//                    "hometown TEXT, " +
//                    "birthplace TEXT " +
            ");";

    public UsersServiceAPIEndPoint(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor fetchUser(String userName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] value = {userName};
        return db.query(TABLE_NAME, null, "username=?", value, null, null, null);
    }

    public void createUser(ContentValues cv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USERS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
