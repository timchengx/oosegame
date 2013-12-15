package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class RedElephant extends ChineseChessMan{

	public RedElephant(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	@Override
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	@Override
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName()+"SELECTED");
	}
	@Override
	public boolean moveValid(int x, int y) {
		return true;
//		if (0 <= x && x <= 4 && 0 <= y && y <= 8)
//			if (Math.abs((currentX - x)) == 2 && Math.abs((currentY - y)) == 2)
//				if (!board.hasChess((x + currentX) / 2, (y + currentY) / 2))
//					return true;
//
//		return false;
	}

	@Override
	public boolean eatValid(int x, int y) {
		return moveValid(x, y);
	}

}
