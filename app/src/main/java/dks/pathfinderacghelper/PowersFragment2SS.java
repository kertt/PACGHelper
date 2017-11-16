package dks.pathfinderacghelper;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Dennis on 15-12-2014.
 */
public class PowersFragment2SS extends ListFragment {
    int roleArray;
    String roleName;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SkullChar active = (SkullChar) getActivity();
        roleArray = active.getCharRole2();
        roleName = active.getCharNaR2();
        return inflater.inflate(R.layout.fragment_powers2, container, false);


    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setText(roleName);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), roleArray, R.layout.list_row_smaller);
        setListAdapter(adapter);
    }

    public void setText(String text){
        TextView textView = (TextView) getView().findViewById(R.id.frag_powers2);
        textView.setText(text);
    }
}
