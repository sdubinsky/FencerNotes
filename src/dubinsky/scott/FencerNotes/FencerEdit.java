package dubinsky.scott.FencerNotes;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FencerEdit extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fenceredit);
    }

    public void saveFencer(View view){
        EditText name =  (EditText) findViewById(R.id.oppName);
        EditText weapon = (EditText) findViewById(R.id.oppWeapon);

        DatabaseHelper fencerDb = new DatabaseHelper(getApplicationContext());
        fencerDb.insertFencer(name.getText().toString(), weapon.getText().toString());

        Intent listFencers = new Intent(this, FencerList.class);
        startActivity(listFencers);
    }
}
