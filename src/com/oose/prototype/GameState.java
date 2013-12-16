package com.oose.prototype;

import android.graphics.Bitmap;

abstract public class GameState {
	public static final int playerOne = 1;
	public static final int playerTwo = 2;
	private int whoMoving;
	private String playerOneName;
	private String playerTwoName;
	private Bitmap playerOnePic;
	private Bitmap playerTwoPic;
	private int playerOneFallbackCount;
	private int playerTwoFallbackCount;
	private int fallbackValue;

	public GameState(String pOne, String pTwo, Bitmap pOnePic, Bitmap pTwoPic,
			int fallback) {
		this.playerOneName = pOne;
		this.playerTwoName = pTwo;
		this.playerOnePic = pOnePic;
		this.playerTwoPic = pTwoPic;
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
		return playerOnePic;
	}

	public Bitmap getPlayerTwoPic() {
		return playerTwoPic;
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
