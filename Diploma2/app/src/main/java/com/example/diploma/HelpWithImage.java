package com.example.diploma;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HelpWithImage extends MainActivity {
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_with_image);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Допомога з зображенням");
        super.openMenu();
        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final RadioGroup gr = (RadioGroup)findViewById(R.id.radios);
        Button btn = (Button) findViewById(R.id.approve);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpWithImage.this, "Дякуємо за допомогу! ", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.error);
                gr.clearCheck();
            }
        });
        int textColor = Color.parseColor("#FFFFFF");
        btn.setTextColor(textColor);
    }
    public void onRadioButtonClicked(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();
        /*TextView selection = (TextView) findViewById(R.id.selection);
        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.plastic:
                if (checked){
                    selection.setText("Выбран plastic");
                }
                break;
            case R.id.glass:
                if (checked){
                    selection.setText("Выбран glass");
                }
                break;
            case R.id.metal:
                if (checked){
                    selection.setText("Выбран metal");
                }
                break;
            case R.id.cardboard:
                if (checked){
                    selection.setText("Выбран cardboard");
                }
                break;
            case R.id.paper:
                if (checked){
                    selection.setText("Выбран paper");
                }
                break;
            case R.id.other:
                if (checked){
                    selection.setText("Выбран other");
                }
                break;
        }*/
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
