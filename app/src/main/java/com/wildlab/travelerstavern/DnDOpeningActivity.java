package com.wildlab.travelerstavern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wildlab.travelerstavern.db.DatabaseHelper;
import com.wildlab.travelerstavern.utils.Character;
import com.wildlab.travelerstavern.utils.CharacterAdapter;

import java.util.ArrayList;

/**
 * Created by Owner on 9/30/2017.
 */

public class DnDOpeningActivity extends AppCompatActivity {

    private ArrayList<Character> characters;
    private RecyclerView recyclerView;

    private RecyclerView recycler;
    private CharacterAdapter.IUpdateButtonClicks iUpdateButtonClicks;
    private CharacterAdapter characterAdapter;
    private DatabaseHelper dbHelper;
    private FloatingActionButton floatingActionButton;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle saveInstantstate) {
        super.onCreate(saveInstantstate);
        setContentView(R.layout.dnd_open_content);





        dbHelper = new DatabaseHelper(this, DatabaseHelper.DB_NAME, null, 1);
        recycler = (RecyclerView) findViewById(R.id.listViewCharacters);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(), recycler.getLayoutManager().getLayoutDirection());
//        recycler.addItemDecoration(dividerItemDecoration);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogBlur", "Warrior", 1, 100, 18, 28, 15, 14, 12, 10, 30, 40);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogGnarr", "Gravity Master", 1, 200, 14, 30, 20, 15, 15, 11, 20, 40);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogSarr", "Forge Master", 1, 150, 21, 9, 11, 18, 15, 11, 19, 40);


        //TODO CREATING CUSTOM QUERIES LIKE GET_ALL_RECORDS
//        ArrayList<Character> characters = dbHelper.getAllCharacterRecords();
//        characterAdapter = new CharacterAdapter(this, characters);
//        recycler.setAdapter(characterAdapter);
//        recycler.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab_open_dnd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter == 0) {
                    DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogBlur", "Warrior", 1, 100, 18, 28, 15, 14, 12, 10, 30, 40);
                }
                ArrayList<Character> characters = dbHelper.getAllCharacterRecords();
                characterAdapter = new CharacterAdapter(DnDOpeningActivity.this, characters);
                recycler.setAdapter(characterAdapter);
                recycler.setLayoutManager(new LinearLayoutManager(DnDOpeningActivity.this));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
