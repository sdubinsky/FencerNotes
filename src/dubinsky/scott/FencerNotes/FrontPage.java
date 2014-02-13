package dubinsky.scott.FencerNotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Scott Dubinsky on 1/28/14.
 */
public class FrontPage extends Activity {
    /*
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage);
    }

    public void editFencer(View view){
        Intent intent = new Intent(this, FencerEdit.class);
        startActivity(intent);
    }

    public void placeholderClick(View view){
        Toast.makeText(getApplicationContext(), "Doesn't work yet", Toast.LENGTH_SHORT).show();
    }
}