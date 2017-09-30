package com.wildlab.travelerstavern.utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wildlab.travelerstavern.DAndDActivity;
import com.wildlab.travelerstavern.R;

/**
 * @author ogflash
 * @since 9/15/2017.
 */

public class ActionToolBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstantstate){
        super.onCreate(saveInstantstate);
        setContentView(R.layout.activity_toolbar);
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        getSupportActionBar().setTitle("Action Bar ToolBar");
        mToolBar.setSubtitle("By Andrew Michael King");

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
                Intent intentDD = new Intent(getApplicationContext(), DAndDActivity.class);
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
}
