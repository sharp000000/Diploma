package com.example.diploma;

import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class Clothes extends MainActivity {
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        super.toolBar();
        getSupportActionBar().setTitle("Одяг та взуття");
        TextView textView = (TextView) findViewById(R.id.clothestext);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/aller.ttf");
        textView.setTypeface(type);
        textView.setTextSize(17);
        super.openMenu();
        final Button btnLaska = (Button) findViewById(R.id.textLaska);
        btnLaska.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linkToLaska(v);
            }
        });
        final Button btnRedCross = (Button) findViewById(R.id.textLaska);
        btnRedCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linkToRedCross(v);
            }
        });

    }

    public void linkToLaska(View view){
        Intent laskaIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://laskastore.com/contacts/"));
        startActivity(laskaIntent);
    }
    public void linkToRedCross(View view){
        Intent redCrossIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://redcross.org.ua/ru/"));
        startActivity(redCrossIntent);
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
