package com.wildlab.travelerstavern;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wildlab.travelerstavern.utils.BuildFragment;
import com.wildlab.travelerstavern.utils.Character;
import com.wildlab.travelerstavern.utils.CharacterAdapter;
import com.wildlab.travelerstavern.utils.CreateFragment;
import com.wildlab.travelerstavern.utils.DescribeFragment;
import com.wildlab.travelerstavern.utils.SectionsPageAdapter;

import java.util.ArrayList;

/**
 * @author ogflash
 * @since 9/15/2017.
 */

public class DAndDActivity extends AppCompatActivity implements CharacterAdapter.IUpdateButtonClicks {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;
    private String nameLocal = "";
    private String levelLocal = "";
    private String classLocal = "";
    private CharacterAdapter characterAdapter;
    private ArrayList<Character> characters;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle saveInstantstate) {
        super.onCreate(saveInstantstate);
        setContentView(R.layout.dd_main_content);
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        if(mToolBar != null) {
            getSupportActionBar().setTitle("Dungeon Wizard");
            mToolBar.setSubtitle("Create Your Champion");
        }

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        characters = new ArrayList<Character>();
        characterAdapter = new CharacterAdapter(this, characters);
        recyclerView = (RecyclerView) findViewById(R.id.listViewCharacters);
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
            case R.id.dnd_home:
                showChangeLangDialog();
                msg = "Save!";
                break;
            case R.id.save_menu:
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

    private void setUpViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BuildFragment(), "Build");
        adapter.addFragment(new CreateFragment(), "Create");
        adapter.addFragment(new DescribeFragment(), "Describe");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClickButton() {
//        showChangeLangDialog();
    }

    public Character showChangeLangDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog_edit, null);
        dialogBuilder.setView(dialogView);

        final EditText edtName = (EditText) dialogView.findViewById(R.id.character_name_edit);
        final EditText edtLevel = (EditText) dialogView.findViewById(R.id.character_level_edit);
        final EditText edtClass = (EditText) dialogView.findViewById(R.id.character_class_edit);


        dialogBuilder.setTitle("Add Character");
        dialogBuilder.setMessage("Edit Fields Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                if(edtName != null && edtLevel != null  && edtClass != null ){
                    if(edtName.getText().toString().equals("") || edtLevel.getText().toString().equals("") || edtClass.getText().toString().equals("")){
                        nameLocal = edtName.getText().toString();
                        levelLocal = edtLevel.getText().toString();
                        classLocal = edtClass.getText().toString();

                        //TODO SOMEHOW UPDATE LIST?
                    }
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();

        return new Character(nameLocal, levelLocal, classLocal);
    }

}
