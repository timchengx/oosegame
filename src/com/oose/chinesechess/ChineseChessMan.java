package com.oose.chinesechess;

import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

abstract public class ChineseChessMan extends ChessMan {

	public ChineseChessMan(int x, int y, int belong, ChessBoard board) {
		super(x, y, belong, board);
	}
	public ChineseChessMan(ChineseChessMan cm) {
		super(cm);
	}
	
}
