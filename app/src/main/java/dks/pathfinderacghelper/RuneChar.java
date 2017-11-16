package dks.pathfinderacghelper;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;


public class RuneChar extends ActionBarActivity {
    ImageView i;
    String charNa;
    int charSkill;
    int charRole1;
    int charRole2;

    int charrrCardNums;

    int weapCount=0;

    /* checkbox info for cardsFragment */
    int charCa1txt;
    int charCa2txt;
    int charCa3txt;
    int charCa4txt;
    int charCa5txt;
    int charCa2Vis;
    int charCa3Vis;
    int charCa4Vis;
    int charCa5Vis;

    /* checkbox info for SkillsFragment */

    int charSkPretxt;
    int charSkcb1txt;
    int charSkcb2txt;
    int charSkcb3txt;
    int charSkcb4txt;
    int charSkcb1Vis;
    int charSkcb2Vis;
    int charSkcb3Vis;
    int charSkcb4Vis;

    /*checkbox info for PowersFragment1 */

    int charrr1Pretxt;
    int charrr1cb1txt;
    int charrr1cb2txt;
    int charrr1cb3txt;
    int charrr1cb4txt;
    int charrr1cb5txt;
    int charrr1cb1Vis;
    int charrr1cb2Vis;
    int charrr1cb3Vis;
    int charrr1cb4Vis;
    int charrr1cb5Vis;

    /*checkbox info for PowersFragment2 */

    int charrr2Pretxt;
    int charrr2cb1txt;
    int charrr2cb2txt;
    int charrr2cb3txt;
    int charrr2cb4txt;
    int charrr2cb5txt;
    int charrr2cb1Vis;
    int charrr2cb2Vis;
    int charrr2cb3Vis;
    int charrr2cb4Vis;
    int charrr2cb5Vis;

