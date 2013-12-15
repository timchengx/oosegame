package com.oose.game;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import com.oose.chinesechess.ChineseChessGame;
import com.oose.prototype.ChessGame;

public class ChineseChessView extends SurfaceView implements SurfaceHolder.Callback{//, Runnable {
	SurfaceHolder holder;
	Resources r;
	ChessGame chineseChess;
	TextView playerOneName;
	TextView playerTwoName;
	public ChineseChessView(Context context,Intent intent) {
		super(context);
		r = getResources();
		
		int fallbackValue = KEYINDEX.DEFAULTFALLBACKVALUE;
		int playerOneFallback = 0;
		int playerTwoFallback = 0;
		String playerOne = intent.getStringExtra(KEYINDEX.PLAYER1NAME_STRING);
		String playerTwo = intent.getStringExtra(KEYINDEX.PLAYER2NAME_STRING);
		
		
		chineseChess = new ChineseChessGame(playerOne, playerTwo, fallbackValue);
		
		
		playerOneName = new TextView(context);
		playerOneName.setText(playerOne);
		playerTwoName = new TextView(context);
		playerTwoName.setText(playerTwo);
		
		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		Canvas c = holder.lockCanvas();
		chineseChess.refreshBoard(c);
		holder.unlockCanvasAndPost(c);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			int result = chineseChess.select((int)event.getX(), (int)event.getY());
			if(result == ChessGame.NEED_REDRAW) {
				Canvas c = holder.lockCanvas();
				chineseChess.refreshBoard(c);
				holder.unlockCanvasAndPost(c);
			}
		}
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
	}
/*
	@Override
	public void run() {
		//for time count down(thread)
	}
*/
}
