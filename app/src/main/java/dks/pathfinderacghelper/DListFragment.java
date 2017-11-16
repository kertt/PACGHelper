package dks.pathfinderacghelper;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dennis on 15-12-2014.
 */
public class DListFragment extends ListFragment {

    RuneChar active;
    String[] cardCounts;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        active = (RuneChar) getActivity();
        cardCounts = getActivity().getResources().getStringArray(active.getCharrrCardNums());




        return inflater.inflate(R.layout.fragment_dlist, container, false);

    }
}
