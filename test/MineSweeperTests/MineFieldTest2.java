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

package MineSweeperTests;

import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.sussex.es597.*;

/**
 *
 * @author es597 
 */
public class MineFieldTest2 {
   
   @Test
   public void testSimpleMarked() {
       MineField f = new MineField(10,10,10);
       assertEquals(false,f.isMarked(0,0));
       
       f.markTile(0,0);       
       assertEquals(true,f.isMarked(0,0));
       
       f.markTile(0,0);
       assertEquals(false,f.isMarked(0,0));
       assertEquals(false,f.isMarked(0,1)); //Random cord
   }
   
   @Test
   public void testSimpleReveal() {
       MineField f = new MineField(10,10,10);
       assertEquals(false,f.isRevealed(0,0));
       
       f.revealTile(0,0);
       assertEquals(true,f.isRevealed(0,0));
   }
   
   @Test
   public void testStep() {
     MineField f = new MineField(10,10,10);
     f.mineTile(1, 0);
     f.mineTile(1, 1);
     f.mineTile(1, 2);
     f.mineTile(1, 3);
     assertEquals(true,f.mineTile(0, 3));
     
     assertEquals(true,f.step(0,0));
     assertEquals(false,f.isRevealed(0,1));
     assertEquals(true,f.isRevealed(0,0));
     
     assertEquals(true,f.step(0,1));
     assertEquals(true,f.isRevealed(0,1));     
   }
   
   @Test
   public void testGameEnd() {
    MineField f = new MineField(10,10,1);
    assertEquals(true,f.mineTile(9, 9));
    assertEquals(false,f.step(9,9));
    
    f.markTile(9, 9);
    assertEquals(true,f.step(0,0)); 
    assertEquals(true,f.areAllMinesRevealed());
   }
   
   @Test
   public void testNewString() {
    MineField f = new MineField(10,10,2);
    
    //System.out.println(f.newToString());
    
    assertEquals(true,f.mineTile(9, 9));
    //System.out.println(f);
    //assertEquals(false,f.step(9,9));
    
    f.markTile(9, 9);
    assertEquals(true,f.mineTile(5, 5));
    
    //System.out.println(f);
    
    assertEquals(true,f.step(0,0)); 
    
    
    System.out.println(f.newToString());
    
    assertEquals(false,f.areAllMinesRevealed());
    
    f.markTile(5, 5);
    
    assertEquals(true,f.areAllMinesRevealed());
    System.out.println(f.newToString());
   }
   
}
