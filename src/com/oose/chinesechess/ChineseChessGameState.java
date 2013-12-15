package com.oose.chinesechess;

import com.oose.prototype.GameState;

public class ChineseChessGameState extends GameState {

	public ChineseChessGameState(String pOne, String pTwo, int fallback) {
		super(pOne, pTwo, fallback);
	}

	public ChineseChessGameState(String pOne, String pTwo, int pOneFB,
			int pTwoFB, int fallback, int whoPlaying) {
		super(pOne, pTwo, pOneFB, pTwoFB, fallback, whoPlaying);
	}

}
