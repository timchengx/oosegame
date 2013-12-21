package com.oose.darkchess;
import android.graphics.Bitmap;

import com.oose.prototype.GameState;

public class DarkChessGameState extends GameState {

	private static final long serialVersionUID = 4937630102339990622L;

	public DarkChessGameState(String pOne, String pTwo, Bitmap pOnePic,
			Bitmap pTwoPic, int fallback, int timeLimit) {
		super(pOne, pTwo, pOnePic, pTwoPic, fallback, timeLimit);
	}

}
