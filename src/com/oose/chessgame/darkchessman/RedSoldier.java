package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;






import android.util.Log;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;
public class RedSoldier extends DarkChessMan {
	private static final long serialVersionUID = 1042800279641311800L;

	public RedSoldier(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board, 1);
	}
	public RedSoldier(RedSoldier rs) {
		super(rs);
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
	public RedSoldier clone() throws CloneNotSupportedException {
		return new RedSoldier(this);
	}

	
	@Override
	public boolean eat(int x, int y) {
		if (moveValid(x, y)&& ((DarkChessMan) board.getChess(x, y)).isVisible()) {
			if (this.getLevel() >= ((DarkChessMan) board.getChess(x, y)).getLevel()
					|| ((DarkChessMan) board.getChess(x, y)).getLevel() == 7){
				inBoardMoveChess(x, y);
				return true;
				}
		}
		return false;
	}
	
}
