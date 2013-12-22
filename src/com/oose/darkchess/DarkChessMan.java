package com.oose.darkchess;

import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

abstract public class DarkChessMan extends ChessMan{

	private static final long serialVersionUID = 400101495365023888L;
	

	
	public  DarkChessMan(int x, int y, int belong, ChessBoard board, int level) {
		super(x, y, belong, board);
		this.level = level;
	}

	public  DarkChessMan(DarkChessMan cm) {
		super(cm);
		this.level = level;
	}
	
	public boolean moveValid(int x, int y) {
		if (this.isVisible() ) 
		if (Math.abs(x - currentX) + Math.abs(y - currentY) == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean move(int x, int y) {
		if(moveValid(x, y)){
			inBoardMoveChess(x, y);
			return true;
		}
		return false;
	}
	@Override
	public boolean eat(int x, int y) {
		if (moveValid(x, y)&& board.getChess(x, y).isVisible()) {
			if (this.getLevel() >= board.getChess(x, y).getLevel()){
				inBoardMoveChess(x, y);
				return true;
				}
		}
		return false;
	}
	
	

	
}
