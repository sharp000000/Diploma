package com.example.diploma;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.lang.reflect.Type;

public class Clothes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Одяг та взуття");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView;
        textView = (TextView) findViewById(R.id.clothestext);
        Typeface customfont = Typeface.createFromAsset(this.getAssets(),"fonts/aller.ttf");
        textView.setTypeface(customfont);
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
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
