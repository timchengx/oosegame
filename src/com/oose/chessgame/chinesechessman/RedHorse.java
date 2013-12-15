package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class RedHorse extends ChineseChessMan{

	public RedHorse(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.red_horse);
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
