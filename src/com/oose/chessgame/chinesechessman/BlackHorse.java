package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class BlackHorse extends ChessMan{

	public BlackHorse(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.black_horse);
	}
	@Override
	public boolean moveValid(int x, int y) {
		if (Math.abs(currentX - x) == 2 && Math.abs(currentY - y) == 1) {
			if (x > currentY && (!board.hasChess(currentX + 1, currentY))) {// 目標在右邊
				return true;
			} else if (x < currentY
					&& (!board.hasChess(currentX - 1, currentY))) {// 目標在左邊
				return true;
			}
		} else if (Math.abs(currentX - x) == 1 && Math.abs(currentY - y) == 2) {
			if (y > currentY && (!board.hasChess(currentX, currentY + 1))) {// 目標在下面
				return true;
			} else if (y < currentY
					&& (!board.hasChess(currentX, currentY - 1))) {// 目標在上面
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		return moveValid(x, y);
	}

}
