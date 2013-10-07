package com.oose.game;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class StartMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	DrawChess drawChess = new DrawChess(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        setContentView(drawChess);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_menu, menu);
        return true;
    }
    
}
