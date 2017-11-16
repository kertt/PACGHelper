package dks.pathfinderacghelper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ClassDecksUnder extends ActionBarActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_decks_under);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            final String arrayName = extras.getString("theClass");
            int arrayId = this.getResources().getIdentifier(arrayName, "array", this.getPackageName());
            l = (ListView) findViewById(R.id.CDunder);
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(arrayId));
            l.setAdapter(adapter);
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), arrayName, Toast.LENGTH_SHORT).show();
                }
            });

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_class_decks_under, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
