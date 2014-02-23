/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.chinesechess;

import com.oose.prototype.Coordinate;

public class ChineseChessCoordinate extends Coordinate {

  private static final long serialVersionUID = 4461799999953227840L;

  @Override
  public void convertToBoard(int x, int y) {
    if (x <= 480) { // board size
      resultX = (x - 6) / 52;
      if (resultX == 9) {
        resultX = resultX - 1;
      }
    }

    if (y <= 532) { // board size
      resultY = (y - 6) / 52;
      if (resultY == 10) {
        resultY = resultY - 1;
      }
    }
  }

  @Override
  public void convertToScreen(int x, int y) {
    switch (x) {
      case 0:
        resultX = 8;
        break;
      case 1:
        resultX = 60;
        break;
      case 2:
        resultX = 112;
        break;
      case 3:
        resultX = 164;
        break;
      case 4:
        resultX = 216;
        break;
      case 5:
        resultX = 268;
        break;
      case 6:
        resultX = 320;
        break;
      case 7:
        resultX = 372;
        break;
      case 8:
        resultX = 424;
        break;
      default:
        x = -1;
        break;
    }
    switch (y) {
      case 0:
        resultY = 8;
        break;
      case 1:
        resultY = 60;
        break;
      case 2:
        resultY = 112;
        break;
      case 3:
        resultY = 164;
        break;
      case 4:
        resultY = 216;
        break;
      case 5:
        resultY = 268;
        break;
      case 6:
        resultY = 320;
        break;
      case 7:
        resultY = 372;
        break;
      case 8:
        resultY = 424;
        break;
      case 9:
        resultY = 476;
      default:
        y = -1;
    }
  }
}
