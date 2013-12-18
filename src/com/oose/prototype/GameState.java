package com.oose.prototype;

import java.io.Serializable;

import android.graphics.Bitmap;

abstract public class GameState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8642239316987428479L;
	public static final int playerOne = 1;
	public static final int playerTwo = 2;
	private int whoMoving;
	private String playerOneName;
	public int getPlayerOneFallbackCount() {
		return playerOneFallbackCount;
	}

	public int getPlayerTwoFallbackCount() {
		return playerTwoFallbackCount;
	}

	public int getFallbackValue() {
		return fallbackValue;
	}
	private String playerTwoName;
	private SerializableBitmap playerOnePic;
	private SerializableBitmap playerTwoPic;
	private int playerOneFallbackCount;
	private int playerTwoFallbackCount;
	private int fallbackValue;

	public GameState(String pOne, String pTwo, Bitmap pOnePic, Bitmap pTwoPic,
			int fallback, int pOnefallback, int pTwofallback, int whoPlaying) {
		this.playerOneName = pOne;
		this.playerTwoName = pTwo;
		this.playerOnePic = new SerializableBitmap(pOnePic);
		this.playerTwoPic = new SerializableBitmap(pTwoPic);
		this.playerOneFallbackCount = 0;
		this.playerTwoFallbackCount = 0;
		this.fallbackValue = fallback;
		this.whoMoving = GameState.playerOne;
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
	public boolean canFallback() {
		switch(whoMoving) {
		case GameState.playerOne:
			if(playerOneFallbackCount < fallbackValue) {
				playerOneFallbackCount++;
				return true;
			}
			break;
		case GameState.playerTwo:
			if(playerTwoFallbackCount < fallbackValue) {
				playerTwoFallbackCount++;
				return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
}
