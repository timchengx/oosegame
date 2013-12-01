package com.oose.chessgame;

public abstract class GameState {
	public static final int playerOne = 1;
	public static final int playerTwo = 2;
	private int whoMoving = GameState.playerOne;
	private String playerOneName;
	private String playerTwoName;
	private int playerOneFallbackCount;
	private int playerTwoFallbackCount;
	public int whosTurn() {
		return whoMoving;
	}
}
