package com.oose.factory;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.game.ChineseChessView;
import com.oose.game.OOSEGame;
import com.oose.game.R;


/* a lookup table, for all ChineseChess to get their Bitmap resources */
public class ChineseChessPictureList {
	private static final String PACKAGENAME = "com.oose.chessgame.chinesechessman.";
	private static HashMap<String, Bitmap> hashMap;

	private static void initializeMap() {
		hashMap = new HashMap<String, Bitmap>();

		hashMap.put(PACKAGENAME + "RedCar", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_car));
		hashMap.put(PACKAGENAME + "RedSoldier", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_soldier));
		hashMap.put(PACKAGENAME + "RedShi", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_shi));
		hashMap.put(PACKAGENAME + "RedHorse", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_horse));
		hashMap.put(PACKAGENAME + "RedGeneral", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_general));
		hashMap.put(PACKAGENAME + "RedElephant", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_elephant));
		hashMap.put(PACKAGENAME + "RedCannon", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_red_cannon));

		hashMap.put(PACKAGENAME + "BlackSoldier", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_black_soldier));
		hashMap.put(PACKAGENAME + "BlackShi", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_black_shi));
		hashMap.put(PACKAGENAME + "BlackHorse", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_black_horse));
		hashMap.put(PACKAGENAME + "BlackGeneral", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_black_general));
		hashMap.put(PACKAGENAME + "BlackElephant", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_black_elephant));
		hashMap.put(PACKAGENAME + "BlackCar", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_black_car));
		hashMap.put(PACKAGENAME + "BlackCannon", BitmapFactory.decodeResource(
				OOSEGame.getRes(), R.drawable.chinese_black_cannon));

		hashMap.put(PACKAGENAME + "RedCar" + "" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_car));
		hashMap.put(PACKAGENAME + "RedSoldier" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_soldier));
		hashMap.put(PACKAGENAME + "RedShi" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_shi));
		hashMap.put(PACKAGENAME + "RedHorse" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_horse));
		hashMap.put(PACKAGENAME + "RedGeneral" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_general));
		hashMap.put(PACKAGENAME + "RedElephant" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_elephant));
		hashMap.put(PACKAGENAME + "RedCannon" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_red_cannon));

		hashMap.put(PACKAGENAME + "BlackSoldier" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_soldier));
		hashMap.put(PACKAGENAME + "BlackShi" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_shi));
		hashMap.put(PACKAGENAME + "BlackHorse" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_horse));
		hashMap.put(PACKAGENAME + "BlackGeneral" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_general));
		hashMap.put(PACKAGENAME + "BlackElephant" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_elephant));
		hashMap.put(PACKAGENAME + "BlackCar" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_car));
		hashMap.put(PACKAGENAME + "BlackCannon" + "SELECTED", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_selected_black_cannon));

		hashMap.put("com.oose.chinesechess.ChineseChessBoard", BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_chessboard));
		hashMap.put(ChineseChessView.FRAME, BitmapFactory
				.decodeResource(OOSEGame.getRes(),
						R.drawable.chinese_frame));
	}

	public static Bitmap getIcon(String key) {
		if (hashMap == null)
			initializeMap();
		return hashMap.get(key);
	}
}
