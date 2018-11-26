package com.wildlab.travelerstavern;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wildlab.travelerstavern.db.DatabaseHelper;
import com.wildlab.travelerstavern.utils.Character;
import com.wildlab.travelerstavern.utils.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

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
    private String edtNameString;
    private String edtClassNameString;
    private String edtLevelString;
    private String edtHealthString;
    private String edtSpeedString;
    private String edtAcString;
    private String edtStrString;
    private String edtDexString;
    private String edtConString;
    private String edtIntelString;
    private String edtWisString;
    private String edtChaString;

    @Override
    protected void onCreate(Bundle saveInstantstate) {
        super.onCreate(saveInstantstate);
        setContentView(R.layout.dnd_open_content);





        dbHelper = new DatabaseHelper(this, DatabaseHelper.DB_NAME, null, 3);
        recycler = (RecyclerView) findViewById(R.id.listViewCharacters);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycler.getContext(), recycler.getLayoutManager().getLayoutDirection());
//        recycler.addItemDecoration(dividerItemDecoration);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogBlur", "Warrior", 1, 100, 18, 28, 15, 14, 12, 10, 30, 40);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogGnarr", "Gravity Master", 1, 200, 14, 30, 20, 15, 15, 11, 20, 40);
//        DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogSarr", "Forge Master", 1, 150, 21, 9, 11, 18, 15, 11, 19, 40);


        //TODO CREATING CUSTOM QUERIES LIKE GET_ALL_RECORDS
        ArrayList<Character> characters = dbHelper.getAllCharacterRecords();
        characterAdapter = new CharacterAdapter(this, characters);
        recycler.setAdapter(characterAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab_open_dnd);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(counter == 0) {
//                    DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(), "OogBlur", "Warrior", 1, 100, 18, 28, 15, 14, 12, 10, 30, 40);
//                }
                showRaceDialog();
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

    public void showCreateDialog(final String currentRace) {
        //TODO BETTER DIALOG :_)!
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.custom_dialog_theme);
        LayoutInflater inflater = LayoutInflater.from(this);
        final View dialogView = inflater.inflate(R.layout.character_create_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edtName = (EditText) dialogView.findViewById(R.id.new_characters_name);


        //TODO GET FROM API
        final List<String> list = new ArrayList<String>();
        list.add("Barbarian");
        list.add("Bard");
        list.add("Cleric");
        list.add("Druid");
        list.add("Fighter");
        list.add("Monk");
        list.add("Paladin");
        list.add("Ranger");
        list.add("Rogue");
        list.add("Sorcerer");
        list.add("Warlock");
        list.add("Wizard");

        final String[] str = {"Report 1", "Report 2", "Report 3", "Report 4", "Report 5", "Report 6", "Report 7", "Report 8", "Report 9", "Report 10", "Report 11", "Report 12", "Report 13", "Report 14", "Report 15"};

        final Spinner edtClassName = (Spinner) dialogView.findViewById(R.id.new_characters_class_name);

        ArrayAdapter<String> classAdapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, list);


        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edtClassName.setAdapter(classAdapter);


        edtClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText edtLevel = (EditText) dialogView.findViewById(R.id.new_characters_level);
        final EditText edtHealth = (EditText) dialogView.findViewById(R.id.new_characters_health);
        final EditText edtSpeed = (EditText) dialogView.findViewById(R.id.new_characters_speed);
        final EditText edtAc = (EditText) dialogView.findViewById(R.id.new_characters_ac);
        final EditText edtStr = (EditText) dialogView.findViewById(R.id.new_characters_str);
        final EditText edtDex = (EditText) dialogView.findViewById(R.id.new_characters_dex);
        final EditText edtCon = (EditText) dialogView.findViewById(R.id.new_characters_con);
        final EditText edtIntel = (EditText) dialogView.findViewById(R.id.new_characters_intel);
        final EditText edtWis = (EditText) dialogView.findViewById(R.id.new_characters_wis);
        final EditText edtCha = (EditText) dialogView.findViewById(R.id.new_characters_cha);


        dialogBuilder.setTitle("Add New Character!");
        dialogBuilder.setMessage("Provide all Information below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                edtNameString = edtName.getText().toString();
                edtClassNameString = edtClassName.getSelectedItem().toString();
                edtLevelString = edtLevel.getText().toString();
                edtHealthString = edtHealth.getText().toString();
                edtSpeedString = edtSpeed.getText().toString();
                edtAcString = edtAc.getText().toString();
                edtStrString = edtStr.getText().toString();
                edtDexString = edtDex.getText().toString();
                edtConString = edtCon.getText().toString();
                edtIntelString = edtIntel.getText().toString();
                edtWisString = edtWis.getText().toString();
                edtChaString = edtCha.getText().toString();

                if (edtNameString != null
                        && edtClassNameString != null
                        && currentRace != null
                        && edtLevelString != null
                        && edtHealthString != null
                        && edtSpeedString != null
                        && edtAcString != null
                        && edtStrString != null
                        && edtDexString != null
                        && edtConString != null
                        && edtIntelString != null
                        && edtWisString != null
                        && edtChaString != null) {
                    DatabaseHelper.insertCharacterFull(dbHelper.getWritableDatabase(),
                            edtNameString, currentRace, edtClassNameString,
                            Integer.valueOf(edtLevelString),
                            Integer.valueOf(edtHealthString),
                            Integer.valueOf(edtAcString),
                            Integer.valueOf(edtStrString),
                            Integer.valueOf(edtDexString),
                            Integer.valueOf(edtConString),
                            Integer.valueOf(edtIntelString),
                            Integer.valueOf(edtWisString),
                            Integer.valueOf(edtChaString),
                            Integer.valueOf(edtSpeedString));
                }
                //TODO MOVE THIS SO THAT WE CAN SEE LIST FIRST. SKILL PAGE IS POPULATING
                ArrayList<Character> characters = dbHelper.getAllCharacterRecords();
                characterAdapter = new CharacterAdapter(DnDOpeningActivity.this, characters);
                recycler.setAdapter(characterAdapter);
                recycler.setLayoutManager(new LinearLayoutManager(DnDOpeningActivity.this));
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
                showRaceDialog();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }



    public void showRaceDialog() {
        //TODO BETTER DIALOG :_)!
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.custom_dialog_theme);
        LayoutInflater inflater = LayoutInflater.from(this);
        final View dialogView = inflater.inflate(R.layout.create_dialog_race, null);
        dialogBuilder.setView(dialogView);

        final TextView textView = dialogView.findViewById(R.id.textDescription);

        //TODO GET FROM API
        final List<String> list = new ArrayList<String>();
        list.add("Human");
        list.add("Half-orc");
        list.add("Dragonborn");
        list.add("Dwarf");
        list.add("Mountain Dwarf");
        list.add("Hill Dwarf");
        list.add("Elf");
        list.add("Halfling");
        list.add("Stout Halfling");
        list.add("Lightfoot Halfling");
        list.add("Forest Gnome");
        list.add("Rock Gnome");
        list.add("High elf");
        list.add("Tiefling");
        list.add("Drow");

        final String[] str = {"Report 1", "Report 2", "Report 3", "Report 4", "Report 5", "Report 6", "Report 7", "Report 8", "Report 9", "Report 10", "Report 11", "Report 12", "Report 13", "Report 14", "Report 15"};

        final Spinner raceSpinner = (Spinner) dialogView.findViewById(R.id.race_spinner);

        final ArrayAdapter<String> raceAdapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, list);


        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceAdapter);


        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub

                if(list.get(position).equals("Human")){
                    textView.setText("Str +2 | Dex +1 | Con +1 | Int +1 | Wis +1 | Cha +1");
                }
                if(list.get(position).equals("Half-orc")){
                    textView.setText("Str +2 | Con +1");
                }
                if(list.get(position).equals("Dragonborn")){
                    textView.setText("Str +2 | Cha +1");
                }
                if(list.get(position).equals("Dwarf")){
                    textView.setText("Con +1");
                }
                if(list.get(position).equals("Mountain Dwarf")){
                    textView.setText("Str +2");
                }
                if(list.get(position).equals("Hill Dwarf")){
                    textView.setText("Wis +1");
                }
                if(list.get(position).equals("Elf")){
                    textView.setText("Dex +2");
                }
                if(list.get(position).equals("Halfling")){
                    textView.setText("Cha +2");
                }
                if(list.get(position).equals("Stout Halfling")){
                    textView.setText("Con +1");

                }
                if(list.get(position).equals("Lightfoot Halfling")){
                    textView.setText("Cha +1");
                }
                if(list.get(position).equals("Forest Gnome")){
                    textView.setText("Dex +1");
                }
                if(list.get(position).equals("High elf")){
                    textView.setText("Int +1");
                }
                if(list.get(position).equals("Tiefling")){
                    textView.setText("Int +1 | Cha +2");
                }
                if(list.get(position).equals("Drow")){
                    textView.setText("Cha +1");
                }

                Toast.makeText(getBaseContext(), list.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        dialogBuilder.setTitle("Pick a Race!");
        dialogBuilder.setMessage("Each Race has it's advantages");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //TODO PASS RACE STAT CHANGES
                showCreateDialog(raceAdapter.getItem(raceSpinner.getSelectedItemPosition()).toString());
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


}
