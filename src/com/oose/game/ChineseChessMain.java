package com.oose.game;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class ChineseChessMain extends Activity {
	String playerOne;
	String playerTwo;
	Bitmap playerOnePic;
	Bitmap playerTwoPic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ChineseChessView mainView = new ChineseChessView(this, getIntent());
		
		FrameLayout frame = new FrameLayout(this);
		RelativeLayout relative = new RelativeLayout(this);
		
		Button buttonFallback = new Button(this);
		Button buttonMore = new Button(this);
		
		buttonMore.setText("MoreOPT");
		buttonMore.setWidth(240);
		buttonMore.setHeight(80);
		
		buttonFallback.setText(getResources().getString(R.string.fallback));
		buttonFallback.setWidth(240);
		buttonFallback.setHeight(80);
		
	    LayoutParams buttonFallbackRule = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    buttonFallbackRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    buttonFallbackRule.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
	    buttonFallback.setLayoutParams(buttonFallbackRule);
	    
	    LayoutParams buttonMoreRule = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	    buttonMoreRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    buttonMoreRule.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	    buttonMore.setLayoutParams(buttonMoreRule);
	    //buttonMore.setOnClickListener(this);
		
	    relative.addView(buttonFallback);
		relative.addView(buttonMore);
	    
	    frame.addView(mainView);
		frame.addView(relative);
		
		setContentView(frame);
	}
	@Override
	public void onClick(View view) {
		
	}
}