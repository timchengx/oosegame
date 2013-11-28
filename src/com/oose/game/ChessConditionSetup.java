package com.oose.game;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ChessConditionSetup extends Activity {
	
	private int currentChess;
	
	private int timeValue;
	private boolean timeLimit;
	
	private PictureData pictureSave;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		pictureSave = null;
		timeValue = KEYINDEX.DEFAULTIMELIMIT;
		timeLimit = KEYINDEX.DEFAULTTIMELIMITSWITCH;
		setContentView(R.layout.chess_condition_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		currentChess = intent.getIntExtra(KEYINDEX.CHESSTYPE_INT, KEYINDEX.ERROR);
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
		if(pictureSave == null)
			intent.putExtra(KEYINDEX.INTENT_HAS_ICON_BOOLEAN, false);
		else {
			intent.putExtra(KEYINDEX.INTENT_HAS_ICON_BOOLEAN, true);
			intent.putExtra(KEYINDEX.PLAYER1NAME_STRING, pictureSave.getPlayerOneName());
			intent.putExtra(KEYINDEX.PLAYER2NAME_STRING, pictureSave.getPlayerTwoName());
			intent.putExtra(KEYINDEX.PLAYER1ICON_BITMAP, pictureSave.getPlayerOnePicture());
			intent.putExtra(KEYINDEX.PLAYER2ICON_BITMAP, pictureSave.getPlayerTwoPicture());
		}
		startActivityForResult(intent, KEYINDEX.PICTURERESULTCODE);
	}
	public void timeSetup(View view) {
		Intent intent = new Intent(this, TimeSetup.class);
		intent.putExtra(KEYINDEX.LIMITSWITCH_BOOLEAN, timeLimit);
		intent.putExtra(KEYINDEX.TIMELIMIT_INT, timeValue);
		startActivityForResult(intent, KEYINDEX.TIMERESULTCODE);
	}
	public void startGame(View view) {
		if(currentChess == KEYINDEX.CHINESECHESS) {
			startActivity(new Intent(this, ChineseChessGame.class));
		
		finish();
		onStop();}
		else; //KEYINDEX.DARKCHESS
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
		case KEYINDEX.PICTURERESULTCODE:
			if(pictureSave == null)
				pictureSave = new PictureData();
			pictureSave.setPlayerOneName(data.getStringExtra(KEYINDEX.PLAYER1NAME_STRING));
			pictureSave.setPlayerTwoName(data.getStringExtra(KEYINDEX.PLAYER2NAME_STRING));
			pictureSave.setPlayerOnePicture((Bitmap)data.getParcelableExtra(KEYINDEX.PLAYER1ICON_BITMAP));
			pictureSave.setPlayerTwoPicture((Bitmap)data.getParcelableExtra(KEYINDEX.PLAYER2ICON_BITMAP));
			break;
		case KEYINDEX.TIMERESULTCODE:
			timeValue = data.getIntExtra(KEYINDEX.TIMELIMIT_INT, KEYINDEX.DEFAULTIMELIMIT);
			timeLimit = data.getBooleanExtra(KEYINDEX.LIMITSWITCH_BOOLEAN, true);
			break;
		default:
			break;
		}
	}
}
