package com.wildlab.travelerstavern.utils;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildlab.travelerstavern.R;

/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class DescribeFragment extends Fragment {
    private static final String TAG = "DescribeFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_describe_content, container, false);
        return rootView;
    }


}
