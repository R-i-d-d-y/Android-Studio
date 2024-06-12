package com.example.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String ID = "id";
    static final String CID = "cid";
    static final String NAME = "name";
    static final String SESSION = "session";
    static final String MOBILE_NUMBER="mobile_number";
    static final String DATABASE_NAME = "RIDDY";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE =
            "create table contacts ("+ID+" integer primary key autoincrement, "+CID+"integer not null,"
                    + NAME+" text not null,"+SESSION+" integer not null,"+MOBILE_NUMBER+"integer not null);";
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w("Database", "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        DBHelper.close();
    }
    public long insertContact(int cid,String name, int session,int mobile_Number)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(CID, cid);
        initialValues.put(NAME, name);
        initialValues.put(SESSION, session);
        initialValues.put(MOBILE_NUMBER,mobile_Number);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public Cursor getAllContacts()
    {
        return db.query(DATABASE_TABLE,new String[] { ID,CID,NAME,SESSION,MOBILE_NUMBER},null,null,null,null,null);
    }
}
