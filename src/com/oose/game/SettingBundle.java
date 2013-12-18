package com.oose.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SettingBundle {
	private String playerOneName;
	private String playerTwoName;
	private Bitmap playerOnePicture;
	private Bitmap playerTwoPicture;
	private int timeValue;
	private boolean timeLimit;

	public SettingBundle() {
		this.playerOneName = "PlayerOne";
		this.playerTwoName = "PlayerTwo";
		this.playerOnePicture = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.ic_launcher);
		this.playerTwoPicture = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.ic_launcher);
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
