package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartMenu extends Activity {

	private final int chineseChess = 0;
	private final int darkChess = 1;
	private final int errorCode = -1;
	private final String chessType = "ChessType";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu);
    }
    public void newChess(View view) {
    	Intent intent = new Intent(this, ChessMainMenu.class);
    	if(view.getId() == R.id.ButtonStartChineseChess)
    		intent.putExtra(chessType, chineseChess);
    	else
    		intent.putExtra(chessType, darkChess);
    	startActivity(intent);
    }
}
