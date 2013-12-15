package com.oose.factory;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.oose.game.OOSEGame;
import com.oose.game.R;

public class ChineseChessPictureList {

	private static HashMap<String, Bitmap> hashMap;
    private static void initializeMap() {
    	hashMap = new HashMap<String, Bitmap>();
    	hashMap.put("com.oose.chessgame.chinesechessman.RedCarSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_car));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedSoldierSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_soldier));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedShiSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_shi));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedHorseSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_horse));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedGeneralSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_general));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedElephantSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_elephant));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedCannonSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_red_cannon));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackSoldierSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_soldier));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackShiSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_shi));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackHorseSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_horse));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackGeneralSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_general));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackElephantSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_elephant));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackCarSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_car));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackCannonSELECTED", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_selected_black_cannon));
    	
    	hashMap.put("com.oose.chessgame.chinesechessman.RedCar", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_car));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedSoldier", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_soldier));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedShi", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_shi));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedHorse", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_horse));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedGeneral", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_general));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedElephant", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_elephant));
    	hashMap.put("com.oose.chessgame.chinesechessman.RedCannon", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_red_cannon));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackSoldier", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_soldier));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackShi", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_shi));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackHorse", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_horse));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackGeneral", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_general));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackElephant", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_elephant));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackCar", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_car));
    	hashMap.put("com.oose.chessgame.chinesechessman.BlackCannon", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_black_cannon));
    	
    	hashMap.put("com.oose.chinesechess.ChineseChessBoard", BitmapFactory.decodeResource(OOSEGame.getRes(), R.drawable.chinese_chessboard));

    }
    public static Bitmap getIcon(String key) {
    	if(hashMap == null)
    		initializeMap();
    	return hashMap.get(key);
    }
}
