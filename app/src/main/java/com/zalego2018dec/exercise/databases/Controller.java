package com.zalego2018dec.exercise.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by folio on 12/11/2018.
 */

/* this is the database connection class. enables us to connect
    to our database and create tables for us in the database
 */
public class Controller extends SQLiteOpenHelper {
    public static final String database_name ="db_mo_sounds";
    public Controller(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // YOU CREATE THE TABLES THAT WILL RUN IN THE DATABASE
        sqLiteDatabase.execSQL(table_users.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
