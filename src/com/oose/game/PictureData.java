package com.oose.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PictureData{
	private String playerOneName;
	private String playerTwoName;
	private Bitmap playerOnePicture;
	private Bitmap playerTwoPicture;
	/*
	public PictureData(String nOne, Bitmap pOne, String nTwo, Bitmap pTwo) {
		this.playerOneName = nOne;
		this.playerOnePicture = pOne;
		this.playerTwoName = nTwo;
		this.playerTwoPicture = pTwo;
	}
	*/
	public PictureData() {
		this.playerOneName = "PlayerOne";
		this.playerTwoName = "PlayerTwo";
		this.playerOnePicture = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.ic_launcher);
		this.playerTwoPicture = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.ic_launcher);
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
	public boolean hasPlayerOneImage() {
		if(this.playerOnePicture == null)
			return false;
		return true;
	}
	public boolean hasPlayerTwoImage() {
		if(this.playerTwoPicture == null)
			return false;
		return true;
	}
}
