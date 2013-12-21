package com.oose.chessgame.darkchessman;
import android.graphics.Bitmap;




import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;
import com.oose.factory.ChineseChessPictureList;
import com.oose.prototype.ChessMan;
public class RedHorse extends DarkChessMan{

	private static final long serialVersionUID = -6934211629145832437L;

	public RedHorse(int x, int y, DarkChessBoard board) {
		super(x, y, ChessMan.RED, board);
	}
	
	public RedHorse(RedHorse redShi) {
		super(redShi);
	}
	
	@Override
	public RedHorse clone() throws CloneNotSupportedException {
		return new RedHorse(this);
	}
	@Override
	public Bitmap getIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName());
	}
	@Override
	public Bitmap getSelectedIcon() {
		return ChineseChessPictureList.getIcon(this.getClass().getName() + "SELECTED");
	}
	@Override
	public boolean move(int x, int y) {
		inBoardMoveChess(x, y);
		return true;

	}

	@Override
	public boolean eat(int x, int y) {
		return move(x, y);
	}

}