    String charNaR1;
    String charNaR2;
    String charNaAk;
    String charFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rune_char);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            charNa = extras.getString("theName");
            String charName = charNa.concat("pic1");
            int picId = this.getResources().getIdentifier(charName, "drawable", this.getPackageName());
            i = (ImageView) findViewById(R.id.runePic);
            i.setImageResource(picId);

            String charNaSk = charNa.concat("_rrskills");
            String charCa1tx = charNa.concat("_rrcardscb1text");
            String charCa2tx = charNa.concat("_rrcardscb2text");
            String charCa3tx = charNa.concat("_rrcardscb3text");
            String charCa4tx = charNa.concat("_rrcardscb4text");
            String charCa5tx = charNa.concat("_rrcardscb5text");
            String charCa2Vi = charNa.concat("_rrcardscb2vis");
            String charCa3Vi = charNa.concat("_rrcardscb3vis");
            String charCa4Vi = charNa.concat("_rrcardscb4vis");
            String charCa5Vi = charNa.concat("_rrcardscb5vis");

            String charSkPretx = charNa.concat("_rrskillsPretxt");
            String charSkcb1tx = charNa.concat("_rrskills1txt");
            String charSkcb2tx = charNa.concat("_rrskills2txt");
            String charSkcb3tx = charNa.concat("_rrskills3txt");
            String charSkcb4tx = charNa.concat("_rrskills4txt");
            String charSkcb1Vi = charNa.concat("_rrskills1Vis");
            String charSkcb2Vi = charNa.concat("_rrskills2Vis");
            String charSkcb3Vi = charNa.concat("_rrskills3Vis");
            String charSkcb4Vi = charNa.concat("_rrskills4Vis");

            String charrr1Pretx = charNa.concat("_rrrole1Pretxt");
            String charrr1cb1tx = charNa.concat("_rrrole1cb1txt");
            String charrr1cb2tx = charNa.concat("_rrrole1cb2txt");
            String charrr1cb3tx = charNa.concat("_rrrole1cb3txt");
            String charrr1cb4tx = charNa.concat("_rrrole1cb4txt");
            String charrr1cb5tx = charNa.concat("_rrrole1cb5txt");
            String charrr1cb1Vi = charNa.concat("_rrrole1cb1Vis");
            String charrr1cb2Vi = charNa.concat("_rrrole1cb2Vis");
            String charrr1cb3Vi = charNa.concat("_rrrole1cb3Vis");
            String charrr1cb4Vi = charNa.concat("_rrrole1cb4Vis");
            String charrr1cb5Vi = charNa.concat("_rrrole1cb5Vis");

            String charrr2Pretx = charNa.concat("_rrrole2Pretxt");
            String charrr2cb1tx = charNa.concat("_rrrole2cb1txt");
            String charrr2cb2tx = charNa.concat("_rrrole2cb2txt");
            String charrr2cb3tx = charNa.concat("_rrrole2cb3txt");
            String charrr2cb4tx = charNa.concat("_rrrole2cb4txt");
            String charrr2cb5tx = charNa.concat("_rrrole2cb5txt");
            String charrr2cb1Vi = charNa.concat("_rrrole2cb1Vis");
            String charrr2cb2Vi = charNa.concat("_rrrole2cb2Vis");
            String charrr2cb3Vi = charNa.concat("_rrrole2cb3Vis");
            String charrr2cb4Vi = charNa.concat("_rrrole2cb4Vis");
            String charrr2cb5Vi = charNa.concat("_rrrole2cb5Vis");

            String charrrCardNumbs = charNa.concat("_rrcardsnumb");

            charNaAk = charNa.concat("_rrAk");
            charNaR1 = charNa.concat("_rrrole1");
            charNaR2 = charNa.concat("_rrrole2");
            charFav = charNa.concat("_rrFav");

            charCa1txt = getResources().getIdentifier(charCa1tx, "array", getPackageName());
            charCa2txt = getResources().getIdentifier(charCa2tx, "array", getPackageName());
            charCa3txt = getResources().getIdentifier(charCa3tx, "array", getPackageName());
            charCa4txt = getResources().getIdentifier(charCa4tx, "array", getPackageName());
            charCa5txt = getResources().getIdentifier(charCa5tx, "array", getPackageName());
            charCa2Vis = getResources().getIdentifier(charCa2Vi, "array", getPackageName());
            charCa3Vis = getResources().getIdentifier(charCa3Vi, "array", getPackageName());
            charCa4Vis = getResources().getIdentifier(charCa4Vi, "array", getPackageName());
            charCa5Vis = getResources().getIdentifier(charCa5Vi, "array", getPackageName());

            charSkPretxt = getResources().getIdentifier(charSkPretx, "array", getPackageName());
            charSkcb1txt = getResources().getIdentifier(charSkcb1tx, "array", getPackageName());
            charSkcb2txt = getResources().getIdentifier(charSkcb2tx, "array", getPackageName());
            charSkcb3txt = getResources().getIdentifier(charSkcb3tx, "array", getPackageName());
            charSkcb4txt = getResources().getIdentifier(charSkcb4tx, "array", getPackageName());
            charSkcb1Vis = getResources().getIdentifier(charSkcb1Vi, "array", getPackageName());
            charSkcb2Vis = getResources().getIdentifier(charSkcb2Vi, "array", getPackageName());
            charSkcb3Vis = getResources().getIdentifier(charSkcb3Vi, "array", getPackageName());
            charSkcb4Vis = getResources().getIdentifier(charSkcb4Vi, "array", getPackageName());

            charrr1Pretxt = getResources().getIdentifier(charrr1Pretx, "array", getPackageName());
            charrr1cb1txt = getResources().getIdentifier(charrr1cb1tx, "array", getPackageName());
            charrr1cb2txt = getResources().getIdentifier(charrr1cb2tx, "array", getPackageName());
            charrr1cb3txt = getResources().getIdentifier(charrr1cb3tx, "array", getPackageName());
            charrr1cb4txt = getResources().getIdentifier(charrr1cb4tx, "array", getPackageName());
            charrr1cb5txt = getResources().getIdentifier(charrr1cb5tx, "array", getPackageName());
            charrr1cb1Vis = getResources().getIdentifier(charrr1cb1Vi, "array", getPackageName());
            charrr1cb2Vis = getResources().getIdentifier(charrr1cb2Vi, "array", getPackageName());
            charrr1cb3Vis = getResources().getIdentifier(charrr1cb3Vi, "array", getPackageName());
            charrr1cb4Vis = getResources().getIdentifier(charrr1cb4Vi, "array", getPackageName());
            charrr1cb5Vis = getResources().getIdentifier(charrr1cb5Vi, "array", getPackageName());

            charrr2Pretxt = getResources().getIdentifier(charrr2Pretx, "array", getPackageName());
            charrr2cb1txt = getResources().getIdentifier(charrr2cb1tx, "array", getPackageName());
            charrr2cb2txt = getResources().getIdentifier(charrr2cb2tx, "array", getPackageName());
            charrr2cb3txt = getResources().getIdentifier(charrr2cb3tx, "array", getPackageName());
            charrr2cb4txt = getResources().getIdentifier(charrr2cb4tx, "array", getPackageName());
            charrr2cb5txt = getResources().getIdentifier(charrr2cb5tx, "array", getPackageName());
            charrr2cb1Vis = getResources().getIdentifier(charrr2cb1Vi, "array", getPackageName());
            charrr2cb2Vis = getResources().getIdentifier(charrr2cb2Vi, "array", getPackageName());
            charrr2cb3Vis = getResources().getIdentifier(charrr2cb3Vi, "array", getPackageName());
            charrr2cb4Vis = getResources().getIdentifier(charrr2cb4Vi, "array", getPackageName());
            charrr2cb5Vis = getResources().getIdentifier(charrr2cb5Vi, "array", getPackageName());

            charSkill = getResources().getIdentifier(charNaSk, "array", getPackageName());
            charRole1 = getResources().getIdentifier(charNaR1, "array", getPackageName());
            charRole2 = getResources().getIdentifier(charNaR2, "array", getPackageName());

            charrrCardNums = getResources().getIdentifier(charrrCardNumbs, "array", getPackageName());

            charNaR1 = getResources().getString(getResources().getIdentifier(charNaR1, "string", getPackageName()));
            charNaR2 = getResources().getString(getResources().getIdentifier(charNaR2, "string", getPackageName()));
            charNaAk = getResources().getString(getResources().getIdentifier(charNaAk, "string", getPackageName()));
            charFav = getResources().getString(getResources().getIdentifier(charFav, "string", getPackageName()));
            CardsFragment frag = new CardsFragment();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.activity_rune_char, frag, "runecharsfrag");
            transaction.commit();
        }
    }


    public int getCharSkill(){
        return charSkill;
    }

    public int getCharRole1() {return charRole1;}

    public int getCharRole2() {return charRole2;}


    /* methods for getting the arrays for the cards fragment */

    public int getCharCa1txt() {return charCa1txt;}

    public int getCharCa2txt() {return charCa2txt;}

    public int getCharCa3txt() {return charCa3txt;}

    public int getCharCa4txt() {return charCa4txt;}

    public int getCharCa5txt() {return charCa5txt;}

    public int getCharCa2Vis() {return charCa2Vis;}

    public int getCharCa3Vis() {return charCa3Vis;}

    public int getCharCa4Vis() {return charCa4Vis;}

    public int getCharCa5Vis() {return charCa5Vis;}


    /* methods for getting the arrays for the skills fragment */

    public int getCharSkPretxt() {return charSkPretxt;}

    public int getCharSkcb1txt() {return charSkcb1txt;}

    public int getCharSkcb2txt() {return charSkcb2txt;}

    public int getCharSkcb3txt() {return charSkcb3txt;}

    public int getCharSkcb4txt() {return charSkcb4txt;}

    public int getCharSkcb1Vis() {return charSkcb1Vis;}

    public int getCharSkcb2Vis() {return charSkcb2Vis;}

    public int getCharSkcb3Vis() {return charSkcb3Vis;}

    public int getCharSkcb4Vis() {return charSkcb4Vis;}


    /* methods for getting the arrays for the role fragment 1 */

    public int getCharrr1Pretxt() {return charrr1Pretxt;}

    public int getCharrr1cb1txt() {return charrr1cb1txt;}

    public int getCharrr1cb2txt() {return charrr1cb2txt;}

    public int getCharrr1cb3txt() {return charrr1cb3txt;}

    public int getCharrr1cb4txt() {return charrr1cb4txt;}

    public int getCharrr1cb5txt() {return charrr1cb5txt;}

    public int getCharrr1cb1Vis() {return charrr1cb1Vis;}

    public int getCharrr1cb2Vis() {return charrr1cb2Vis;}

    public int getCharrr1cb3Vis() {return charrr1cb3Vis;}

    public int getCharrr1cb4Vis() {return charrr1cb4Vis;}

    public int getCharrr1cb5Vis() {return charrr1cb5Vis;}


    /* methods for getting the arrays for the role fragment 2 */

    public int getCharrr2Pretxt() {return charrr2Pretxt;}

    public int getCharrr2cb1txt() {return charrr2cb1txt;}

    public int getCharrr2cb2txt() {return charrr2cb2txt;}

    public int getCharrr2cb3txt() {return charrr2cb3txt;}

    public int getCharrr2cb4txt() {return charrr2cb4txt;}

    public int getCharrr2cb5txt() {return charrr2cb5txt;}

    public int getCharrr2cb1Vis() {return charrr2cb1Vis;}

    public int getCharrr2cb2Vis() {return charrr2cb2Vis;}

    public int getCharrr2cb3Vis() {return charrr2cb3Vis;}

    public int getCharrr2cb4Vis() {return charrr2cb4Vis;}

    public int getCharrr2cb5Vis() {return charrr2cb5Vis;}


    public String getCharNaR1(){return charNaR1;}

    public String getCharNaR2(){return charNaR2;}

    public String getCharNaAk() {return charNaAk;}

    public String getCharFav() {return charFav;}

    public int getCharrrCardNums(){return charrrCardNums;}

    public int getWeapCount(){return weapCount;}

    public void setWeapCount(int count){
        weapCount = count;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rune_char, menu);
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
            case R.id.runeCards:
                CardsFragment frag1 = new CardsFragment();
                transaction.replace(R.id.activity_rune_char, frag1);
                transaction.commit();
                return true;

            case R.id.runeDList:
                DListFragment frag2 = new DListFragment();
                transaction.replace(R.id.activity_rune_char, frag2);
                transaction.commit();
                return true;

            case R.id.runeSkills:
                SkillsFragment frag3 = new SkillsFragment();
                transaction.replace(R.id.activity_rune_char, frag3);
                transaction.commit();
                //Toast.makeText(getApplicationContext(), charNa, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.runePowers1:
                PowersFragment1 frag4 = new PowersFragment1();
                transaction.replace(R.id.activity_rune_char, frag4);
                transaction.commit();
                return true;

            case R.id.runePowers2:
                PowersFragment2 frag5 = new PowersFragment2();
                transaction.replace(R.id.activity_rune_char, frag5);
                transaction.commit();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
