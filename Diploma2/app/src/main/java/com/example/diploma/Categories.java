package com.example.diploma;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.clans.fab.FloatingActionButton;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Categories extends MainActivity implements AdapterView.OnItemClickListener{

    private static final String TAG = "1";
    public DrawerLayout dl;
    public ActionBarDrawerToggle abdt;
    AutoCompleteTextView atv;
    ArrayList<String> trash = new ArrayList<String> ();
    ArrayList<String> allWaste = new ArrayList<String>();
    HashMap<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
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
        atv = findViewById(R.id.atv);
        if(atv.hasFocus()){
            hideSoftKeyboard();
        }
        dictionary.put("пластик", new ArrayList<String>(Arrays.asList("pet","hdpe", "ldpe", "pp", "ps", "pvc", "пластикова пляшка", "кульок", "пакет", "кришечка" )));
        dictionary.put("папір", new ArrayList<String>(Arrays.asList("картон", "гофрований картон", "пап’є маше", "папір", "зошит", " папір А4" )));
        allWaste.addAll(dictionary.get("пластик"));
        allWaste.addAll(dictionary.get("папір"));
        atv.setAdapter(new ArrayAdapter<String>(Categories.this,android.R.layout.simple_list_item_1,  allWaste));
        atv.setOnItemClickListener(this);

        if(atv.hasFocus()){
            hideSoftKeyboard();
        }

    }

    private void hideSoftKeyboard() {
        if(getCurrentFocus()!=null && getCurrentFocus() instanceof EditText)
        {
            InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
        }

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String item = parent.getItemAtPosition(position).toString();
        for (Map.Entry<String, ArrayList<String>> entry : dictionary.entrySet()) {
            if (entry.getValue().equals(item)) {
                Toast.makeText(Categories.this, "Selected Item is: \t" + item, Toast.LENGTH_LONG).show();
            }
        }
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
            super.onBackPressed();
    }

}
