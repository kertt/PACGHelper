package dks.pathfinderacghelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Kertt on 19-05-2015.
 */
public class WrathOfTheRighteousActivity extends ActionBarActivity{
    ListView l;
    String[] nameArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrath_of_the_righteous);
        l = (ListView) findViewById(R.id.wotrList);
        nameArray = getResources().getStringArray(R.array.WotR);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameArray);
        l.setAdapter(adapter);
        /*l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String theName = nameArray[position];
                theName = theName.toLowerCase();
                Intent intent = new Intent(WrathOfTheRighteousActivity.this, SkullChar.class);
                intent.putExtra("theName", theName);
                startActivity(intent);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wrath_of_the_righteous, menu);
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
