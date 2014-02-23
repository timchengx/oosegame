/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
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

/* a DarkChessBoard factory, create a brand new DarkChessBoard */
public class DarkChessBoardFactory {
  public static DarkChessMan[][] makeNewDarkChessBoard(DarkChessBoard darkChessBoard) {
    DarkChessMan[][] dark = new DarkChessMan[4][8];

    int i, j;
    int swap;
    int randomA;
    int random[] =
        {0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27,
            30, 31, 32, 33, 34, 35, 36, 37};
    for (i = 0; i < 32; i++) {
      randomA = (int) (Math.random() * 32);
      swap = random[i];
      random[i] = random[randomA];
      random[randomA] = swap;
    }

    i = random[0] / 10;
    j = random[0] % 10;
    dark[i][j] = new RedCannon(i, j, darkChessBoard);
    i = random[1] / 10;
    j = random[1] % 10;
    dark[i][j] = new RedCannon(i, j, darkChessBoard);
    i = random[2] / 10;
    j = random[2] % 10;
    dark[i][j] = new RedGeneral(i, j, darkChessBoard);
    i = random[3] / 10;
    j = random[3] % 10;
    dark[i][j] = new RedSoldier(i, j, darkChessBoard);
    i = random[4] / 10;
    j = random[4] % 10;
    dark[i][j] = new RedSoldier(i, j, darkChessBoard);
    i = random[5] / 10;
    j = random[5] % 10;
    dark[i][j] = new RedSoldier(i, j, darkChessBoard);
    i = random[6] / 10;
    j = random[6] % 10;
    dark[i][j] = new RedSoldier(i, j, darkChessBoard);
    i = random[7] / 10;
    j = random[7] % 10;
    dark[i][j] = new RedSoldier(i, j, darkChessBoard);
    i = random[8] / 10;
    j = random[8] % 10;
    dark[i][j] = new RedCar(i, j, darkChessBoard);
    i = random[9] / 10;
    j = random[9] % 10;
    dark[i][j] = new RedCar(i, j, darkChessBoard);
    i = random[10] / 10;
    j = random[10] % 10;
    dark[i][j] = new RedElephant(i, j, darkChessBoard);
    i = random[11] / 10;
    j = random[11] % 10;
    dark[i][j] = new RedElephant(i, j, darkChessBoard);
    i = random[12] / 10;
    j = random[12] % 10;
    dark[i][j] = new RedHorse(i, j, darkChessBoard);
    i = random[13] / 10;
    j = random[13] % 10;
    dark[i][j] = new RedHorse(i, j, darkChessBoard);
    i = random[14] / 10;
    j = random[14] % 10;
    dark[i][j] = new RedShi(i, j, darkChessBoard);
    i = random[15] / 10;
    j = random[15] % 10;
    dark[i][j] = new RedShi(i, j, darkChessBoard);
    i = random[16] / 10;
    j = random[16] % 10;
    dark[i][j] = new BlackCannon(i, j, darkChessBoard);
    i = random[17] / 10;
    j = random[17] % 10;
    dark[i][j] = new BlackCannon(i, j, darkChessBoard);
    i = random[18] / 10;
    j = random[18] % 10;
    dark[i][j] = new BlackGeneral(i, j, darkChessBoard);
    i = random[19] / 10;
    j = random[19] % 10;
    dark[i][j] = new BlackSoldier(i, j, darkChessBoard);
    i = random[20] / 10;
    j = random[20] % 10;
    dark[i][j] = new BlackSoldier(i, j, darkChessBoard);
    i = random[21] / 10;
    j = random[21] % 10;
    dark[i][j] = new BlackSoldier(i, j, darkChessBoard);
    i = random[22] / 10;
    j = random[22] % 10;
    dark[i][j] = new BlackSoldier(i, j, darkChessBoard);
    i = random[23] / 10;
    j = random[23] % 10;
    dark[i][j] = new BlackSoldier(i, j, darkChessBoard);
    i = random[24] / 10;
    j = random[24] % 10;
    dark[i][j] = new BlackCar(i, j, darkChessBoard);
    i = random[25] / 10;
    j = random[25] % 10;
    dark[i][j] = new BlackCar(i, j, darkChessBoard);
    i = random[26] / 10;
    j = random[26] % 10;
    dark[i][j] = new BlackElephant(i, j, darkChessBoard);
    i = random[27] / 10;
    j = random[27] % 10;
    dark[i][j] = new BlackElephant(i, j, darkChessBoard);
    i = random[28] / 10;
    j = random[28] % 10;
    dark[i][j] = new BlackHorse(i, j, darkChessBoard);
    i = random[29] / 10;
    j = random[29] % 10;
    dark[i][j] = new BlackHorse(i, j, darkChessBoard);
    i = random[30] / 10;
    j = random[30] % 10;
    dark[i][j] = new BlackShi(i, j, darkChessBoard);
    i = random[31] / 10;
    j = random[31] % 10;
    dark[i][j] = new BlackShi(i, j, darkChessBoard);
    return dark;
  }

}
