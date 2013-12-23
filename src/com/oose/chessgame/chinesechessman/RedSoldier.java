package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class RedSoldier extends ChineseChessMan {
	
	private static final long serialVersionUID = 1042800279641311800L;

	public RedSoldier(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	public RedSoldier(RedSoldier rs) {
		super(rs);
	}
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}

	@Override
	public RedSoldier clone() throws CloneNotSupportedException {
		return new RedSoldier(this);
	}

	@Override
	public boolean move(int x, int y) {
		if (currentY == y && currentY >= 5) {
			if (Math.abs(currentX - x) == 1) {
				inBoardMoveChess(x, y);
				return true;
			}
		} else if (currentX == x) {
			if (currentY < y) {
				if ((currentY + 1) == y) {
					inBoardMoveChess(x, y);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
