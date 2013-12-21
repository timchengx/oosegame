package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;


import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class RedCannon extends DarkChessMan{

	private static final long serialVersionUID = -6305489814171419879L;
	public RedCannon(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedCannon(RedCannon rc) {
		super(rc);
	}
	
	@Override
	public RedCannon clone() throws CloneNotSupportedException {
		return new RedCannon(this);
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
//				if(currentX == x) {
//					if(currentY < y) {
//						for(int nowY = currentY + 1; nowY < y; nowY++) {
//							if(board.hasChess(x, nowY)) {
//								return false;
//							}
//						}
//					}
//					else {
//						for(int nowY = currentY - 1; nowY > y; nowY--) {
//							if(nowY >= board.getBoardYSize()) continue;
//							//this != getChess, boundry check
//							if(board.hasChess(x, nowY)) {
//								return false;
//							}
//						}
//					}
//					return true;
//				}
//				else if (currentY == y){
//					if(currentX < x) {
//						for(int nowX = currentX + 1; nowX < x; nowX++) {
//							if(board.hasChess(nowX, y)) {
//								return false;
//							}
//						}
//					}
//					else {
//						for(int nowX = currentX - 1; nowX > x; nowX--) {
//							if(nowX >= board.getBoardXSize()) continue;
//							if(board.hasChess(nowX, y)) {
//								return false;
//							}
//						}
//					}
//					return true;
//				}
//				return false;
	}
	@Override
	public boolean eat(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		boolean hasOneChess = false; 
//		if(currentX == x) {
//			if(currentY < y) {
//				for(int nowY = currentY + 1; nowY < y; nowY++) {
//					if(board.hasChess(x, nowY)) {
//						if(hasOneChess) {
//							return false;
//						}
//						else {
//							hasOneChess = true;
//						}
//						
//					}
//				}
//			}
//			else {
//				for(int nowY = currentY - 1; nowY > y; nowY--) {
//					if(nowY >= board.getBoardYSize()) continue;
//					//this != getChess, boundry check
//					if(board.hasChess(x, nowY)) {
//						if(hasOneChess) {
//							return false;
//						}
//						else {
//							hasOneChess = true;
//						}
//					}
//				}
//			}
//			if (hasOneChess) {
//				return true;
//			}
//		}
//		else if (currentY == y){
//			if(currentX < x) {
//				for(int nowX = currentX + 1; nowX < x; nowX++) {
//					if(board.hasChess(nowX, y)) {
//						if(hasOneChess) {
//							return false;
//						}
//						else {
//							hasOneChess = true;
//						}
//					}
//				}
//			}
//			else {
//				for(int nowX = currentX - 1; nowX > x; nowX--) {
//					if(nowX >= board.getBoardXSize()) continue;
//					if(board.hasChess(nowX, y)) {
//						if(hasOneChess) {
//							return false;
//						}
//						else {
//							hasOneChess = true;
//						}
//					}
//				}
//			}
//			if (hasOneChess) {
//				return true;
//			}
//		}
//		return false;
	}
}
