/*******************************************************************************
 * Copyright (c) 2013 AUTHORS.txt
 * All rights reserved. Distributed under the terms of the MIT License.
 ******************************************************************************/
package com.oose.darkchess;

import com.oose.prototype.Coordinate;

public class DarkChessCoordinate extends Coordinate {

  private static final long serialVersionUID = 4461799999953227840L;

  @Override
  public void convertToBoard(int x, int y) {
    if (x >= 130 && x <= 480) { // board size
      resultX = (x - 130) / 87;
      if (resultX == 4) {
        resultX = resultX - 1;
      }
    } else {
      resultX = -1;
    }

    if (y <= 700) { // board size
      resultY = y / 87;
      if (resultY == 8) {
        resultY = resultY - 1;
      }
    } else {
      resultY = -1;
    }
  }

  @Override
  public void convertToScreen(int x, int y) {
    switch (x) {
      case 0:
        resultX = 130;
        break;
      case 1:
        resultX = 217;
        break;
      case 2:
        resultX = 304;
        break;
      case 3:
        resultX = 391;
        break;
      // case 4:
      // resultX = 216;
      // break;
      // case 5:
      // resultX = 268;
      // break;
      // case 6:
      // resultX = 320;
      // break;
      // case 7:
      // resultX = 372;
      // break;
      // case 8:
      // resultX = 424;
      // break;
      default:
        x = -1;
        break;
    }
    switch (y) {
      case 0:
        resultY = 0;
        break;
      case 1:
        resultY = 87;
        break;
      case 2:
        resultY = 174;
        break;
      case 3:
        resultY = 261;
        break;
      case 4:
        resultY = 348;
        break;
      case 5:
        resultY = 435;
        break;
      case 6:
        resultY = 522;
        break;
      case 7:
        resultY = 609;
        break;
      // case 8:
      // resultY = 424;
      // break;
      // case 9:
      // resultY = 476;
      default:
        y = -1;
    }
  }
}
