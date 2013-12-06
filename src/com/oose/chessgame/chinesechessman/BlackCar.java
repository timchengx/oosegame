package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.chessgame.ChineseChessBoard;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class BlackCar extends ChessMan{

	public BlackCar(int x, int y, int belong, ChineseChessBoard board) {
		super(x, y, belong, board, 4);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.black_car);
	}
	public boolean moveValid(int x, int y) {
		if (Math.abs(x - currentX) + Math.abs(y - currentY) == 1) {
			return true;
		}
		return false;
	}
	public boolean eatValid(int x, int y) {
		if (moveValid(x, y)) {
			if (this.getLevel() >= board.getChess(x, y).getLevel())
				return true;
		}
		return false;
	}
}
