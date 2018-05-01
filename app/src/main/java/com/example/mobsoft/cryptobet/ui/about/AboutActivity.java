package com.example.mobsoft.cryptobet.ui.about;

import android.content.Intent;
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

import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.ui.main.MainActivity;

public class AboutActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_about);
        final AboutActivity aboutActivity = this;
        NavigationView navigationView = findViewById(R.id.nav_view_about);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Handle navigation view item clicks here.
                        int id = menuItem.getItemId();

                        if (id == R.id.nav_about) {

                        } else if (id == R.id.nav_cryptolist) {
                            Intent intent = new Intent(aboutActivity, MainActivity.class);
                            startActivity(intent);
                        }

                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_about);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });

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
