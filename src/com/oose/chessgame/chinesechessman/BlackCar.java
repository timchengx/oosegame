package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class BlackCar extends ChineseChessMan{

	public BlackCar(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.black_car);
	}
	public boolean moveValid(int x, int y) {
		if(currentX == x) {
			if(currentY < y) { 
				for(int nowY = currentY + 1; nowY < y; nowY++) {
					if(board.hasChess(x, nowY)) {
						return false;
					}
				}
			}
			else {
				for(int nowY = currentY - 1; nowY > y; nowY--) {
					if(nowY >= board.getBoardYSize()) continue;
					if(board.hasChess(x, nowY)) {
						return false;
					}
				}
			}
			return true;
		}
		else if (currentY == y){
			if(currentX < x) {
				for(int nowX = currentX + 1; nowX < x; nowX++) {
					if(board.hasChess(nowX, y)) {
						return false;
					}
				}
			}
			else {
				for(int nowX = currentX - 1; nowX > x; nowX--) {
					if(nowX >= board.getBoardYSize()) continue;
					if(board.hasChess(nowX, y)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	public boolean eatValid(int x, int y) {
		if(moveValid(x, y) == true){
			return true;			
		}else{
			return false;
		}
	}
}
