package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;







import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;
public class BlackSoldier extends DarkChessMan{

	private static final long serialVersionUID = -7365495055614093258L;
	public BlackSoldier(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board, 1);
	}
	
	public BlackSoldier(BlackSoldier bs) {
		super(bs);
	}
	
	@Override
	public BlackSoldier clone() throws CloneNotSupportedException {
		return new BlackSoldier(this);
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
		if (moveValid(x, y)&& board.getChess(x, y).isVisible()) {
			if (this.getLevel() >= board.getChess(x, y).getLevel()
					|| board.getChess(x, y).getLevel() == 7)
				{
				inBoardMoveChess(x, y);
				return true;}
		}
		return false;
	}
	

}
