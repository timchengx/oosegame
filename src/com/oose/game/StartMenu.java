package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu);
    }
    public void newChess(View view) {
    	Intent intent = new Intent(this, ChessMainMenu.class);
    	if(view.getId() == R.id.ButtonStartChineseChess)
    		intent.putExtra(ChessMainMenu.CHESSTYPE_INT, ChessMainMenu.CHINESECHESS);
    	else		//ButtonStartDarkChess
    		intent.putExtra(ChessMainMenu.CHESSTYPE_INT, ChessMainMenu.DARKCHESS);
    	startActivity(intent);
    	onStop();
    }
}
