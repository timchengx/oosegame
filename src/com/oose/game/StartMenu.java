package com.oose.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/* 
 * First Activity(Window)
 * let user Choose which game
 * that he(she) want to play
 */
public class StartMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_menu);
	}

	public void newChess(View view) {
		Intent intent = new Intent(this, ChessMainMenu.class);

		/* user choose to play Chinese Chess */
		if (view.getId() == R.id.ButtonStartChineseChess)
			intent.putExtra(ChessMainMenu.CHESSTYPE_INT,
					ChessMainMenu.CHINESECHESS);
		/* he(she) want to play Dark Chess */
		else
			intent.putExtra(ChessMainMenu.CHESSTYPE_INT,
					ChessMainMenu.DARKCHESS);

		startActivity(intent); // goto Chess Main Menu
		onStop();
	}
}
