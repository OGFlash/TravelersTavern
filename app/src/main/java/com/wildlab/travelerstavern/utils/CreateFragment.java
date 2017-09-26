package com.wildlab.travelerstavern.utils;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildlab.travelerstavern.R;

import java.util.ArrayList;

/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class CreateFragment extends Fragment{
    private static final String TAG = "CreateFragment";
    private RecyclerView recycler;
    private ArrayList<Character> characterList;
    private CharacterAdapter.IUpdateButtonClicks iUpdateButtonClicks;
    private CharacterAdapter characterAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_create_content, container, false);

        recycler = (RecyclerView) rootView.findViewById(R.id.listViewCharacters);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(), recycler.getLayoutManager().getLayoutDirection());
//        recycler.addItemDecoration(dividerItemDecoration);
        characterList = new ArrayList<Character>();
        characterAdapter = new CharacterAdapter(getContext(), characterList);
        //TODO Dynamically CREATE. From Database. Implement SqlLiteDB
        characterList.add(new Character("OogBlar", "10", "Wizard"));
        characterList.add(new Character("OogMur", "12", "Sniper"));
        characterList.add(new Character("OogTur", "14", "GunSlinger"));

        recycler.setAdapter(characterAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
//        recycler.invalidate();




        return rootView;
    }

}
