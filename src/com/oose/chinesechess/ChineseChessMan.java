package com.oose.chinesechess;

import android.graphics.Bitmap;

import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

public class ChineseChessMan extends ChessMan {

	public ChineseChessMan(int x, int y, int belong, ChessBoard board) {
		super(x, y, belong, board);
	}
	public ChineseChessMan(ChineseChessMan cm) {
		super(cm);
	}
	@Override
	public boolean move(int x, int y) {
		return false;
	}
	@Override
	public boolean eat(int x, int y) {
		return false;
	}
	public Bitmap getIcon() {
		return null;
	}
	public Bitmap getSelectedIcon() {
		return null;
	}
}
