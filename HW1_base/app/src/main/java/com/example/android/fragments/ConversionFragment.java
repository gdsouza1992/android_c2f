package com.example.android.fragments;

import android.view.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by hp on 27/09/2017.
 */

public class ConversionFragment extends Fragment {

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.conversion, container, false);
    }

}
