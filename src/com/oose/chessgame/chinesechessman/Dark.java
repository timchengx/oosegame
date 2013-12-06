package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class Dark extends ChessMan {

	public Dark(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 0);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.dark);
	}

	@Override
	public boolean moveValid(int x, int y) {
		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		return false;
	}
}
