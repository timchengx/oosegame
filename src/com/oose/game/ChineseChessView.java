package com.oose.game;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.oose.chinesechess.ChineseChessGame;
import com.oose.prototype.ChessGame;

public class ChineseChessView extends SurfaceView implements SurfaceHolder.Callback{//, Runnable {
	SurfaceHolder holder;
	Resources r;
	ChessGame chineseChess;
	String playerOne;
	String playerTwo;
	Bitmap playerOnePic;
	Bitmap playerTwoPic;
	Paint namePaint;

	public ChineseChessView(Context context, Intent intent) {
		super(context);
		r = getResources();

		int fallbackValue = ChessSetup.DEFAULTFALLBACKVALUE;
		int playerOneFallback = 0;
		int playerTwoFallback = 0;
		playerOne = intent.getStringExtra(ChessSetup.PLAYER1NAME_STRING);
		playerTwo = intent.getStringExtra(ChessSetup.PLAYER2NAME_STRING);
		playerOnePic = intent.getParcelableExtra(ChessSetup.PLAYER1ICON_BITMAP);
		playerTwoPic = intent.getParcelableExtra(ChessSetup.PLAYER2ICON_BITMAP);
		Log.d("timcheng", playerOne);
		Log.d("timcheng", playerTwo);
		namePaint = new Paint();
		namePaint.setColor(Color.WHITE);
		namePaint.setTextSize(18);

		chineseChess = new ChineseChessGame(playerOne, playerTwo, playerOnePic,
				playerTwoPic, fallbackValue);

		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		Canvas c = holder.lockCanvas();
		chineseChess.refreshBoard(c);
		c.drawText(playerOne, 30, 547, namePaint);
		c.drawText(playerTwo, 360, 547, namePaint);
		c.drawBitmap(playerOnePic, 30, 605, null);
		c.drawBitmap(playerTwoPic, 360, 605, null);
		holder.unlockCanvasAndPost(c);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			boolean result = chineseChess.select((int)event.getX(), (int)event.getY());
			if(result) {
				Canvas c = holder.lockCanvas();
				chineseChess.refreshBoard(c);
				c.drawText(playerOne, 30, 547, namePaint);
				c.drawText(playerTwo, 360, 547, namePaint);
				c.drawBitmap(playerOnePic, 30, 605, null);
				c.drawBitmap(playerTwoPic, 360, 605, null);
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
