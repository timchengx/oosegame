package com.oose.chessgame.darkchessman;


import android.graphics.Bitmap;

import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.DarkChessPictureList;
import com.oose.prototype.ChessMan;

public class BlackGeneral extends DarkChessMan {

	private static final long serialVersionUID = -125460878316517268L;
	public BlackGeneral(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.BLACK, board, 7);
	}

	
	public BlackGeneral(BlackGeneral bg) {
		super(bg);
	}
	
	@Override
	public BlackGeneral clone() throws CloneNotSupportedException {
		return new BlackGeneral(this);
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
			if (board.getChess(x, y).getLevel() == 1)
			{
				return false;
			}
			else
			{
				inBoardMoveChess(x, y);
				return true;
		}}
		return false;
	}
	

	




}
