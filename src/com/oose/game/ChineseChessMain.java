package com.oose.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.oose.chinesechess.ChineseChessGame;




public class ChineseChessMain extends Activity implements OnClickListener{
	
	Button buttonFallback;
	Button buttonMore;
	ChineseChessView mainView;
	FrameLayout frame;
	RelativeLayout relative;
	ChineseChessGame chineseChess;
	int fallbackValue;
	PopupMenu pmenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fallbackValue = ChessSetup.DEFAULTFALLBACKVALUE;
		String playerOne = getIntent().getStringExtra(ChessSetup.PLAYER1NAME_STRING);
		String playerTwo = getIntent().getStringExtra(ChessSetup.PLAYER2NAME_STRING);
		Bitmap playerOnePic = getIntent().getParcelableExtra(ChessSetup.PLAYER1ICON_BITMAP);
		Bitmap playerTwoPic = getIntent().getParcelableExtra(ChessSetup.PLAYER2ICON_BITMAP);
		chineseChess = new ChineseChessGame(playerOne, playerTwo, playerOnePic,
				playerTwoPic, fallbackValue);
		
		mainView = new ChineseChessView(this, getIntent(), chineseChess);
		
		frame = new FrameLayout(this);
		relative = new RelativeLayout(this);
		
		buttonFallback = new Button(this);
		buttonMore = new Button(this);
		
		buttonMore.setText(getString(R.string.moremenu));
		buttonMore.setWidth(240);
		buttonMore.setHeight(80);
		
		buttonFallback.setText(getString(R.string.fallback));
		buttonFallback.setWidth(240);
		buttonFallback.setHeight(80);
		
	    LayoutParams buttonFallbackRule = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    buttonFallbackRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    buttonFallbackRule.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
	    buttonFallback.setLayoutParams(buttonFallbackRule);
	    buttonFallback.setOnClickListener(this);
	    
	    LayoutParams buttonMoreRule = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    buttonMoreRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    buttonMoreRule.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	    buttonMore.setLayoutParams(buttonMoreRule);
	    buttonMore.setOnClickListener(this);
	    
	    pmenu = new PopupMenu(this, buttonMore);
		pmenu.getMenuInflater().inflate(R.menu.game_more_menu, pmenu.getMenu());
		
		
	    relative.addView(buttonFallback);
		relative.addView(buttonMore);
		
	    
	    frame.addView(mainView);
		frame.addView(relative);
		
		setContentView(frame);
	}
	@Override
	public void onClick(View view) {
		if(view == buttonFallback) {
//			Log.d("timcheng","let's go back!");
//			if(chineseChess.fallback())
//				mainView.refreshScreen();
			FileOutputStream fos;
			ObjectOutputStream os;

			try {
				fos  = openFileOutput("output", Context.MODE_PRIVATE);
				os = new ObjectOutputStream(fos);
				os.writeObject(chineseChess);
				os.close();
				
			} catch (Exception e) {
				Log.d("timchenc", e.toString());
			}
			
		}
		else if (view == buttonMore) {
			//pmenu.show();
			FileInputStream ios;
			ObjectInputStream is;
			try {
			ios = openFileInput("output");
			is = new ObjectInputStream(ios);
			ChineseChessGame ch = (ChineseChessGame) is.readObject();
			Log.d("timcheng", "freeze");
			Log.d("timcheng",ch.getStatus().getPlayerOneName());
			
			is.close();
			chineseChess = ch;
			mainView.refreshScreen();
			} catch(Exception e) {
				Log.d("timchenc", e.toString());
			}
		}
	}
}