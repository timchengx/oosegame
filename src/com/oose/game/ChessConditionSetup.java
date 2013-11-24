package com.oose.game;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
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
	private final String hasPictureData = "hPD";
	private final String chessType = "ChessType";
	private final String pOneNameText = "p1name";
	private final String pTwoNameText = "p2name";
	private final String pOneBitmap = "p1pic";
	private final String pTwoBitmap = "p2pic";
	private final String timeLimit = "tl";
	private final String limitSwitch = "ls";
	private int timeValue;
	private boolean timeLimitSwitch;
	private PictureData pictureSave = null;
	private int currentChess;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);

		setContentView(R.layout.chess_condition_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		currentChess = intent.getIntExtra(chessType, errorCode);
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
			intent.putExtra(hasPictureData, false);
		else {
			intent.putExtra(hasPictureData, true);
			intent.putExtra(pOneNameText, pictureSave.getPlayerOneName());
			intent.putExtra(pTwoNameText, pictureSave.getPlayerTwoName());
			intent.putExtra(pOneBitmap, pictureSave.getPlayerOnePicture());
			intent.putExtra(pTwoBitmap, pictureSave.getPlayerTwoPicture());
		}
		startActivityForResult(intent, pictureResultCode);
	}
	public void timeSetup(View view) {
		Intent intent = new Intent(this, TimeSetup.class);
		intent.putExtra(limitSwitch, timeLimitSwitch);
		intent.putExtra(timeLimit, timeValue);
		startActivityForResult(intent, timeResultCode);
	}
	public void startGame(View view) {
		if(currentChess == chineseChess);
		else;
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
		case pictureResultCode:
			if(pictureSave == null)
				pictureSave = new PictureData();
			pictureSave.setPlayerOneName(data.getStringExtra(pOneNameText));
			pictureSave.setPlayerTwoName(data.getStringExtra(pTwoNameText));
			pictureSave.setPlayerOnePicture((Bitmap)data.getParcelableExtra(pOneBitmap));
			pictureSave.setPlayerTwoPicture((Bitmap)data.getParcelableExtra(pTwoBitmap));
			break;
		case timeResultCode:
			timeValue = data.getIntExtra(timeLimit, 30);
			timeLimitSwitch = data.getBooleanExtra(limitSwitch, true);
			break;
		default:
			break;
		}
	}
}
