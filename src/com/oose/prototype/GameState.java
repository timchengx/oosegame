package com.oose.prototype;

public class GameState {
	public static final int playerOne = 1;
	public static final int playerTwo = 2;
	private int whoMoving;
	private String playerOneName;
	private String playerTwoName;
	private int playerOneFallbackCount;
	private int playerTwoFallbackCount;
	private int fallbackValue;
	public GameState(String pOne, String pTwo, int fallback) {
		this.playerOneName = pOne;
		this.playerTwoName = pTwo;
		this.playerOneFallbackCount = 0;
		this.playerTwoFallbackCount = 0;
		this.fallbackValue = fallback;
		this.whoMoving = GameState.playerOne;
	}
	public GameState(String pOne, String pTwo, int pOneFB, int pTwoFB, int fallback, int whoPlaying) {
		this(pOne, pTwo, fallback);
		this.playerOneFallbackCount = pOneFB;
		this.playerTwoFallbackCount = pTwoFB;
		this.whoMoving = whoPlaying;
	}
	public int whosTurn() {
		return whoMoving;
	}
	public void changeTurn() {
		if(whoMoving == playerOne)
			whoMoving = GameState.playerTwo;
		else
			whoMoving = GameState.playerOne;
	}
}
