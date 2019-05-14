package com.example.diploma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Shedule extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedule);
        super.openMenu();
        super.toolBar();
    }
}
