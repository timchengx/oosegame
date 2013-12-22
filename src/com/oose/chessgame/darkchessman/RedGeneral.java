package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;




import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;
public class RedGeneral extends DarkChessMan{
	private static final long serialVersionUID = -4341507506939393102L;
	public RedGeneral(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedGeneral(RedGeneral rg) {
		super(rg);
	}
	
	@Override
	public RedGeneral clone() throws CloneNotSupportedException {
		return new RedGeneral(this);
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
		return move(x,y);
	}

}
