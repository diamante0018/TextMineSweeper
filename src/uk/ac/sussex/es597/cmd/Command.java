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
package uk.ac.sussex.es597.cmd;

/**
 *
 * @author es597 CandNo: 215755
 * A representation of what the user wants the game to do next
 */
public class Command {
    private CommandWord command;
    private int row = 0;
    private int column = 0;
    private String msg = "";
    
    /** 
     * Initialise with a Command and a message (which may be empty) 
     * @param command The command
     * @param msg The message
     */
    public Command(CommandWord command, String msg) {
        this.command = command;
        this.msg = msg;
    }
    /** 
     * Messages are currently only associated with "unknown" commands 
     * @return the message associated with the command 
     */
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    /** 
     * If we have a command that operated on coordinates, instantiate with the  
     * correct row and column 
     * @param command The command
     * @param row The row
     * @param column The column
     */
    public Command(CommandWord command, int row, int column) {
        //super();
        this.command = command;
        this.row = row;
        this.column = column;
    }
    
    @Override
    public String toString() {
        return "Command " + command + ", row=" + row + ", column=" + column;
    }
    
    /**
    * Principally to be used in a switch statement to decide on the 
    * action to be taken, given this command 
    * @return the CommandWord  
    */
    public CommandWord getCommand() {
        return command;
    }
    
    public void setCommand(CommandWord command) {
        this.command = command;
    }
    
    /** 
     * Valid for commands which need a row and column value 
     * @return The row value 
     */
    public int getRow() {
        return row;
    }
    
    /** 
     * Valid for commands which need a row and column value 
     * @param row The row
     */
    public void setRow(int row) {
        this.row = row;
    }
    
    /** 
     * Valid for commands which need a row and column value 
     * @return The column value 
     */
    public int getColumn() {
        return column;
    }
    
    /** 
     * Valid for commands which need a row and column value 
     * @param column The column
     */
    public void setColumn(int column) {
        this.column = column;
    }
}
