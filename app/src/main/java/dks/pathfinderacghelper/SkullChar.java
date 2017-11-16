package dks.pathfinderacghelper;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class SkullChar extends ActionBarActivity {
    ImageView i;
    String charNa;
    int charSkill;
    int charRole1;
    int charRole2;
    String charNaR1;
    String charNaR2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skull_char);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            charNa = extras.getString("theName");
            String charName = charNa.concat("pic1");
            int picId = this.getResources().getIdentifier(charName, "drawable", this.getPackageName());
            i = (ImageView) findViewById(R.id.runePic);
            i.setImageResource(picId);
            String charNaSk = charNa.concat("_ssskills");
            charNaR1 = charNa.concat("_ssrole1");
            charNaR2 = charNa.concat("_ssrole2");
            charSkill = getResources().getIdentifier(charNaSk, "array", getPackageName());
            charRole1 = getResources().getIdentifier(charNaR1, "array", getPackageName());
            charRole2 = getResources().getIdentifier(charNaR2, "array", getPackageName());
            charNaR1 = getResources().getString(getResources().getIdentifier(charNaR1, "string", getPackageName()));
            charNaR2 = getResources().getString(getResources().getIdentifier(charNaR2, "string", getPackageName()));

            CardsFragment frag = new CardsFragment();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.activity_skull_char, frag, "skullcharsfrag");
            transaction.commit();

        }
    }



    public int getCharSkill(){

        return charSkill;
    }

    public int getCharRole1() {return charRole1;}

    public int getCharRole2() {return charRole2;}

    public String getCharNaR1(){return charNaR1;}

    public String getCharNaR2(){return charNaR2;}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_skull_char, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (item.getItemId()){
            case R.id.skullCards:
                CardsFragment frag1 = new CardsFragment();
                transaction.replace(R.id.activity_skull_char, frag1);
                transaction.commit();
                return true;

            case R.id.skullDList:
                DListFragment frag2 = new DListFragment();
                transaction.replace(R.id.activity_skull_char, frag2);
                transaction.commit();
                return true;

            case R.id.skullSkills:
                SkillsFragmentSS frag3 = new SkillsFragmentSS();
                transaction.replace(R.id.activity_skull_char, frag3);
                transaction.commit();
                return true;

            case R.id.skullPowers1:
                PowersFragment1SS frag4 = new PowersFragment1SS();
                transaction.replace(R.id.activity_skull_char, frag4);
                transaction.commit();
                return true;

            case R.id.skullPowers2:
                PowersFragment2SS frag5 = new PowersFragment2SS();
                transaction.replace(R.id.activity_skull_char, frag5);
                transaction.commit();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
