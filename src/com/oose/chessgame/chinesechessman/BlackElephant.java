package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class BlackElephant extends ChineseChessMan{

	public BlackElephant(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.black_elephant);
	}
	@Override
	public boolean moveValid(int x, int y) {
		if (5 <= x && x <= 9 && 0 <= y && y <= 8)
			if (Math.abs((currentX - x)) == 2 && Math.abs((currentY - y)) == 2)
				if (!board.hasChess((x + currentX) / 2, (y + currentY) / 2))
					return true;

		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		return moveValid(x, y);
	}

}
