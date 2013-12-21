package com.oose.darkchess;

import com.oose.chinesechess.ChineseChessMan;
import com.oose.prototype.ChessBoard;
import com.oose.prototype.ChessMan;

public class DarkChessMan extends ChessMan{

	private static final long serialVersionUID = 400101495365023888L;

	public  DarkChessMan(int x, int y, int belong, ChessBoard board) {
		super(x, y, belong, board);
	}

	public  DarkChessMan(DarkChessMan cm) {
		super(cm);
	}
}
