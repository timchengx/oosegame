package com.oose.chinesechess;

import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

abstract public class ChineseChessMan extends ChessMan {
	/* 
	 * chinese chess man don't need any addition field or method
	 * but dark chess might be used.
	 */
	private static final long serialVersionUID = 400101495365023888L;

	public ChineseChessMan(int x, int y, int belong, ChessBoard board) {
		super(x, y, belong, board);
	}

	public ChineseChessMan(ChineseChessMan cm) {
		super(cm);
	}
}
