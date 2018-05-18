package com.example.android.waitlist.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.waitlist.data.WaitlistContract.WaitlistEntry;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // FIXME: 18/05/2018 it is better to declare these inside the contract
    private static final String PRIMARY_KEY_AUTO_INCREMENT = " INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String TYPE_TEXT = " TEXT";
    // BOOLEAN is a NUMERIC type
    private static final String TYPE_BOOLEAN = " BOOLEAN";
    private static final String TYPE_TIMESTAMP = " TIMESTAMP";
    private static final String NOT_NULL = " NOT NULL";
    private static final String DEFAULT_CURRENT_TIMESTAMP = " DEFAULT CURRENT_TIMESTAMP";
    private static final String COMMA = ", ";

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    static final String DATABASE_NAME = "waitlist.db";

    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1
    static final int DATABASE_VERSION = 1;

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public WaitlistDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    // TODO (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        // FIXME: 18/05/2018 it is better to declare these strings inside the contract
        String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + WaitlistEntry.TABLE_NAME + " (" +
                WaitlistEntry._ID + PRIMARY_KEY_AUTO_INCREMENT + COMMA +
                WaitlistEntry.COLUMN_GUEST_NAME + TYPE_TEXT + NOT_NULL + COMMA +
                WaitlistEntry.COLUMN_PARTY_SIZE + TYPE_INTEGER + NOT_NULL + COMMA +
                WaitlistEntry.COLUMN_TIMESTAMP + TYPE_TIMESTAMP + DEFAULT_CURRENT_TIMESTAMP +
                ")";
        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // TODO (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it
        db.execSQL("DROP TABLE IF EXISTS " + WaitlistEntry.TABLE_NAME);
        onCreate(db);
    }

}