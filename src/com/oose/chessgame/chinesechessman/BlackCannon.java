package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class BlackCannon extends ChineseChessMan {

	public BlackCannon(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.black_cannon);
	}

	@Override
	public boolean moveValid(int x, int y) {
		if (currentX == x) {
			if (currentY < y) {
				for (int nowY = currentY + 1; nowY < y; nowY++) {
					if (board.hasChess(x, nowY)) {
						return false;
					}
				}
			} else {
				for (int nowY = currentY - 1; nowY > y; nowY--) {
					if (nowY >= board.getBoardYSize())
						continue;
					// this != getChess, boundry check
					if (board.hasChess(x, nowY)) {
						return false;
					}
				}
			}
			return true;
		} else if (currentY == y) {
			if (currentX < x) {
				for (int nowX = currentX + 1; nowX < x; nowX++) {
					if (board.hasChess(nowX, y)) {
						return false;
					}
				}
			} else {
				for (int nowX = currentX - 1; nowX > x; nowX--) {
					if (nowX >= board.getBoardXSize())
						continue;
					if (board.hasChess(nowX, y)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		// TODO Auto-generated method stub
		boolean hasOneChess = false;
		if (currentX == x) {
			if (currentY < y) {
				for (int nowY = currentY + 1; nowY < y; nowY++) {
					if (board.hasChess(x, nowY)) {
						if (hasOneChess) {
							return false;
						} else {
							hasOneChess = true;
						}

					}
				}
			} else {
				for (int nowY = currentY - 1; nowY > y; nowY--) {
					if (nowY >= board.getBoardYSize())
						continue;
					// this != getChess, boundry check
					if (board.hasChess(x, nowY)) {
						if (hasOneChess) {
							return false;
						} else {
							hasOneChess = true;
						}
					}
				}
			}
			if (hasOneChess) {
				return true;
			}
		} else if (currentY == y) {
			if (currentX < x) {
				for (int nowX = currentX + 1; nowX < x; nowX++) {
					if (board.hasChess(nowX, y)) {
						if (hasOneChess) {
							return false;
						} else {
							hasOneChess = true;
						}
					}
				}
			} else {
				for (int nowX = currentX - 1; nowX > x; nowX--) {
					if (nowX >= board.getBoardXSize())
						continue;
					if (board.hasChess(nowX, y)) {
						if (hasOneChess) {
							return false;
						} else {
							hasOneChess = true;
						}
					}
				}
			}
			if (hasOneChess) {
				return true;
			}
		}
		return false;
	}

}
