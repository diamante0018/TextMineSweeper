/*
 * Copyright (C) 2020 Edoardo Sanguineti
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.ac.sussex.es597;

import java.util.Scanner;
import uk.ac.sussex.es597.cmd.*;

/**
 * The class that powers the game
 * @author es597
 */
public class MineSweeper {    
    private Parser parser;
    private final int row=10,column=10;
    private final int maxMines = (row*column) - 1;
    private MineField field;
    
    /**
     * Mine field constructor, let's the user decide the number of mines but the maximum is 99
     * @param mines The number of mines
     */
    public MineSweeper(int mines) {
        field = new MineField(row,column,this.maxMinesCalc(mines));
        parser = new Parser();
    }
    
    /**
     * Safeguard
     * @param mines
     * @return The mines that the user typed or the maximum allowed
     */
    private int maxMinesCalc(int mines) {
        if(mines > maxMines)
            return maxMines;
        
        return mines;
    }
    
    /**
     * This method mines the field with the required number of mines
     */
    public void populate() {
        this.field.populate();
    }
    
    /**
     * This method returns the command
     * @return Command The command
     */
    public Command getCmd() {
        return parser.getCommand();
    }
    
    /**
     * Uses the 'new' String representation
     * @return 
     */
    @Override
    public String toString() {
        return this.field.newToString();
    }
    
    /**
     * Equivalent of the step method
     * @param x row
     * @param y column
     * @return boolean true if the tile x,y was not a mine
     */
    public boolean play(int x,int y) {
        return this.field.step(x, y);
    }
    
    /**
     * Marks the tile with a '?' 
     * All mines must be marked to win
     * @param x row
     * @param y column
     */
    public void mark(int x,int y) {
        this.field.markTile(x, y);
    }
    
    /**
     * Checks if the game has ended
     * @return boolean true if it's over
     */
    public boolean gameEnd() {
        return this.field.areAllMinesRevealed();
    }
    
    
    public static void main(String[] args) {
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        System.out.println("Type the number of mines you want in");
        int mines = in.nextInt();
        
        MineSweeper s = new MineSweeper(mines);
        Command cmd;
        s.populate();
        System.out.println("There are " + mines + " mines hidden");
        
        while(playing) {
            System.out.println(s);
            cmd = s.getCmd();
            
            switch(cmd.getCommand()) {
                case QUIT:
                    playing = false;
                    break;
                case STEP:
                    if(!s.play(cmd.getRow(),cmd.getColumn()))
                        System.out.println("Ouch! You stepped on a mine!");
                    break;
                case MARK:
                    s.mark(cmd.getRow(),cmd.getColumn());
                    break;
                case NEW:
                    System.out.println("New game");
                    s = new MineSweeper(mines);
                    break;
                case UNKNOWN:
                    System.out.println(cmd.getMsg());
                    break;
                default:
                    System.out.println(cmd.getMsg());
                    break;
            }
            
            playing = !s.gameEnd();
        }
        
        System.out.println("Game ended! Congrats");
    }
}
