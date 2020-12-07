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
import java.util.Stack;

/**
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {

    CellType[][] lField;
    private Stack<Coordinate> playerMoves = new Stack<>();
    private Coordinate position;

    public Stack<Coordinate> getPlayerMoves() {
        return playerMoves;
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
                            playerMoves.push(new Coordinate(ww, hh));
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
        if (c.getCol() < 0 || c.getRow() < 0 || c.getRow() > getHeight() - 1 || c.getCol() > getWidth() - 1) {
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
        if (c.getCol() < 0 || c.getRow() < 0 || c.getRow() > getHeight() - 1 || c.getCol() > getWidth() - 1) {
            throw new CellException(c, "A kordináta kívûl esik a labirintuson");
        }
        if (type.equals(CellType.START)) {
            playerMoves.push(c);
        }
        lField[c.getRow()][c.getCol()] = type;
    }

    @Override
    public Coordinate getPlayerPosition() {
        return playerMoves.peek();
    }

    @Override
    public boolean hasPlayerFinished() {
        CellType a = lField[getPlayerPosition().getRow()][getPlayerPosition().getCol()];
        return a.equals(CellType.END);
    }

    @Override
    public List<Direction> possibleMoves() {
       List<Direction>  directions = new ArrayList<>();
        for (Direction d: Direction.values()) {
            if(playerMoves.get(0).)
        }

    }

    public boolean isWall(Direction d){
        Coordinate actual = playerMoves.peek();

    }

    public Coordinate fromDirection(Direction direction){
        switch (direction){
            case NORTH ->
        }
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {
        Coordinate newMove;
        Coordinate lastMove = playerMoves.peek();
        switch (direction) {
            case NORTH:
                if (lastMove.getRow() - 1 < 0) {
                    throw new InvalidMoveException();
                } else {
                    playerMoves.push(new Coordinate(lastMove.getCol(), lastMove.getRow() - 1));
                }
                break;
            case SOUTH:
                if (lastMove.getRow() + 1 > getHeight() - 1) {
                    throw new InvalidMoveException();
                } else {
                    playerMoves.push(new Coordinate(lastMove.getCol(), lastMove.getRow() + 1));
                }
                break;
            case EAST:
                if (lastMove.getCol() + 1 > getWidth() - 1) {
                    throw new InvalidMoveException();
                } else {
                    playerMoves.push(new Coordinate(lastMove.getCol() + 1, lastMove.getRow()));
                }
                break;
            case WEST:
                if (lastMove.getCol() - 1 < 0) {
                    throw new InvalidMoveException();
                } else {
                    playerMoves.push(new Coordinate(lastMove.getCol() - 1, lastMove.getRow()));
                }
                break;
        }


    }

}
