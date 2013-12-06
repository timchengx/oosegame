package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class RedElephant extends ChessMan{

	public RedElephant(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 5);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.red_elephant);
	}
	@Override
	public boolean moveValid(int x, int y) {
		if (0 <= x && x <= 4 && 0 <= y && y <= 8)
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
