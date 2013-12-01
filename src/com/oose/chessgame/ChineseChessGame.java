package com.oose.chessgame;

import android.graphics.Canvas;

public class ChineseChessGame extends ChessGame {
	//protected ChineseChessBoard board;
	public ChineseChessGame() {
		board = new ChineseChessBoard();
		status = new ChineseChessGameState();
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshBoard(Canvas c) {
		// TODO Auto-generated method stub
		if(board.getBackground() != null)
			c.drawBitmap(board.getBackground(), 0, 0, null);
		//c.drawBitmap(BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinesechessboard), 0, 0, null);
		//for(ChessMan b : board) {
			//if(b == null) continue;
			//c.drawBitmap(b.icon, 100,68, null);
		//}
	}

	@Override
	public void select(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void move(int x, int y) {
		// TODO Auto-generated method stub

	}

}
