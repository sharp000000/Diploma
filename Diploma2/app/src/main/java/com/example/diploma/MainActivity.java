package com.example.diploma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    SearchView searchView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void toolBar()
    {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void openMenu()
    {
        NavigationView nav_view = (NavigationView)findViewById(R.id.nav);
        View headerView = nav_view.getHeaderView(0);
        TextView navtext = (TextView) headerView.findViewById(R.id.navtext);
        navtext.setText("Збережи мене");
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.main)
                {
                    openMain();
                }
                else if (id==R.id.schedule)
                {
                    OpenShedule();
                }
                else if (id == R.id.help)
                {
                    OpenHelp();
                }
                else if(id ==R.id.faq)
                {
                    OpenFAQ();
                }

                return true;
            }
        });
    }
    public void openMain()
    {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }
    public void OpenHelp()
    {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
    public void OpenShedule()
    {
        Intent intent = new Intent(this, Shedule.class);
        startActivity(intent);
    }
    public void OpenFAQ()
    {
        Intent intent = new Intent(this, FAQ.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}
