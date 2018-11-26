package com.wildlab.travelerstavern.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wildlab.travelerstavern.api.RetrieveFeedTask;

import com.wildlab.travelerstavern.R;


/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class SpellsFragment extends Fragment {

    private static final String TAG = "SpellsFragment";
    private ProgressBar progressBar;
    private EditText editApi;
    private TextView response;
    private Button queryButton;
    private RetrieveFeedTask retrieveFeedTask;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_spells_content, container, false);
        queryButton = (Button) rootView.findViewById(R.id.queryButton);
        editApi = (EditText) rootView.findViewById(R.id.edit_api);


        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextApiCurrentString = getEditApiText();
                startQueryApi(editTextApiCurrentString);
            }
        });

        return rootView;
    }

    protected void startQueryApi(String urls){
        retrieveFeedTask = new RetrieveFeedTask(this);
        retrieveFeedTask.execute(urls);
    }

    public void showProgressBar(){
        response = (TextView) getActivity().findViewById(R.id.responseView);
        response.setVisibility(View.GONE);
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);
    }

    public String getEditApiText(){
        editApi = (EditText) getActivity().findViewById(R.id.edit_api);
        return editApi.getText().toString();
    }

    public void hideProgressBar(){
        response = (TextView) getActivity().findViewById(R.id.responseView);
        response.setVisibility(View.VISIBLE);
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    public void populateResults(String s){
        response = (TextView) getActivity().findViewById(R.id.responseView);
        response.setText(s);
    }
}
