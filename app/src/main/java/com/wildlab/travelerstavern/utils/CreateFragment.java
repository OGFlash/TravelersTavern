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
import com.wildlab.travelerstavern.data.DatabaseHelper;

import java.util.ArrayList;

/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class CreateFragment extends Fragment{
    private static final String TAG = "CreateFragment";
    private RecyclerView recycler;
    private CharacterAdapter.IUpdateButtonClicks iUpdateButtonClicks;
    private CharacterAdapter characterAdapter;
    private DatabaseHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_create_content, container, false);
        dbHelper = new DatabaseHelper(getContext(), DatabaseHelper.DB_NAME, null, 1);
        recycler = (RecyclerView) rootView.findViewById(R.id.listViewCharacters);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(), recycler.getLayoutManager().getLayoutDirection());
//        recycler.addItemDecoration(dividerItemDecoration);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogBlur", "Warrior", 1, 100, 18, 28, 15, 14, 12, 10, 30, 40);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogGnarr", "Gravity Master", 1, 200, 14, 30, 20, 15, 15, 11, 20, 40);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogSarr", "Forge Master", 1, 150, 21, 9, 11, 18, 15, 11, 19, 40);

        //TODO CREATING CUSTOM QUERIES LIKE GET_ALL_RECORDS
        ArrayList<Character> characters = dbHelper.getAllCharacterRecords();
        characterAdapter = new CharacterAdapter(getContext(), characters);
        recycler.setAdapter(characterAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
//        recycler.invalidate();




        return rootView;
    }

}
