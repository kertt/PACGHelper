package dks.pathfinderacghelper;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Dennis on 15-12-2014.
 */
public class SkillsFragmentSS extends ListFragment {
    int skillArray;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SkullChar active = (SkullChar) getActivity();
        skillArray = active.getCharSkill();
        return inflater.inflate(R.layout.fragment_skills, container, false);


    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), skillArray, R.layout.list_row_smaller);
        setListAdapter(adapter);
    }

}
