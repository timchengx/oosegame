package com.oose.factory;

import com.oose.chessgame.chinesechessman.BlackCannon;
import com.oose.chessgame.chinesechessman.BlackCar;
import com.oose.chessgame.chinesechessman.BlackElephant;
import com.oose.chessgame.chinesechessman.BlackGeneral;
import com.oose.chessgame.chinesechessman.BlackHorse;
import com.oose.chessgame.chinesechessman.BlackShi;
import com.oose.chessgame.chinesechessman.BlackSoldier;
import com.oose.chessgame.chinesechessman.RedCannon;
import com.oose.chessgame.chinesechessman.RedCar;
import com.oose.chessgame.chinesechessman.RedElephant;
import com.oose.chessgame.chinesechessman.RedGeneral;
import com.oose.chessgame.chinesechessman.RedHorse;
import com.oose.chessgame.chinesechessman.RedShi;
import com.oose.chessgame.chinesechessman.RedSoldier;
import com.oose.chinesechess.ChineseChessBoard;
import com.oose.prototype.ChessMan;

public class ChineseChessBoardFactory {
	public static ChessMan[][] makeNewChineseChessBoard(ChineseChessBoard board) {
		ChessMan[][] chinese = new ChessMan[10][9];
		
		chinese[2][1] = new RedCannon(2,1, board);
		chinese[2][7] = new RedCannon(2,7, board);
		chinese[0][4] = new RedGeneral(0,4, board);
		chinese[3][0] = new RedSoldier(3,0, board);
		chinese[3][2] = new RedSoldier(3,2, board);
		chinese[3][4] = new RedSoldier(3,4, board);
		chinese[3][6] = new RedSoldier(3,6, board);
		chinese[3][8] = new RedSoldier(3,8, board);
		chinese[0][0] = new RedCar(0,0, board);
		chinese[0][8] = new RedCar(0,8, board);
		chinese[0][2] = new RedElephant(0,2, board);
		chinese[0][6] = new RedElephant(0,6, board);
		chinese[0][1] = new RedHorse(0,1, board);
		chinese[0][7] = new RedHorse(0,7, board);
		chinese[0][3] = new RedShi(0,3, board);
		chinese[0][5] = new RedShi(0,5, board);
		chinese[7][1] = new BlackCannon(7,1, board);
		chinese[7][7] = new BlackCannon(7,7, board);
		chinese[9][4] = new BlackGeneral(9,4, board);
		chinese[6][0] = new BlackSoldier(6,0, board);
		chinese[6][2] = new BlackSoldier(6,2, board);
		chinese[6][4] = new BlackSoldier(6,4, board);
		chinese[6][6] = new BlackSoldier(6,6, board);
		chinese[6][8] = new BlackSoldier(6,8, board);
		chinese[9][0] = new BlackCar(9,0, board);
		chinese[9][8] = new BlackCar(9,8, board);
		chinese[9][2] = new BlackElephant(9,2, board);
		chinese[9][6] = new BlackElephant(9,6, board);
		chinese[9][1] = new BlackHorse(9,1, board);
		chinese[9][7] = new BlackHorse(9,7, board);
		chinese[9][3] = new BlackShi(9,3, board);
		chinese[9][5] = new BlackShi(9,5, board);
		
		return chinese;
	}
}
