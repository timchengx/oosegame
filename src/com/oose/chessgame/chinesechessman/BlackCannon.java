package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class BlackCannon extends ChessMan {

	public BlackCannon(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 2);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.dark);

	}

	@Override
	public boolean moveValid(int x, int y) {
		if (this.isVisible() && board.getChess(x, y).isVisible()) 
		if (Math.abs(x - currentX) + Math.abs(y - currentY) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		if (!(this.isVisible() && board.getChess(x, y).isVisible())) {return false;}
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

	public void open() {
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(),
				R.drawable.black_cannon);
		this.visible = true;
	}
}
