package dubinsky.scott.FencerNotes;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Scott Dubinsky on 2/8/14.
 */
public class FencerList extends ListActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        setContentView(R.layout.fencerlist);
        Cursor cursor = dbHelper.getAllFencers();

        while(cursor.moveToNext()){
            System.out.println(cursor.getString(0) + cursor.getString(1));
        }
        cursor.moveToPosition(0);
        System.out.println(cursor.getCount());
        ListAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{DatabaseHelper.colName, DatabaseHelper.colWeapon},
                new int[]{android.R.id.text1, android.R.id.text2});
        setListAdapter(adapter);
    }
}