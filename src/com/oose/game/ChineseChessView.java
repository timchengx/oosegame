package com.oose.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.oose.chinesechess.ChineseChessGame;
import com.oose.prototype.ChessGame;
import com.oose.prototype.Observable;

public class ChineseChessView extends SurfaceView implements SurfaceHolder.Callback, Observable {//, Runnable {
	SurfaceHolder holder;
	ChineseChessGame chineseChess;
	Paint namePaint;
	ChineseChessMain mainActivity;

	public ChineseChessView(Context context, Intent intent, ChineseChessGame ch, ChineseChessMain recall) {
		super(context);
		mainActivity = recall;
		namePaint = new Paint();
		namePaint.setColor(Color.WHITE);
		namePaint.setTextSize(18);

		chineseChess = ch;

		holder = getHolder();
		holder.addCallback(this);
	}
	public void refreshScreen() {
		Canvas c = holder.lockCanvas();
		chineseChess.refreshBoard(c);
		c.drawText(chineseChess.getStatus().getPlayerOneName(), 30, 547, namePaint);
		c.drawText(chineseChess.getStatus().getPlayerTwoName(), 360, 547, namePaint);
		c.drawBitmap(chineseChess.getStatus().getPlayerOnePic(), 30, 605, null);
		c.drawBitmap(chineseChess.getStatus().getPlayerTwoPic(), 360, 605, null);
		holder.unlockCanvasAndPost(c);
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder sh) {
		refreshScreen();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int gameResult = ChessGame.GAMECONTINUE;
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			gameResult = chineseChess.select((int)event.getX(), (int)event.getY());
			refreshScreen();
		}
		if(gameResult != ChessGame.GAMECONTINUE)
			notifyObservers(Integer.valueOf(gameResult));
		return true;
	}

	@Override
	public void notifyObservers(Object carry) {
		mainActivity.update(this, carry);
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
