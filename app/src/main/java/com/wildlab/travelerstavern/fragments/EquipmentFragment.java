package com.wildlab.travelerstavern.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildlab.travelerstavern.R;

/**
 * @author Prad Ejner
 * @since 9/30/2017.
 */

public class EquipmentFragment extends Fragment{
    private static final String TAG = "CharacterFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_create_content, container, false);
        return rootView;
    }
}
