package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class ChessMainMenu extends Activity {
	public static final String CHESSTYPE_INT = "CT";
	public static final int CHINESECHESS = 0;
	public static final int DARKCHESS = 1;
	public static int ERROR = -1;

	private int currentChess;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chess_main_menu);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		currentChess = intent.getIntExtra(ChessMainMenu.CHESSTYPE_INT, ERROR);
		if(currentChess == ChessMainMenu.CHINESECHESS)
			getActionBar().setTitle(R.string.chinesechess);
		else	//KEYINDEX.DARKCHESS
			getActionBar().setTitle(R.string.darkchess);
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		//switch(item.getItemId()) {
		//case android.R.id.home:

			finish();
		//}
		return true;
	}
	

	
	public void selectGame(View view) {
		if(view.getId() == R.id.ButtonNewGame) {
			Intent intent = new Intent(this, ChessSetup.class);
			intent.putExtra(ChessMainMenu.CHESSTYPE_INT, currentChess);
			startActivity(intent);
		}
		else {
			//LoadGame
			Intent intent = new Intent(this, ChineseChessMain.class);
			intent.putExtra("kerker", true);
			startActivity(intent);
		}
		onStop();
	}
}
