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
import com.oose.chinesechess.ChineseChessMan;

/* a ChineseChessBoard factory, create a brand new ChineseChessBoard */
public class ChineseChessBoardFactory {
	public static ChineseChessMan[][] makeNewChineseChessBoard(
			ChineseChessBoard board) {
		ChineseChessMan[][] chinese = new ChineseChessMan[9][10];

		chinese[1][2] = new BlackCannon(1, 2, board);
		chinese[7][2] = new BlackCannon(7, 2, board);

		chinese[4][0] = new BlackGeneral(4, 0, board);

		chinese[0][3] = new BlackSoldier(0, 3, board);
		chinese[2][3] = new BlackSoldier(2, 3, board);
		chinese[4][3] = new BlackSoldier(4, 3, board);
		chinese[6][3] = new BlackSoldier(6, 3, board);
		chinese[8][3] = new BlackSoldier(8, 3, board);

		chinese[0][0] = new BlackCar(0, 0, board);
		chinese[8][0] = new BlackCar(8, 0, board);

		chinese[2][0] = new BlackElephant(2, 0, board);
		chinese[6][0] = new BlackElephant(6, 0, board);

		chinese[1][0] = new BlackHorse(1, 0, board);
		chinese[7][0] = new BlackHorse(7, 0, board);

		chinese[3][0] = new BlackShi(3, 0, board);
		chinese[5][0] = new BlackShi(5, 0, board);

		chinese[1][7] = new RedCannon(1, 7, board);
		chinese[7][7] = new RedCannon(7, 7, board);

		chinese[4][9] = new RedGeneral(4, 9, board);

		chinese[0][6] = new RedSoldier(0, 6, board);
		chinese[2][6] = new RedSoldier(2, 6, board);
		chinese[4][6] = new RedSoldier(4, 6, board);
		chinese[6][6] = new RedSoldier(6, 6, board);
		chinese[8][6] = new RedSoldier(8, 6, board);

		chinese[0][9] = new RedCar(0, 9, board);
		chinese[8][9] = new RedCar(8, 9, board);

		chinese[1][9] = new RedHorse(1, 9, board);
		chinese[7][9] = new RedHorse(7, 9, board);

		chinese[2][9] = new RedElephant(2, 9, board);
		chinese[6][9] = new RedElephant(6, 9, board);

		chinese[3][9] = new RedShi(3, 9, board);
		chinese[5][9] = new RedShi(5, 9, board);

		return chinese;
	}
}
