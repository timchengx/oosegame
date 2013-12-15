package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.game.OOSEGame;
import com.oose.game.R;
import com.oose.prototype.ChessMan;

public class BlackGeneral extends ChineseChessMan {

	public BlackGeneral(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.BLACK, board);
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
		//Log.d("timcheng",new String("kerker "+board.getBoardXSize()+ " "+ board.getBoardYSize()));
//		if(((0<=x && x<=2) || (7<=x && x<=9)) && (3<=y && y<=5)) { //鎖定九宮格 
//			if(Math.abs(x-currentX) + Math.abs(y-currentY) == 1 ) {
//					return true;
//			}
//		}
//		return false;
	}
	@Override
	public boolean eatValid(int x, int y) {
		return moveValid(x,y);
	}

}
