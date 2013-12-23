package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;






import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;
public class RedGeneral extends DarkChessMan{
	private static final long serialVersionUID = -4341507506939393102L;
	public RedGeneral(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board, 7);
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
		if (moveValid(x, y)&& ((DarkChessMan) board.getChess(x, y)).isVisible()) {
			if (((DarkChessMan) board.getChess(x, y)).getLevel() == 1){
				return false;
				}
			else{
				inBoardMoveChess(x, y);
				return true;
			}
		}
		return false;
	}
	

}
