package dubinsky.scott.FencerNotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Scott Dubinsky on 2/7/14.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    static public final String dbName = "fencerDB";
    public static final String fencerTable = "Fencers";
    public static final String colName = "Name";
    public static final String colWeapon = "Weapon";
    public static final String colLosses = "Losses";
    public static final String colID = "ID";

    public DatabaseHelper(Context appContext){
        super(appContext, "androidsqlite.db", null, 1);
    }
    //Triggers: allow you to ensure certain conditions are met before adding to a table.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        System.out.println("CREATE TABLE " + fencerTable + "( " +
        colName + " TEXT, " + colWeapon + " TEXT, " + "_id INTEGER PRIMARY KEY AUTOINCREMENT);");

        sqLiteDatabase.execSQL("CREATE TABLE " + fencerTable + "( " +
                colName + " TEXT, " + colWeapon + " TEXT, " + "_id INTEGER PRIMARY KEY AUTOINCREMENT);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    public void insertFencer(String name, String weapon){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(colName, name);
        cv.put(colWeapon, weapon);
        db.insert(fencerTable, null, cv);
        db.close();
    }

    public Cursor getAllFencers(){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Fencers";
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor;
    }
}
