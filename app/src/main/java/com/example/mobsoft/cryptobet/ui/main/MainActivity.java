package com.example.mobsoft.cryptobet.ui.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mobsoft.cryptobet.AnalyticsApplication;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.ui.about.AboutActivity;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView scoreText;
    private TextView betText;
    private SharedPreferences mPrefs;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final MainActivity mainActivity = this;
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Handle navigation view item clicks here.
                        int id = menuItem.getItemId();

                        if (id == R.id.nav_about) {
                            Intent intent = new Intent(mainActivity, AboutActivity.class);
                            startActivity(intent);
                        } else if (id == R.id.nav_cryptolist) {

                        }

                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });

        scoreText = (TextView) findViewById(R.id.toolbarScore);
        betText = (TextView) findViewById(R.id.toolbarBet);

    }

    public void addScore(int score){
        mPrefs = getSharedPreferences("score", 0);
        int stored_score = mPrefs.getInt("score", 0);
        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putInt("score", stored_score + score).commit();
        scoreText.setText(Integer.toString(stored_score) + " p");

        Log.i("mainActivity", "Setting screen name: MainActivity");
        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("add").build());
    }

    public void setBetText(int betNum){
        betText.setText(Integer.toString(betNum) + " bet");
        Log.i("mainActivity", "Setting screen name: MainActivity");
        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("set").build());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);

                return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
