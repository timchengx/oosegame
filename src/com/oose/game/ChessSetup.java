package com.oose.game;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ChessSetup extends Activity {
	
	public final static String TIMELIMIT_INT = "tl";
	public final static String LIMITSWITCH_BOOLEAN = "LS";
	public final static String PLAYER1NAME_STRING = "P1N";
	public final static String PLAYER2NAME_STRING = "P2N";
	public final static String PLAYER1ICON_BITMAP = "P1I";
	public final static String PLAYER2ICON_BITMAP = "P2I";
	public final static String INTENT_HAS_ICON_BOOLEAN = "IHI";
	public final static int PICTURERESULTCODE = 1100;
	public final static int TIMERESULTCODE = 1200;
	public final static int CAMERAREQUESTCODE = 2100;
	public final static int FROMFILEREQUESTCODE = 2200;
	public final static int DEFAULTIMELIMIT = 30;
	public final static int DEFAULTTIMELIMIT_MAX = 90;
	public final static int DEFAULTTIMELIMIT_MIN = 30;
	public final static boolean DEFAULTTIMELIMITSWITCH = true;
	public final static int DEFAULTFALLBACKVALUE = 3;
	
	private int currentChess;
	
	private SettingBundle setup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		setup = new SettingBundle();
		setContentView(R.layout.chess_condition_setup);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		currentChess = intent.getIntExtra(ChessMainMenu.CHESSTYPE_INT, ChessMainMenu.ERROR);
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		//switch(item.getItemId()) {
		//case android.R.id.home:
			finish();
		return true;
	}
	public void pictureSetup(View view) {
		Intent intent = new Intent(this, ProfileSetup.class);
//		if(pictureSave == null)
//			intent.putExtra(KEYINDEX.INTENT_HAS_ICON_BOOLEAN, false);
//		else {
			intent.putExtra(INTENT_HAS_ICON_BOOLEAN, true);
			intent.putExtra(PLAYER1NAME_STRING, setup.getPlayerOneName());
			intent.putExtra(PLAYER2NAME_STRING, setup.getPlayerTwoName());
			intent.putExtra(PLAYER1ICON_BITMAP, setup.getPlayerOnePicture());
			intent.putExtra(PLAYER2ICON_BITMAP, setup.getPlayerTwoPicture());
//		}
		startActivityForResult(intent, PICTURERESULTCODE);
	}
	public void timeSetup(View view) {
		Intent intent = new Intent(this, TimeSetup.class);
		intent.putExtra(LIMITSWITCH_BOOLEAN, setup.isTimeLimitOn());
		intent.putExtra(TIMELIMIT_INT, setup.getTimeLimitValue());
		startActivityForResult(intent, TIMERESULTCODE);
	}
	public void startGame(View view) {
		Intent intent = new Intent();
		intent.putExtra(PLAYER1NAME_STRING, setup.getPlayerOneName());
		intent.putExtra(PLAYER2NAME_STRING, setup.getPlayerTwoName());
		intent.putExtra(PLAYER1ICON_BITMAP, setup.getPlayerOnePicture());
		intent.putExtra(PLAYER2ICON_BITMAP, setup.getPlayerTwoPicture());
		intent.putExtra(TIMELIMIT_INT, setup.getTimeLimitValue());
		intent.putExtra(LIMITSWITCH_BOOLEAN, setup.isTimeLimitOn());
		if(currentChess == ChessMainMenu.CHINESECHESS)
			intent.setClass(this, ChineseChessMain.class);
		else	// start dark chess
			intent.setClass(this, DarkChessMain.class);
		
		startActivity(intent);
		finish();
		onStop();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
		case PICTURERESULTCODE:
			setup.setPlayerOneName(data.getStringExtra(PLAYER1NAME_STRING));
			setup.setPlayerTwoName(data.getStringExtra(PLAYER2NAME_STRING));
			setup.setPlayerOnePicture((Bitmap)data.getParcelableExtra(PLAYER1ICON_BITMAP));
			setup.setPlayerTwoPicture((Bitmap)data.getParcelableExtra(PLAYER2ICON_BITMAP));
			break;
		case TIMERESULTCODE:
			setup.setTimeLimitValue(data.getIntExtra(TIMELIMIT_INT, DEFAULTIMELIMIT));
			setup.setTimeLimitSwitch(data.getBooleanExtra(LIMITSWITCH_BOOLEAN, true));
			break;
		default:
			break;
		}
	}
}
