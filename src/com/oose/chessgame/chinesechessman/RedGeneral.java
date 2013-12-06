package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class RedGeneral extends ChessMan {

	public RedGeneral(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 7);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.red_general);
	}

	@Override
	public boolean moveValid(int x, int y) {
		if (Math.abs(x - currentX) + Math.abs(y - currentY) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		if (board.getChess(x, y).getLevel() == 1)
			return false;
		return moveValid(x, y);
	}

}
