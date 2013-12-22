package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;


import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;
public class RedShi extends DarkChessMan{
	private static final long serialVersionUID = -1313436214418056565L;
	public RedShi(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedShi(RedShi redShi) {
		super(redShi);
	}
	
	@Override
	public RedShi clone() throws CloneNotSupportedException {
		return new RedShi(this);
	}
	@Override
	public Bitmap getIcon() {
		return DarkChessPictureList.getIcon(this.getClass().getName());
	}
	@Override
	public Bitmap getSelectedIcon() {
		return DarkChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;

	}
	@Override
	public boolean eat(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		return moveValid(x,y);
	}

}
