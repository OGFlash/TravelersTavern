package com.wildlab.travelerstavern;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wildlab.travelerstavern.fragments.CharacterFragment;
import com.wildlab.travelerstavern.fragments.DiceFragment;
import com.wildlab.travelerstavern.fragments.EquipmentFragment;
import com.wildlab.travelerstavern.fragments.SkillsFragment;
import com.wildlab.travelerstavern.fragments.SpellsFragment;

/**
 * @author Andrew King
 * @author Prad Ejner
 * @since 9/15/2017.
 */

public class DnDActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private BottomNavigationView navigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener;

    private CharacterFragment characterFragment;
    private SkillsFragment skillsFragment;
    private SpellsFragment spellsFragment;
    private EquipmentFragment equipmentFragment;
    private DiceFragment diceFragment;


    @Override
    protected void onCreate(Bundle saveInstantstate) {
        super.onCreate(saveInstantstate);
        setContentView(R.layout.dnd_activity);

        characterFragment = new CharacterFragment();
        skillsFragment = new SkillsFragment();
        spellsFragment = new SpellsFragment();
        equipmentFragment = new EquipmentFragment();
        diceFragment = new DiceFragment();


        Bundle currentBundle = getIntent().getExtras();
        String stringName = (String) currentBundle.get("name");
        String stringClass = (String)currentBundle.get("className");
        Integer stringLevel = (Integer) currentBundle.get("level");
        Integer str = (Integer) currentBundle.get("str");
        Integer dex = (Integer) currentBundle.get("dex");
        Integer con = (Integer) currentBundle.get("con");
        Integer intel = (Integer) currentBundle.get("int");
        Integer wis = (Integer) currentBundle.get("wis");
        Integer cha = (Integer) currentBundle.get("cha");
        Integer ac = (Integer) currentBundle.get("ac");
        Integer health = (Integer) currentBundle.get("health");
        Integer speed = (Integer) currentBundle.get("speed");
        String id = (String) currentBundle.get("id");

        Log.e("** health()", health.toString());
        Log.e("** speed()", speed.toString());
        Log.e("** stringSTR()", str.toString());
        Log.e("** dex()", dex.toString());
        Log.e("** con()", con.toString());
        Log.e("** intel()", intel.toString());
        Log.e("** wis()", wis.toString());
        Log.e("** cha()", cha.toString());
        Log.e("** ac()", ac.toString());
        Log.e("** id()", id.toString());

        Bundle bundleSkills = new Bundle();
        bundleSkills.putString("name", stringName);
        bundleSkills.putString("className", stringClass);
        bundleSkills.putInt("level", stringLevel);
        bundleSkills.putInt("str", str);
        bundleSkills.putInt("dex", dex);
        bundleSkills.putInt("con", con);
        bundleSkills.putInt("int", intel);
        bundleSkills.putInt("wis", wis);
        bundleSkills.putInt("cha", cha);
        bundleSkills.putInt("health", health);
        bundleSkills.putInt("ac", ac);
        bundleSkills.putInt("speed", speed);
        bundleSkills.putInt("id", Integer.valueOf(id));
        skillsFragment.setArguments(bundleSkills);



        toolBar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);

        setSupportActionBar(toolBar);

        if (toolBar != null) {
            getSupportActionBar().setTitle("Travelers Tavern");
            toolBar.setSubtitle(stringName + "  " + stringClass + "  " + stringLevel);
        }

        setListeners();
        navigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);
        if(characterFragment != null) {
            openFragment(characterFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.top_settings_main_menu:
                msg = "Main Menu";
                break;
            case R.id.top_settings_share:
                msg = "Share!";
                Intent intentDD = new Intent(getApplicationContext(), CharacterInfoActivity.class);
                startActivity(intentDD);
                break;
            case R.id.top_settings_settings:
                msg = "Settings!";
                break;
            default:
                msg = "Not Found";
                break;
        }
        Toast.makeText(this, msg + " Clicked!", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void setListeners() {
        navItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return false;
            }
        };
    }

    private void selectFragment(MenuItem item) {
        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navigation_character:
                openFragment(characterFragment);
                break;
            case R.id.navigation_skills:
                openFragment(skillsFragment);
                break;
            case R.id.navigation_spells:
                openFragment(spellsFragment);
                break;
            case R.id.navigation_equipment:
                openFragment(equipmentFragment);
                break;
            case R.id.navigation_dice:
                openFragment(diceFragment);
                break;
            default:
                break;
        }
    }

    private void openFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.tabs_root_id, fragment);
                ft.commit();
            }
        }

    }
}
