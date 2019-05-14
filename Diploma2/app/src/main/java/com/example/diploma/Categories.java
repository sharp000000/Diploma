package com.example.diploma;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.clans.fab.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SearchView;
import android.widget.Button;
import android.widget.ScrollView;
import android.view.Menu;
import android.view.MenuItem;


public class Categories extends MainActivity {
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    SearchView searchView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        super.toolBar();
        super.openMenu();
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollview);
        final FloatingActionsMenu fAM = (FloatingActionsMenu) findViewById(R.id.fab);
        FloatingActionButton bot = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fabchat);
        bot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBot();
                fAM.collapse();
            }
        });
        FloatingActionButton camera = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fabphoto);
        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCamera();
                fAM.collapse();
            }
        });
        final Button plastic = (Button) findViewById(R.id.plastic);
        plastic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(plastic.getText().toString());

            }
        });
        final Button paper = (Button) findViewById(R.id.paper);
        paper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(paper.getText().toString());
            }
        });
        final Button metal = (Button) findViewById(R.id.metal);
        metal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(metal.getText().toString());
            }
        });
        final Button glass = (Button) findViewById(R.id.glass);
        glass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(glass.getText().toString());
            }
        });
        final Button wood = (Button) findViewById(R.id.wood);
        wood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(wood.getText().toString());
            }
        });
        Button clothes = (Button) findViewById(R.id.clothes);
        clothes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openClothes();
            }
        });
        final Button electronic = (Button) findViewById(R.id.electronic);
        electronic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(electronic.getText().toString());
            }
        });
        final Button burn = (Button) findViewById(R.id.burn);
        burn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(burn.getText().toString());
            }
        });
        final Button nottaken = (Button) findViewById(R.id.nottaken);
        nottaken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCategories(nottaken.getText().toString());
            }
        });

    }

    public void openCamera(){
        Intent intent = new Intent(this,CameraActivity.class);
        startActivity(intent);
    }
    public void openCategories(String name){
        Intent intent = new Intent(this, CategoryResponseActivity.class);
        intent.putExtra("1", name);
        startActivity(intent);
    }
    public void openClothes(){
        Intent intent = new Intent(this, Clothes.class);
        startActivity(intent);
    }
    public void openBot(){
        Intent intent = new Intent(this, MainActivityBot.class);
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
    @Override
    public void onBackPressed() {

        if (dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
