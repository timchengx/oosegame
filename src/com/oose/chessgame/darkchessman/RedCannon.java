package com.oose.chessgame.darkchessman;

import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;

public class RedCannon extends DarkChessMan {

	private static final long serialVersionUID = -6305489814171419879L;

	public RedCannon(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board, 2);
	}

	public RedCannon(RedCannon rc) {
		super(rc);
	}

	@Override
	public RedCannon clone() throws CloneNotSupportedException {
		return new RedCannon(this);
	}

	@Override
	public Bitmap getIcon() {
	
		if (this.visible)
			return DarkChessPictureList.getIcon(this.getClass().getName());
		
		else
			return DarkChessPictureList.getIcon("com.oose.chessgame.darkchessman.UnFlip");
		}
	@Override
	public Bitmap getSelectedIcon() {
		if (this.visible)
		return DarkChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
		else
			return DarkChessPictureList.getIcon("com.oose.chessgame.darkchessman.UnFlip" + "SELECTED");
	}

	@Override
	public boolean eat(int x, int y) {
		if (!(this.isVisible() && ((DarkChessMan) board.getChess(x, y)).isVisible())) {
			return false;
		}
		int hasChess = 0;
		if (currentX == x) {
			if (currentY < y) {
				for (int nowY = currentY + 1; nowY < y; nowY++) {
					if (board.hasChess(x, nowY)) {
						hasChess++;
					}
				}
			} else {
				for (int nowY = currentY - 1; nowY > y; nowY--) {
					if (board.hasChess(x, nowY)) {
						hasChess++;
					}
				}
			}
		} else if (currentY == y) {
			if (currentX < x) {
				for (int nowX = currentX + 1; nowX < x; nowX++) {
					if (board.hasChess(nowX, y)) {
						hasChess++;
					}
				}
			} else {
				for (int nowX = currentX - 1; nowX > x; nowX--) {
					if (board.hasChess(nowX, y)) {
						hasChess++;
					}
				}
			}
		
		}
		if (hasChess == 1) {
			inBoardMoveChess(x, y);
			return true;
		}
		return false;
	}

}
