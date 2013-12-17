package com.oose.chessgame.chinesechessman;

import android.graphics.Bitmap;

import com.oose.chinesechess.ChineseChessBoard;
import com.oose.chinesechess.ChineseChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;

public class RedHorse extends ChineseChessMan{

	public RedHorse(int x, int y, ChineseChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedHorse(RedHorse redShi) {
		super(redShi);
	}
	
	@Override
	public RedHorse clone() throws CloneNotSupportedException {
		return new RedHorse(this);
	}
	
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}

	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;
//		if (Math.abs(currentX - x) == 2 && Math.abs(currentY - y) == 1) {
//			if (x > currentY && (!board.hasChess(currentX + 1, currentY))) {// 目標在右邊
//				return true;
//			} else if (x < currentY
//					&& (!board.hasChess(currentX - 1, currentY))) {// 目標在左邊
//				return true;
//			}
//		} else if (Math.abs(currentX - x) == 1 && Math.abs(currentY - y) == 2) {
//			if (y > currentY && (!board.hasChess(currentX, currentY + 1))) {// 目標在下面
//				return true;
//			} else if (y < currentY
//					&& (!board.hasChess(currentX, currentY - 1))) {// 目標在上面
//				return true;
//			}
//		}
//		return false;
	}

	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
