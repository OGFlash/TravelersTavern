package com.wildlab.travelerstavern;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wildlab.travelerstavern.utils.BuildFragment;
import com.wildlab.travelerstavern.utils.CreateFragment;
import com.wildlab.travelerstavern.utils.DescribeFragment;
import com.wildlab.travelerstavern.utils.SectionsPageAdapter;

/**
 * @author ogflash
 * @since 9/15/2017.
 */

public class DAndDActivity extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;

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

    private void setUpViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BuildFragment(), "Build");
        adapter.addFragment(new CreateFragment(), "Create");
        adapter.addFragment(new DescribeFragment(), "Describe");
        viewPager.setAdapter(adapter);

    }
}
