package com.oose.factory;

import com.oose.chessgame.darkchessman.BlackCannon;
import com.oose.chessgame.darkchessman.BlackCar;
import com.oose.chessgame.darkchessman.BlackElephant;
import com.oose.chessgame.darkchessman.BlackGeneral;
import com.oose.chessgame.darkchessman.BlackHorse;
import com.oose.chessgame.darkchessman.BlackShi;
import com.oose.chessgame.darkchessman.BlackSoldier;
import com.oose.chessgame.darkchessman.RedCannon;
import com.oose.chessgame.darkchessman.RedCar;
import com.oose.chessgame.darkchessman.RedElephant;
import com.oose.chessgame.darkchessman.RedGeneral;
import com.oose.chessgame.darkchessman.RedHorse;
import com.oose.chessgame.darkchessman.RedShi;
import com.oose.chessgame.darkchessman.RedSoldier;
import com.oose.darkchess.DarkChessBoard;
import com.oose.darkchess.DarkChessMan;

/* a ChineseChessBoard factory, create a brand new ChineseChessBoard */
public class DarkChessBoardFactory {
	public static DarkChessMan[][] makeNewDarkChessBoard(
			DarkChessBoard darkChessBoard) {
		DarkChessMan[][] dark = new DarkChessMan[9][10];

		dark[1][2] = new BlackCannon(1, 2, darkChessBoard);
		dark[7][2] = new BlackCannon(7, 2, darkChessBoard);

		dark[4][0] = new BlackGeneral(4, 0, darkChessBoard);

		dark[0][3] = new BlackSoldier(0, 3, darkChessBoard);
		dark[2][3] = new BlackSoldier(2, 3, darkChessBoard);
		dark[4][3] = new BlackSoldier(4, 3, darkChessBoard);
		dark[6][3] = new BlackSoldier(6, 3, darkChessBoard);
		dark[8][3] = new BlackSoldier(8, 3, darkChessBoard);

		dark[0][0] = new BlackCar(0, 0, darkChessBoard);
		dark[8][0] = new BlackCar(8, 0, darkChessBoard);

		dark[2][0] = new BlackElephant(2, 0, darkChessBoard);
		dark[6][0] = new BlackElephant(6, 0, darkChessBoard);

		dark[1][0] = new BlackHorse(1, 0, darkChessBoard);
		dark[7][0] = new BlackHorse(7, 0, darkChessBoard);

		dark[3][0] = new BlackShi(3, 0, darkChessBoard);
		dark[5][0] = new BlackShi(5, 0, darkChessBoard);

		dark[1][7] = new RedCannon(1, 7, darkChessBoard);
		dark[7][7] = new RedCannon(7, 7, darkChessBoard);

		dark[4][9] = new RedGeneral(4, 9, darkChessBoard);

		dark[0][6] = new RedSoldier(0, 6, darkChessBoard);
		dark[2][6] = new RedSoldier(2, 6, darkChessBoard);
		dark[4][6] = new RedSoldier(4, 6, darkChessBoard);
		dark[6][6] = new RedSoldier(6, 6, darkChessBoard);
		dark[8][6] = new RedSoldier(8, 6, darkChessBoard);

		dark[0][9] = new RedCar(0, 9, darkChessBoard);
		dark[8][9] = new RedCar(8, 9, darkChessBoard);

		dark[1][9] = new RedHorse(1, 9, darkChessBoard);
		dark[7][9] = new RedHorse(7, 9, darkChessBoard);

		dark[2][9] = new RedElephant(2, 9, darkChessBoard);
		dark[6][9] = new RedElephant(6, 9, darkChessBoard);

		dark[3][9] = new RedShi(3, 9, darkChessBoard);
		dark[5][9] = new RedShi(5, 9, darkChessBoard);

		return dark;
	}

}
