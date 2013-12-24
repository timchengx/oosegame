package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackCannon extends ChineseChessMan {

	private static final long serialVersionUID = -3780197486852603943L;

	public BlackCannon(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
	}
	public BlackCannon(BlackCannon bc) {
		super(bc);
	}
	
	@Override
	public BlackCannon clone() throws CloneNotSupportedException {
		return new BlackCannon(this);
	}
	
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		boolean result = false;
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
					if (board.hasChess(x, nowY)) {
						return false;
					}
				}
			}
			result = true;
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
			result = true;
		}
		if(result) {
			inBoardMoveChess(x, y);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean eat(int x, int y) {
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
				inBoardMoveChess(x, y);
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
				inBoardMoveChess(x, y);
				return true;
			}
		}
		return false;
	}

}
