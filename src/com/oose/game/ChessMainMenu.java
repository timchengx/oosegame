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


	private int currentChess;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chess_main_menu);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		currentChess = intent.getIntExtra(KEYINDEX.CHESSTYPE_INT, KEYINDEX.ERROR);
		if(currentChess == KEYINDEX.CHINESECHESS)
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
			intent.putExtra(KEYINDEX.CHESSTYPE_INT, currentChess);
			startActivity(intent);
		}
		else {
			//LoadGame
		}
		onStop();
	}
}
