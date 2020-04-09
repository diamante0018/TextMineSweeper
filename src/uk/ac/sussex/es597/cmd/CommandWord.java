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
 * A simple enumeration to represent the possible commands that can be given to the 
 * minesweeper game.  
 * Note that the enumeration words all start with different characters.
 */
public enum CommandWord {
    QUIT("quit"),
    MARK("mark"),
    STEP("step"),
    NEW("new"),
    UNKNOWN("unknown");
    
    private String word;
    
    CommandWord(String word) {
        this.word = word;
    }
    
    /** 
     * Given the current word that the user has typed, convert it to lower case and see 
     * if it matches the beginning of any of our command words.  If so, return the word 
     * @param s The current user input word 
     * @return The corresponding command word 
     */
    public static CommandWord getCommandWord(String s) {
        for(CommandWord c : CommandWord.values()) {
            if(c.getWord().startsWith(s.toLowerCase())) {
                return c;
            }
        }
        return UNKNOWN;
    }
    
    /** 
     * @return the string representing the command 
     */
    public String getWord() {
        return this.word;
     }
}
