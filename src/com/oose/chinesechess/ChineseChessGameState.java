package com.oose.chinesechess;

import android.graphics.Bitmap;

import com.oose.prototype.GameState;

public class ChineseChessGameState extends GameState {

	public ChineseChessGameState(String pOne, String pTwo, Bitmap pOnePic,
			Bitmap pTwoPic, int fallback) {
		super(pOne, pTwo, pOnePic, pTwoPic, fallback);
	}

	public ChineseChessGameState(String pOne, String pTwo, Bitmap pOnePic,
			Bitmap pTwoPic, int fallback, int pOneFB, int pTwoFB, int whoPlaying) {
		super(pOne, pTwo, pOnePic, pTwoPic, pOneFB, pTwoFB, fallback,
				whoPlaying);
	}

}
