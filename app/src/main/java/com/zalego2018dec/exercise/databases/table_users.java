package com.zalego2018dec.exercise.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zalego2018dec.exercise.objects.Person;

/**
 * Created by folio on 12/11/2018.
 */

public class table_users extends Controller {
    public table_users(Context context) {
        super(context);
    }

    // create the table
    // we need the columns
    public static final String table_name = "tb_users";
    public static final String col_id = "id";
    public static final String col_name = "Name";
    public static final String col_phone = "Phone Number";
    public static final String col_email = "Email";
    public static final String col_password = "password";
    public static final String col_gender = "Gender";

    // we run a query to create the table
    public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+
            table_name+"("+
            col_id+" BIGINT AUTOINCREMENT,"+
            col_name+" VARCHAR(50),"+
            col_phone+" VARCHAR(50),"+
            col_gender+" VARCHAR(50),"+
            col_email+" VARCHAR(50),"+
            col_password+" VARCHAR(50))";

    public void registerUser(Person person){
        SQLiteDatabase db = getWritableDatabase();
        /*
         content Values are used to pair sets of information in
            in our case we will pair the column name together with the data itself
          */
        ContentValues values = new ContentValues();
        values.put(col_name,person.getName());
        values.put(col_phone,person.getPhoneNumber());
        values.put(col_gender,person.getGender());
        values.put(col_email,person.getEmail());
        values.put(col_password,person.getPassword());

        db.insert(table_name,null,values);

    }

}
