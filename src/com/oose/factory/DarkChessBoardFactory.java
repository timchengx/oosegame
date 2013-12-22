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
		DarkChessMan[][] dark = new DarkChessMan[4][8];

		dark[0][0] = new BlackCannon(0, 0, darkChessBoard);
		dark[0][1] = new BlackCannon(0, 1, darkChessBoard);

		dark[0][2] = new BlackGeneral(0, 2, darkChessBoard);

		dark[0][3] = new BlackSoldier(0, 3, darkChessBoard);
		dark[0][4] = new BlackSoldier(0, 4, darkChessBoard);
		dark[0][5] = new BlackSoldier(0, 5, darkChessBoard);
		dark[0][6] = new BlackSoldier(0, 6, darkChessBoard);
		dark[0][7] = new BlackSoldier(0, 7, darkChessBoard);

		dark[1][0] = new BlackCar(1, 0, darkChessBoard);
		dark[1][1] = new BlackCar(1, 1, darkChessBoard);

		dark[1][2] = new BlackElephant(1, 2, darkChessBoard);
		dark[1][3] = new BlackElephant(1, 3, darkChessBoard);

		dark[1][4] = new BlackHorse(1, 4, darkChessBoard);
		dark[1][5] = new BlackHorse(1, 5, darkChessBoard);

		dark[1][6] = new BlackShi(1, 6, darkChessBoard);
		dark[1][7] = new BlackShi(1, 7, darkChessBoard);

		dark[2][0] = new RedCannon(2, 0, darkChessBoard);
		dark[2][1] = new RedCannon(2, 1, darkChessBoard);

		dark[2][2] = new RedGeneral(2, 2, darkChessBoard);

		dark[2][3] = new RedSoldier(2, 3, darkChessBoard);
		dark[2][4] = new RedSoldier(2, 4, darkChessBoard);
		dark[2][5] = new RedSoldier(2, 5, darkChessBoard);
		dark[2][6] = new RedSoldier(2, 6, darkChessBoard);
		dark[2][7] = new RedSoldier(2, 7, darkChessBoard);

		dark[3][0] = new RedCar(3, 0, darkChessBoard);
		dark[3][1] = new RedCar(3, 1, darkChessBoard);

		dark[3][2] = new RedHorse(3, 2, darkChessBoard);
		dark[3][3] = new RedHorse(3, 3, darkChessBoard);

		dark[3][4] = new RedElephant(3, 4, darkChessBoard);
		dark[3][5] = new RedElephant(3, 5, darkChessBoard);

		dark[3][6] = new RedShi(3, 6, darkChessBoard);
		dark[3][7] = new RedShi(3, 7, darkChessBoard);

		return dark;
	}

}
