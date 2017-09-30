package com.wildlab.travelerstavern;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @author Andrew King
 * @author Prad Ejner
 * @since 9/15/2017.
 */

public class DAndDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstantstate) {
        super.onCreate(saveInstantstate);

        setContentView(R.layout.dd_main_content);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        if(mToolBar != null) {
            getSupportActionBar().setTitle("Travelers Tavern");
            mToolBar.setSubtitle("Name: ___________");
        }
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
        getMenuInflater().inflate(R.menu.action_bar_settings, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()){
            case R.id.top_settings_main_menu:
                msg = "Save!";
                break;
            case R.id.top_settings_share:
                msg = "Settings!";
                Intent intentDD = new Intent(getApplicationContext(), CharacterInfoActivity.class);
                startActivity(intentDD);
                break;
            case R.id.top_settings_settings:
                msg = "message!";
                break;
            default:
                msg = "Not Found";
                break;
        }
        Toast.makeText(this, msg + "Clicked !", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_character:
                    return true;
                case R.id.navigation_skills:
                    return true;
                case R.id.navigation_spells:
                    return true;
                case R.id.navigation_equipment:
                    return true;
                case R.id.navigation_dice:
                    return true;
            }
            return false;
        }
    };
}
