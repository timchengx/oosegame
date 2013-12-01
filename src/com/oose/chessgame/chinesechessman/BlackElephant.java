package com.oose.chessgame.chinesechessman;

import android.graphics.BitmapFactory;

import com.oose.chessgame.ChessMan;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class BlackElephant extends ChessMan{

	public BlackElephant(int x, int y, int belong) {
		super(x, y, belong);
		this.icon = BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.black_elephant);
	}
	@Override
	public boolean moveValid(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
