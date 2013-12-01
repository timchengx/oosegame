package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class RedCar extends ChessMan{

	public RedCar(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.red_car);
	}
	@Override
	public boolean moveValid(int x, int y) {
		//Log.d("timcheng",new String("kerker "+board.getBoardXSize()+ " "+ board.getBoardYSize()));
		
		if(currentX == x) {
			if(currentY < y) {
				for(int nowY = currentY + 1; nowY < y; nowY++) {
					if(board.hasChess(x, nowY)) {
						return false;
					}
				}
			}
			else {
				for(int nowY = currentY + 1; nowY > y; nowY--) {
					if(nowY >= board.getBoardYSize()) continue;
					//this != getChess, boundry check
					if(this != board.getChess(x, nowY) && board.hasChess(x, nowY)) {
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
				for(int nowX = currentX + 1; nowX > x; nowX--) {
					if(nowX >= board.getBoardXSize()) continue;
					if(this != board.getChess(nowX, y) && board.hasChess(nowX, y)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	@Override
	public boolean eatValid(int x, int y) {
		if(currentX == x) {
			if(y < currentY) {
				
			}
			else {
				
			}
		}
		else if(currentY == y) {
			if(x < currentX) {
				
			}
				
			else {
				
			}
				
		}
		return true;
	}

}
