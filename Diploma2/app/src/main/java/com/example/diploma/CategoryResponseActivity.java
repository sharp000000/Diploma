package com.example.diploma;

import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import org.xmlpull.v1.XmlPullParser;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.net.URI;

public class CategoryResponseActivity extends MainActivity {
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    public String Name;
    public CategoryResponseActivity(){}
    public CategoryResponseActivity(String name)
    {
        this.Name = name;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_response);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        XmlPullParser xpp = getResources().getXml(R.xml.categoriesinfo);
        CategoriesParser parser = new CategoriesParser();
        TextView textView = (TextView) findViewById(R.id.categorytext);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/aller.ttf");
        textView.setTypeface(type);
        textView.setTextSize(17);
        super.openMenu();
        ImageView img = (ImageView) findViewById(R.id.imageview);
        Bundle arguments = getIntent().getExtras();
        Name = arguments.get("1").toString();

            if(parser.parse(xpp))
        {
            for(AllCategories prod: parser.getCategories()){
                if(prod.getName().equals(Name)) {
                    textView.setText(prod.getInfo());
                    switch(prod.getName()){
                        case "Пластик" :
                            img.setImageResource(R.drawable.plastic);
                            break;
                        case "Папір" :
                            img.setImageResource(R.drawable.paper);
                            break;
                        case "Метал" :
                            img.setImageResource(R.drawable.metal);
                            break;
                        case "Скло" :
                            img.setImageResource(R.drawable.glass);
                            break;
                        case "Деревина" :
                            img.setImageResource(R.drawable.wood);
                            break;
                        case "Електроніка" :
                            img.setImageResource(R.drawable.electronic);
                            break;
                        case "На спалювання" :
                            img.setImageResource(R.drawable.burn);
                            break;
                    }
                }
            }
        }
        getSupportActionBar().setTitle(Name);
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

    @Override
    public void onBackPressed() {

        if (dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
