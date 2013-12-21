package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class RedElephant extends DarkChessMan{
	private static final long serialVersionUID = -2626627629521329374L;

	public RedElephant(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedElephant(RedElephant re) {
		super(re);
	}
	
	@Override
	public RedElephant clone() throws CloneNotSupportedException {
		return new RedElephant(this);
	}
	@Override
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}
	@Override
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if (0 <= x && x <= 4 && 0 <= y && y <= 8)
//			if (Math.abs((currentX - x)) == 2 && Math.abs((currentY - y)) == 2)
//				if (!board.hasChess((x + currentX) / 2, (y + currentY) / 2))
//					return true;
//
//		return false;
	}

	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
