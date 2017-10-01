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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wildlab.travelerstavern.utils.SkillsFragment;

/**
 * @author Andrew King
 * @author Prad Ejner
 * @since 9/15/2017.
 */

public class DAndDActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private BottomNavigationView navigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener;

    @Override
    protected void onCreate(Bundle saveInstantstate) {
        super.onCreate(saveInstantstate);
        setContentView(R.layout.dnd_activity);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);

        setSupportActionBar(toolBar);

        if (toolBar != null) {
            getSupportActionBar().setTitle("Travelers Tavern");
            toolBar.setSubtitle("Name: ___________");
        }

        setListeners();
        navigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);
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
                break;
            case R.id.navigation_skills:
                openFragment(new SkillsFragment());
                break;
            case R.id.navigation_spells:
                break;
            case R.id.navigation_equipment:
                break;
            case R.id.navigation_dice:
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
