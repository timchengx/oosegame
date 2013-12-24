package com.oose.factory;


import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.game.DarkChessView;
import com.oose.game.OOSEGame;
import com.oose.game.R;

public class DarkChessPictureList {
	private static final String PACKAGENAME = "com.oose.chessgame.darkchessman.";
	private static HashMap<String, Bitmap> hashMap;

	private static void initializeMap() {
		hashMap = new HashMap<String, Bitmap>();

		hashMap.put(PACKAGENAME + "RedCar", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_car));
		hashMap.put(PACKAGENAME + "RedSoldier", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_soldier));
		hashMap.put(PACKAGENAME + "RedShi", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_shi));
		hashMap.put(PACKAGENAME + "RedHorse", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_horse));
		hashMap.put(PACKAGENAME + "RedGeneral", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_general));
		hashMap.put(PACKAGENAME + "RedElephant", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_elephant));
		hashMap.put(PACKAGENAME + "RedCannon", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_red_cannon));

		hashMap.put(PACKAGENAME + "BlackSoldier", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_black_soldier));
		hashMap.put(PACKAGENAME + "BlackShi", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_black_shi));
		hashMap.put(PACKAGENAME + "BlackHorse", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_black_horse));
		hashMap.put(PACKAGENAME + "BlackGeneral", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_black_general));
		hashMap.put(PACKAGENAME + "BlackElephant", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_black_elephant));
		hashMap.put(PACKAGENAME + "BlackCar", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_black_car));
		hashMap.put(PACKAGENAME + "BlackCannon", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_black_cannon));

		hashMap.put(PACKAGENAME + "RedCar" + "" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_car));
		hashMap.put(PACKAGENAME + "RedSoldier" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_soldier));
		hashMap.put(PACKAGENAME + "RedShi" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_shi));
		hashMap.put(PACKAGENAME + "RedHorse" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_horse));
		hashMap.put(PACKAGENAME + "RedGeneral" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_general));
		hashMap.put(PACKAGENAME + "RedElephant" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_elephant));
		hashMap.put(PACKAGENAME + "RedCannon" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_red_cannon));

		hashMap.put(PACKAGENAME + "BlackSoldier" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_soldier));
		hashMap.put(PACKAGENAME + "BlackShi" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_shi));
		hashMap.put(PACKAGENAME + "BlackHorse" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_horse));
		hashMap.put(PACKAGENAME + "BlackGeneral" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_general));
		hashMap.put(PACKAGENAME + "BlackElephant" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_elephant));
		hashMap.put(PACKAGENAME + "BlackCar" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_car));
		hashMap.put(PACKAGENAME + "BlackCannon" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_black_cannon));
		
		
		hashMap.put(PACKAGENAME + "UnFlip", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.dark_unflip));
		
		hashMap.put(PACKAGENAME + "UnFlip" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_selected_unflip));
		
		hashMap.put("com.oose.darkchess.DarkChessBoard", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_chessboard));
		
		hashMap.put(DarkChessView.FRAME, BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.dark_frame));
	}

	public static Bitmap getIcon(String key) {
		if (hashMap == null)
			initializeMap();
		return hashMap.get(key);
	}
}
