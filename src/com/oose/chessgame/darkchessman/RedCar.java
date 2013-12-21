package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;




import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class RedCar extends DarkChessMan{

	private static final long serialVersionUID = -6745629377144249069L;
	public RedCar(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedCar(RedCar rc) {
		super(rc);
	}
	
	@Override
	public RedCar clone() throws CloneNotSupportedException {
		return new RedCar(this);
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
//		if(currentX == x) {
//			if(currentY < y) { 
//				for(int nowY = currentY + 1; nowY < y; nowY++) {
//					if(board.hasChess(x, nowY)) {
//						return false;
//					}
//				}
//			}
//			else {
//				for(int nowY = currentY - 1; nowY > y; nowY--) {
//					if(nowY >= board.getBoardYSize()) continue;
//					if(board.hasChess(x, nowY)) {
//						return false;
//					}
//				}
//			}
//			return true;
//		}
//		else if (currentY == y){
//			if(currentX < x) {
//				for(int nowX = currentX + 1; nowX < x; nowX++) {
//					if(board.hasChess(nowX, y)) {
//						return false;
//					}
//				}
//			}
//			else {
//				for(int nowX = currentX - 1; nowX > x; nowX--) {
//					if(nowX >= board.getBoardYSize()) continue;
//					if(board.hasChess(nowX, y)) {
//						return false;
//					}
//				}
//			}
//			return true;
//		}
		//return false;
		return true;
	}
	@Override
	public boolean eat(int x, int y) {
//		if(moveValid(x, y) == true){
//			return true;			
//		}else{
//			return false;
//		}
		return move(x,y);
	}


}
