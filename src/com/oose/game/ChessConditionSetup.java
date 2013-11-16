package com.oose.game;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class ChessConditionSetup extends Activity {
	private final int pictureResultCode = 0;
	private final int timeResultCode = 1;
	private final int chineseChess = 0;
	private final int darkChess = 1;
	private final int errorCode = -1;
	private final String chessType = "ChessType";
	
	private int currentChess;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);

		setContentView(R.layout.chess_condition_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		currentChess = intent.getIntExtra("ChessType", errorCode);
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		//switch(item.getItemId()) {
		//case android.R.id.home:
			finish();
		//}
		return true;
	}
	public void pictureSetup(View view) {
		Intent intent = new Intent(this, PictureSetup.class);
		startActivityForResult(intent, pictureResultCode);
	}
	public void timeSetup(View view) {
		Intent intent = new Intent(this, TimeSetup.class);
		startActivityForResult(intent, timeResultCode);
	}
	public void startGame(View view) {
		if(currentChess == chineseChess);
		else;
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
	}
}
