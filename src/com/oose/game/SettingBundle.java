package com.oose.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* 
 * Chess game setting are too many options, hence
 * so we packed these setting into this class
 */
public class SettingBundle {

	public static final String DEFAULT_PLAYERONE_NAME = "PlayerOne";
	public static final String DEFAULT_PLAYERTWO_NAME = "PlayerTwo";
	public static final Bitmap DEFAULT_PLAYERONE_BITMAP = BitmapFactory
			.decodeResource(OOSEGame.getRes(), R.drawable.ic_launcher);
	public static final Bitmap DEFAULT_PLAYERTWO_BITMAP = DEFAULT_PLAYERONE_BITMAP;

	private String playerOneName; // player one's name
	private String playerTwoName; // player two's name
	private Bitmap playerOnePicture; // player one's picture
	private Bitmap playerTwoPicture; // player two's picture
	private int timeValue; // game's time limit value
	private boolean timeLimit; // enable time limit or not

	public SettingBundle() {
		this.playerOneName = DEFAULT_PLAYERONE_NAME;
		this.playerTwoName = DEFAULT_PLAYERTWO_NAME;
		this.playerOnePicture = DEFAULT_PLAYERONE_BITMAP;
		this.playerTwoPicture = DEFAULT_PLAYERTWO_BITMAP;
		this.timeValue = ChessSetup.DEFAULTFALLBACKVALUE;
		this.timeLimit = ChessSetup.DEFAULTTIMELIMITSWITCH;
	}

	public String getPlayerOneName() {
		return playerOneName;
	}

	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public Bitmap getPlayerOnePicture() {
		return playerOnePicture;
	}

	public void setPlayerOnePicture(Bitmap playerOnePicture) {
		this.playerOnePicture = playerOnePicture;
	}

	public Bitmap getPlayerTwoPicture() {
		return playerTwoPicture;
	}

	public void setPlayerTwoPicture(Bitmap playerTwoPicture) {
		this.playerTwoPicture = playerTwoPicture;
	}

	public void setTimeLimitValue(int time) {
		timeValue = time;
	}

	public int getTimeLimitValue() {
		return timeValue;
	}

	public void setTimeLimitSwitch(boolean onOff) {
		timeLimit = onOff;
	}

	public boolean isTimeLimitOn() {
		return timeLimit;
	}
}
