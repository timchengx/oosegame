package com.oose.prototype;

import java.io.Serializable;

import android.graphics.Bitmap;

abstract public class GameState implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8642239316987428479L;
	public static final int playerOne = 1;
	public static final int playerTwo = 2;
	private int whoMoving;
	private String playerOneName;
	private String playerTwoName;
	private SerializableBitmap playerOnePic;
	private SerializableBitmap playerTwoPic;
	private int playerOneFallbackCount;
	private int playerTwoFallbackCount;
	private int fallbackValue;

	public GameState(String pOne, String pTwo, Bitmap pOnePic, Bitmap pTwoPic,
			int fallback) {
		this.playerOneName = pOne;
		this.playerTwoName = pTwo;
		this.playerOnePic = new SerializableBitmap(pOnePic);
		this.playerTwoPic = new SerializableBitmap(pTwoPic);
		this.playerOneFallbackCount = 0;
		this.playerTwoFallbackCount = 0;
		this.fallbackValue = fallback;
		this.whoMoving = GameState.playerOne;
	}

	public GameState(String pOne, String pTwo, Bitmap pOnePic, Bitmap pTwoPic,
			int fallback, int pOnefallback, int pTwofallback, int whoPlaying) {
		this(pOne, pTwo, pOnePic, pTwoPic, fallback);
		this.playerOneFallbackCount = pOnefallback;
		this.playerTwoFallbackCount = pTwofallback;
		this.whoMoving = whoPlaying;
	}

	public String getPlayerOneName() {
		return playerOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public Bitmap getPlayerOnePic() {
		return playerOnePic.getImage();
	}

	public Bitmap getPlayerTwoPic() {
		return playerTwoPic.getImage();
	}

	public int whosTurn() {
		return whoMoving;
	}

	public void changeTurn() {
		if (whoMoving == playerOne)
			whoMoving = GameState.playerTwo;
		else
			whoMoving = GameState.playerOne;
	}
	protected boolean canFallback() {
		switch(whoMoving) {
		case GameState.playerOne:
			if(playerOneFallbackCount < fallbackValue) {
				playerOneFallbackCount++;
				return true;
			}
			break;
		case GameState.playerTwo:
			if(playerTwoFallbackCount < fallbackValue) {
				playerOneFallbackCount++;
				return true;
			}
			break;
		default:
			return false;
		}
		return false;
	}
}
