package com.oose.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import com.oose.darkchess.DarkChessGame;
import com.oose.prototype.GameState;
import com.oose.prototype.Observable;
import com.oose.prototype.Observer;

public class DarkChessMain extends Activity implements OnClickListener,
		Observer {
	public static final String SAVEGAME_KEY = "DCMSGK";
	public static final String PEACERESULT = "PR";
	Button buttonFallback;
	Button buttonMore;
	DarkChessView mainView;
	FrameLayout frame;
	RelativeLayout relative;
	DarkChessGame darkChess;

	PopupMenu moreMenuButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		super.onCreate(savedInstanceState);
		if (intent.getBooleanExtra(ChessMainMenu.LOADSAVEFILE, false)) {
			FileInputStream ios;
			ObjectInputStream is;
			try {
				ios = openFileInput(SAVEGAME_KEY);
				is = new ObjectInputStream(ios);
				DarkChessGame ch = (DarkChessGame) is.readObject();
				Log.d("timcheng", "freeze");
				Log.d("timcheng", ch.getStatus().getPlayerOneName());

				is.close();
				ios.close();
				darkChess = ch;
			} catch (Exception e) {
				Log.d("timcheng", e.toString());
			}
		} else {
			int fallbackValue = ChessSetup.DEFAULTFALLBACKVALUE;
			int timeLimitValue = intent.getIntExtra(ChessSetup.TIMELIMIT_INT,
					999);
			String playerOne = intent
					.getStringExtra(ChessSetup.PLAYER1NAME_STRING);
			String playerTwo = intent
					.getStringExtra(ChessSetup.PLAYER2NAME_STRING);
			Bitmap playerOnePic = intent
					.getParcelableExtra(ChessSetup.PLAYER1ICON_BITMAP);
			Bitmap playerTwoPic = intent
					.getParcelableExtra(ChessSetup.PLAYER2ICON_BITMAP);
			darkChess = new DarkChessGame(playerOne, playerTwo, playerOnePic,
					playerTwoPic, fallbackValue, timeLimitValue);
		}

		mainView = new DarkChessView(this, intent, darkChess, this);

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

		LayoutParams buttonFallbackRule = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		buttonFallbackRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		buttonFallbackRule.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		buttonFallback.setLayoutParams(buttonFallbackRule);
		buttonFallback.setOnClickListener(this);

		LayoutParams buttonMoreRule = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		buttonMoreRule.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		buttonMoreRule.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		buttonMore.setLayoutParams(buttonMoreRule);
		buttonMore.setOnClickListener(this);

		moreMenuButton = new PopupMenu(this, buttonMore);
		moreMenuButton.getMenuInflater().inflate(R.menu.game_more_menu,
				moreMenuButton.getMenu());

		moreMenuButton
				.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.menu_save:
							saveGame();
							break;
						case R.id.menu_pause:
							pause();
							break;
						case R.id.menu_giveup:
							giveUP();
							break;
						case R.id.menu_peace:
							peace();
						default:
							break;
						}
						return true;
					}

				});

		relative.addView(buttonFallback);
		relative.addView(buttonMore);

		frame.addView(mainView);
		frame.addView(relative);

		setContentView(frame);
	}
	
	private void pause() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.pause);
		builder.setMessage(getString(R.string.pause));
		builder.setPositiveButton(R.string.resume, null);
		builder.create().show();
	}
	
	private void peace() {
		String message;
		if (darkChess.getStatus().whosTurn() == GameState.PLAYERONE)
			message = darkChess.getStatus().getPlayerTwoName();
		else
			message = darkChess.getStatus().getPlayerOneName();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.gameover);
		builder.setMessage(message + " " + getString(R.string.peacedescription));
		builder.setPositiveButton(getString(R.string.yes),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						showResult(PEACERESULT);
					}
				});
		builder.setNegativeButton(getString(R.string.no),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});
		builder.create().show();
	}

	private void fallBack() {
		String toastText = getString(R.string.fallbackok);
		if (darkChess.fallback()) {
			mainView.refreshScreen();
			int count = darkChess.getStatus().getCurrentUserFallbackCount();
			toastText += count;
		} else
			toastText = getString(R.string.fallbackfail);
		Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT)
				.show();
	}

	private void giveUP() {
		String message;
		if (darkChess.getStatus().whosTurn() == GameState.PLAYERONE)
			message = darkChess.getStatus().getPlayerTwoName();
		else
			message = darkChess.getStatus().getPlayerOneName();
		showResult(message);
	}

	@Override
	public void onClick(View view) {
		if (view == buttonFallback) {
			fallBack();
		} else if (view == buttonMore) {
			moreMenuButton.show();
		}
	}

	private void saveGame() {
		FileOutputStream fos;
		ObjectOutputStream os;

		try {
			fos = openFileOutput(SAVEGAME_KEY, Context.MODE_PRIVATE);
			os = new ObjectOutputStream(fos);
			os.writeObject(darkChess);
			os.close();
			Toast.makeText(getApplicationContext(), getString(R.string.saveok),
					Toast.LENGTH_SHORT).show();

		} catch (Exception e) {
			Log.d("timcheng", e.toString());
		}
	}

	private void showResult(String result) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.gameover);
		if (result.equals(PEACERESULT))
			builder.setMessage(getString(R.string.peace));
		else
			builder.setMessage(result + "贏了！");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				finish();
			}
		});
		builder.create().show();
	}

	@Override
	public void update(Observable from, Object carry) {
		String message;
		if ((Integer) carry == GameState.PLAYERONE)
			message = darkChess.getStatus().getPlayerOneName();
		else
			message = darkChess.getStatus().getPlayerTwoName();
		showResult(message);
	}

}
