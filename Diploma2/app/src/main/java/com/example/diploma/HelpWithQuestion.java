package com.example.diploma;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HelpWithQuestion extends MainActivity {
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_with_question);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Допомога з питанням");
        super.openMenu();
        final TextView textView = (TextView) findViewById(R.id.text);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/regular.otf");
        textView.setTypeface(type);
        textView.setTextSize(21);
        textView.setTextColor(getResources().getColor(R.color.black));
        final RadioGroup gr = (RadioGroup)findViewById(R.id.radios);
        Button btn = (Button) findViewById(R.id.approve);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpWithQuestion.this, "Дякуємо за допомогу!", Toast.LENGTH_SHORT).show();
                textView.setText(R.string.error);
                gr.clearCheck();
            }
        });
        int textColor = Color.parseColor("#FFFFFF");
        btn.setTextColor(textColor);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
