package com.wildlab.travelerstavern;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.wildlab.travelerstavern.utils.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Owner on 9/26/2017.
 */

public class CharacterInfoActivity extends AppCompatActivity{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listHeaderData;
    private HashMap<String, List<String>> listHash;



    @Override
    protected void onCreate(Bundle saveInstantState) {
        super.onCreate(saveInstantState);
        setContentView(R.layout.character_info_main_content);

        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        if(mToolBar != null) {
            getSupportActionBar().setTitle("Character Info");
            mToolBar.setSubtitle("Update Stats");
        }


        listView = (ExpandableListView)findViewById(R.id.expandable_list_view);
        initData();
        listAdapter = new ExpandableListAdapter(this, listHeaderData, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listHeaderData = new ArrayList<>();
        listHash = new HashMap<>();


        listHeaderData.add("Stats");
        listHeaderData.add("Class");
        listHeaderData.add("Abilities");
        listHeaderData.add("Inventory");
        listHeaderData.add("Background");


        List<String> statsList = new ArrayList<>();
        statsList.add("Strength");
        statsList.add("Intelligence");
        statsList.add("Wisdom");
        statsList.add("Dexterity");
        statsList.add("Constitution");

        List<String> classList = new ArrayList<>();
        classList.add("Bard");
        classList.add("Warlock");
        classList.add("Fighter");
        classList.add("Warrior");
        classList.add("God");

        List<String> abilitesList = new ArrayList<>();
        abilitesList.add("Boom");
        abilitesList.add("Fire Ball");
        abilitesList.add("Frost Bolt");
        abilitesList.add("Healing Beam");
        abilitesList.add("Plasma Cannon");

        List<String> InventoryList = new ArrayList<>();
        InventoryList.add("100 gold");

        List<String> backgroundList = new ArrayList<>();
        backgroundList.add("Place of Birth");
        backgroundList.add("Character Description");
        backgroundList.add("Motivations");
        backgroundList.add("Quirks");

        listHash.put(listHeaderData.get(0), statsList);
        listHash.put(listHeaderData.get(1), classList);
        listHash.put(listHeaderData.get(2), abilitesList);
        listHash.put(listHeaderData.get(3), InventoryList);
        listHash.put(listHeaderData.get(4), backgroundList);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                if(i == 0 && i1 == 0){
                    showStrDialog();
                }
                return false;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()){
            case R.id.save_menu:
                msg = "Save!";
                break;
            case R.id.settings_menu:
                msg = "Settings!";
                Intent intentDD = new Intent(getApplicationContext(), DAndDActivity.class);
                startActivity(intentDD);
                break;
            case R.id.message_menu:
                msg = "message!";
                break;
            case R.id.share_menu:
                msg = "share!";
                break;
            case R.id.nav_share:
                msg = "nav share!";
                break;
            case R.id.nav_send:
                msg = "nav send!";
                break;
            case R.id.communication_menu:
                msg = "Communication";
                break;
            default:
                msg = "Not Found";
                break;
        }
        Toast.makeText(this, msg + "Clicked !", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    public void showStrDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog_str, null);
        dialogBuilder.setView(dialogView);

        final EditText edtStr = (EditText) dialogView.findViewById(R.id.character_str);


        dialogBuilder.setTitle("Update Strength");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //TODO CHANGE EXPANDABLE LSITVIEW TO TAKE VIEWS AND ADD A TEXT VIEW FOR THE TOTAL
//                edtStr.getText().toString();
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
