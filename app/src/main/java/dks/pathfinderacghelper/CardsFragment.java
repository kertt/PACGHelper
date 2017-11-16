package dks.pathfinderacghelper;

import android.app.ListFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.*;
import java.lang.*;
/**
 * Created by Dennis on 15-12-2014.
 */
public class CardsFragment extends ListFragment {
    String charAk;
    String charAk2;
    String charAk3;
    String charAk4;
    String charAk5;
    String charFav;
    String[] preTexts;
    String[] CB1Texts;
    String[] CB2Texts;
    String[] CB3Texts;
    String[] CB4Texts;
    String[] CB5Texts;
    String[] CB2Visible;
    String[] CB3Visible;
    String[] CB4Visible;
    String[] CB5Visible;
    ArrayList<Line> theLines = new ArrayList<Line>();

    RuneChar active;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        active = (RuneChar) getActivity();
        charFav = active.getCharFav();
        charAk = active.getCharNaAk();
        preTexts = getActivity().getResources().getStringArray(R.array.cardscc);
        CB1Texts = getActivity().getResources().getStringArray(active.getCharCa1txt());
        CB2Texts = getActivity().getResources().getStringArray(active.getCharCa2txt());
        CB3Texts = getActivity().getResources().getStringArray(active.getCharCa3txt());
        CB4Texts = getActivity().getResources().getStringArray(active.getCharCa4txt());
        CB5Texts = getActivity().getResources().getStringArray(active.getCharCa5txt());
        CB2Visible = getActivity().getResources().getStringArray(active.getCharCa2Vis());
        CB3Visible = getActivity().getResources().getStringArray(active.getCharCa3Vis());
        CB4Visible = getActivity().getResources().getStringArray(active.getCharCa4Vis());
        CB5Visible = getActivity().getResources().getStringArray(active.getCharCa5Vis());

