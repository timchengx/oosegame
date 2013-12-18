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
	ChineseChessGame chineseChess;
	Paint namePaint;

	public ChineseChessView(Context context, Intent intent, ChineseChessGame ch) {
		super(context);
		r = getResources();
		
		//Log.d("timcheng", playerOne);
		//Log.d("timcheng", playerTwo);
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
		
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			//if((int)event.getY() < 720) {
				chineseChess.select((int)event.getX(), (int)event.getY());
				refreshScreen();
			//}
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
