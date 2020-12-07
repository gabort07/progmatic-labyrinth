package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {

    CellType[][] lField;

    public LabyrinthImpl() {

    }

    @Override
    public int getWidth() {
        if (lField == null) {
            return -1;
        }
        return lField.length;
    }

    @Override
    public int getHeight() {
        if (lField == null) {
            return -1;
        }
        return lField[0].length;
    }

    @Override
    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
            this.lField = new CellType[width][height];
            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    CellType type = null;
                    switch (line.charAt(ww)) {
                        case 'W':
                            type = CellType.WALL;
                            break;
                        case 'E':
                            type = CellType.END;
                            break;
                        case 'S':
                            type = CellType.START;
                            break;
                        case ' ':
                            type = CellType.EMPTY;
                    }
                    this.lField[ww][hh] = type;
                }
            }
        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        if (c.getCol() < 0 || c.getRow() < 0 || c.getRow() > getHeight()-1 || c.getCol() > getWidth()-1) {
            throw new CellException(c, "A kordináta kívûl esik a labirintuson");
        }
        return this.lField[c.getRow()][c.getCol()];
    }

    @Override
    public void setSize(int width, int height) {
        lField = new CellType[width][height];
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {
        if (c.getCol() < 0 || c.getRow() < 0 || c.getRow() > getHeight() || c.getCol() > getWidth()) {
            throw new CellException(c, "A kordináta kívûl esik a labirintuson");
        }
        lField[c.getRow()][c.getCol()] = type;
    }

    @Override
    public Coordinate getPlayerPosition() {
        return null;
    }

    @Override
    public boolean hasPlayerFinished() {
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        return null;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {

    }

}
