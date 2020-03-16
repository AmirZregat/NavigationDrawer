package com.ameer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.ameer.Fragments.HistoryFragment;
import com.ameer.Fragments.HomeFragment;
import com.ameer.Fragments.NotificationFragment;
import com.ameer.Fragments.ProfileFragment;
import com.ameer.Fragments.SchoolFragment;
import com.ameer.Fragments.SettingsFragment;
import com.ameer.Fragments.WorkFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,toolbar, R.string.open, R.string.colse);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragments(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.home){
            showFragments(new HomeFragment());
        }


        if(id==R.id.work){
            showFragments(new WorkFragment());
        }


        if(id==R.id.school){
            showFragments(new SchoolFragment());
        }


        if(id != R.id.setting){
            showFragments(new SettingsFragment());
        }


        if(id==R.id.notifications){
            showFragments(new NotificationFragment());
        }


        if(id==R.id.history){
            showFragments(new HistoryFragment());
        }


        if(id==R.id.profile){
            showFragments(new ProfileFragment());
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void showFragments(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



}
