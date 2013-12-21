package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;


import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class RedSoldier extends DarkChessMan {
	private static final long serialVersionUID = 1042800279641311800L;

	public RedSoldier(int x, int y, DarkChessBoard board) {
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
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if(currentX == x && currentX >= 5) {
//			if(Math.abs(currentY-y) == 1 ) { 
//				return true;
//			}
//		}
//		else if (currentY == y){  
//			if(currentX < x) {
//				if((currentX + 1) == x) {
//					return true;	
//				}
//			}
//		}
//		return false;
	}
	@Override
	public RedSoldier clone() throws CloneNotSupportedException {
		return new RedSoldier(this);
	}

	@Override
	public boolean eat(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if(moveValid(x, y) == true){
//			return true;			
//		}else{
//			return false;
//		}
	}
}
