package com.example.diploma;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Help extends MainActivity {
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Допомога проекту");
        TextView textView = (TextView) findViewById(R.id.helptext);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/regular.otf");
        textView.setTypeface(type);
        textView.setTextSize(17);
        textView.setTextColor(getResources().getColor(R.color.black));
        super.openMenu();
        final Button buttonQuestion = (Button) findViewById(R.id.question);
        buttonQuestion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHelpWithQuestion();
            }
        });
        final Button buttonImage = (Button) findViewById(R.id.image);
        buttonImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHelpWithImage();
            }
        });
    }
    public void openHelpWithQuestion(){
        Intent intent = new Intent(this, HelpWithQuestion.class);
        startActivity(intent);
    }
    public void openHelpWithImage(){
        Intent intent = new Intent(this, HelpWithImage.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