        return inflater.inflate(R.layout.fragment_cards, container, false);


    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.BLACK));
        getListView().setDividerHeight(1);
        charAk2 = charAk.concat("2");
        charAk3 = charAk.concat("3");
        charAk4 = charAk.concat("4");
        charAk5 = charAk.concat("5");

        for (int i =0; i<6;i++){
            String charAk21 = charAk2.concat(Integer.toString(i));
            String charAk31 = charAk3.concat(Integer.toString(i));
            String charAk41 = charAk4.concat(Integer.toString(i));
            String charAk51 = charAk5.concat(Integer.toString(i));




            Line lin = new Line(preTexts[i], CB1Texts[i], CB2Texts[i], CB3Texts[i], CB4Texts[i], CB5Texts[i], "true", charAk21, charAk31, charAk41, charAk51, "true", CB2Visible[i], CB3Visible[i],CB4Visible[i],CB5Visible[i]);
            theLines.add(lin);
        }
        active.setWeapCount(Integer.parseInt(theLines.get(0).CB1Text));
        CBAdapter mAdapter = new CBAdapter(getActivity(), theLines);
        setListAdapter(mAdapter);
        TextView afterText = (TextView) getActivity().findViewById(R.id.skillsList2);
        afterText.setText("Favored Card Type: " + charFav);

    }

    public class CBAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<Line> lines;
        SharedPreferences.Editor editor;

        public CBAdapter(Context context, List<Line> line){
            mInflater = LayoutInflater.from(context);
            lines = line;
        }

        public int getCount() {
            return lines.size();
        }

        public Object getItem(int position){
            return lines.get(position);
        }
        public long getItemId(int position){
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent){
            View view;
            ViewHolder holder;
            SharedPreferences sharedPrefs = getActivity().getSharedPreferences("cardsfrag", Context.MODE_PRIVATE);
            if (convertView == null){
                view = mInflater.inflate(R.layout.skill_row, parent, false);
                holder = new ViewHolder();
                holder.preText = (TextView)view.findViewById(R.id.textView);
                holder.checkBox1 = (CheckBox)view.findViewById(R.id.checkBox1);
                holder.checkBox2 = (CheckBox)view.findViewById(R.id.checkBox2);
                holder.checkBox3 = (CheckBox)view.findViewById(R.id.checkBox3);
                holder.checkBox4 = (CheckBox)view.findViewById(R.id.checkBox4);
                holder.checkBox5 = (CheckBox)view.findViewById(R.id.checkBox5);
                view.setTag(holder);

            }
            else {
                view = convertView;
                holder = (ViewHolder)view.getTag();
            }

            editor = sharedPrefs.edit();

            final Line line = lines.get(position);
            holder.preText.setText(line.getPreText());
            holder.checkBox1.setText(line.getCB1Text());
            holder.checkBox2.setText(line.getCB2Text());
            holder.checkBox3.setText(line.getCB3Text());
            holder.checkBox4.setText(line.getCB4Text());
            holder.checkBox5.setText(line.getCB5Text());
            holder.checkBox1.setChecked(true);
            holder.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean(line.getCB2Checked()+position, isChecked);
                    editor.commit();
                }
            });
            holder.checkBox2.setChecked(sharedPrefs.getBoolean(line.getCB2Checked()+position, false));
            holder.checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean(line.getCB3Checked()+position, isChecked);
                    editor.commit();
                }
            });
            holder.checkBox3.setChecked(sharedPrefs.getBoolean(line.getCB3Checked() + position, false));
            holder.checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean(line.getCB4Checked()+position, isChecked);
                    editor.commit();
                }
            });
            holder.checkBox4.setChecked(sharedPrefs.getBoolean(line.getCB4Checked() + position, false));
            holder.checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean(line.getCB5Checked()+position, isChecked);
                    editor.commit();
                }
            });
            holder.checkBox5.setChecked(sharedPrefs.getBoolean(line.getCB5Checked() + position, false));
            holder.checkBox1.setClickable(false);
            holder.checkBox1.setVisibility(View.VISIBLE);
            if (line.getCB2Visible()) holder.checkBox2.setVisibility(View.VISIBLE);
                else holder.checkBox2.setVisibility(View.GONE);
            if (line.getCB3Visible()) holder.checkBox3.setVisibility(View.VISIBLE);
                else holder.checkBox3.setVisibility(View.GONE);
            if (line.getCB4Visible()) holder.checkBox4.setVisibility(View.VISIBLE);
                else holder.checkBox4.setVisibility(View.GONE);
            if (line.getCB5Visible()) holder.checkBox5.setVisibility(View.VISIBLE);
                else holder.checkBox5.setVisibility(View.GONE);

            return view;
        }

    }

    private class ViewHolder{
        public TextView preText;
        public CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    }

    private class Line{
        private String preText = "";
        private String CB1Text = "";
        private String CB2Text = "";
        private String CB3Text = "";
        private String CB4Text = "";
        private String CB5Text = "";
        private boolean CB1Visibility = true;
        private boolean CB2Visibility = true;
        private boolean CB3Visibility = true;
        private boolean CB4Visibility = true;
        private boolean CB5Visibility = true;
        private String CB1Checked = "";
        private String CB2Checked = "";
        private String CB3Checked = "";
        private String CB4Checked = "";
        private String CB5Checked = "";


        public Line(String preText, String CB1Text, String CB2Text, String CB3Text, String CB4Text,
                    String CB5Text, String CB1Checked, String CB2Checked, String CB3Checked,
                    String CB4Checked, String CB5Checked, String CB1Visibility, String CB2Visibility,
                    String CB3Visibility, String CB4Visibility, String CB5Visibility){
            this.preText = preText;
            this.CB1Text = CB1Text;
            this.CB2Text = CB2Text;
            this.CB3Text = CB3Text;
            this.CB4Text = CB4Text;
            this.CB5Text = CB5Text;
            this.CB1Checked = CB1Checked;
            this.CB2Checked = CB2Checked;
            this.CB3Checked = CB3Checked;
            this.CB4Checked = CB4Checked;
            this.CB5Checked = CB5Checked;
            this.CB1Visibility = Boolean.valueOf(CB1Visibility);
            this.CB2Visibility = Boolean.valueOf(CB2Visibility);
            this.CB3Visibility = Boolean.valueOf(CB3Visibility);
            this.CB4Visibility = Boolean.valueOf(CB4Visibility);
            this.CB5Visibility = Boolean.valueOf(CB5Visibility);
        }
        public String getPreText(){
            return preText;
        }

        public String getCB1Text(){
            return CB1Text;
        }

        public String getCB2Text(){
            return CB2Text;
        }

        public String getCB3Text(){
            return CB3Text;
        }

        public String getCB4Text(){
            return CB4Text;
        }

        public String getCB5Text(){
            return CB5Text;
        }

        public String getCB2Checked(){
            return CB2Checked;
        }

        public String getCB3Checked(){
            return CB3Checked;
        }

        public String getCB4Checked(){
            return CB4Checked;
        }

        public String getCB5Checked(){
            return CB5Checked;
        }

        public boolean getCB2Visible(){
            return CB2Visibility;
        }

        public boolean getCB3Visible(){
            return CB3Visibility;
        }

        public boolean getCB4Visible(){
            return CB4Visibility;
        }

        public boolean getCB5Visible(){
            return CB5Visibility;
        }

        public void printIt(){
            System.out.println(preText + " and " + CB1Text + " and " + CB2Text + " and " + CB1Checked + " and " + CB2Checked);
        }

    }

}
