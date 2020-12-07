package com.progmatic.labyrinthproject.enums;

/**
 * @author pappgergely
 */
public enum CellType {
    // Either a wall, or empty cell
    WALL("#"), EMPTY(" "),
    // or or the start or ending cell
    START("S"), END("E");

    private final String type;

    CellType(String newType) {
        type = newType;
    }

    public String getType() {
        return type;
    }

}

