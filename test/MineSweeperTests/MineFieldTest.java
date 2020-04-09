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

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.sussex.es597.*;

/**
 *
 * @author es597
 */
public class MineFieldTest {
    
    public MineFieldTest() {
    }
    
    /**@Test Unnecessary test
    public void mineTest() {
        MineField f = new MineField(10,10,10);
        f.populate();
        assertEquals(10,f.getMaxMines());
    }*/  
    
     @Test
    public void testCon() {
        MineField f = new MineField(10,10,5);
        
        assertEquals(10,f.getRows());
        assertEquals(5,f.getMaxMines());
        assertEquals(10,f.getColumns());
    }
    
    @Test 
    public void testMineTile() {
        MineField f = new MineField(10,10,5);
        
        assertEquals(true,f.mineTile(0,0));
        assertEquals(true,f.mineTile(6,4));
        assertEquals(true,f.mineTile(0,1));
        
        assertEquals(true,f.isMined(0,0));
        assertEquals(false,f.isMined(0,7));
        
        assertEquals(false,f.mineTile(6,4));
        assertEquals(false,f.mineTile(0,1));
    }
    
    /** @Test Unnecessary test
    public void testMineTile2() {
       MineField f = new MineField(10,10,5); 
       int x=1,y=10;
       
       try {
           f.mineTile(x,y);
       } 
       
       catch(ArrayIndexOutOfBoundsException e) {
           System.out.println(e + " at Index(es) " + x + " " + y);
           System.out.println("Current bounds are " + f.getRows() + " " + f.getColumns() + " exclusive");
       }
    }*/
    
    @Test
    public void testMineTile3() {
       MineField f = new MineField(10,10,5);
       f.mineTile(0,0);
       assertEquals(-1,f.getMinedNeighbour(0,0));
       
       assertEquals(1,f.getMinedNeighbour(0,1));
       assertEquals(1,f.getMinedNeighbour(1,1));
       assertEquals(1,f.getMinedNeighbour(1,0));
       assertEquals(0,f.getMinedNeighbour(2,2));
       
       f.mineTile(1,1);
       assertEquals(-1,f.getMinedNeighbour(1,1));
       assertEquals(-1,f.getMinedNeighbour(0,0));
       
       assertEquals(2,f.getMinedNeighbour(0,1));
       assertEquals(2,f.getMinedNeighbour(1,0));
       assertEquals(1,f.getMinedNeighbour(2,0));
       assertEquals(1,f.getMinedNeighbour(2,1));
       assertEquals(1,f.getMinedNeighbour(2,2));
       assertEquals(1,f.getMinedNeighbour(0,2));
       assertEquals(1,f.getMinedNeighbour(1,2));
       
       assertEquals(0,f.getMinedNeighbour(3,0));
    }
    
    @Test
    public void testPopulate() {
        MineField f = new MineField(10,10,5);
        f.populate();
        
        assertEquals(5,f.getCtrl());
        assertEquals(false,f.isMined(0,0));
        
       System.out.print("\n" + f + "\n");
    }
    
    @Test
    public void testPopulate2() {
        MineField f = new MineField(10,10,5);
        f.populate(500L);
        Random gen = new Random(500L);
              
        int i = 0;
        while (i < 5) {
           System.out.print(gen.nextInt(10) + ":");
           System.out.println(gen.nextInt(10));
           i++;
        }
        
        assertEquals(5,f.getCtrl());
        assertEquals(false,f.isMined(0,0));
        assertEquals(true,f.isMined(5,4));
        assertEquals(true,f.isMined(2,2));
        assertEquals(true,f.isMined(5,5));
        assertEquals(true,f.isMined(6,8));
        assertEquals(true,f.isMined(7,2));
        
        assertEquals(-1,f.getMinedNeighbour(2,2));
        assertEquals(1,f.getMinedNeighbour(2,3));
        assertEquals(1,f.getMinedNeighbour(1,2));
        
        System.out.print("\n" + f + "\n");
    }
    
    @Test
    public void testPopulate3() {
        MineField f = new MineField(10,10,99);
        f.populate();
        assertEquals(false,f.isMined(0, 0));
        System.out.println("\n" + f + "\n");
        
        assertEquals(f.getMaxMines(),99);
        assertEquals(f.getMaxMines(),f.getCtrl());
    }
    
    @Test
    public void testToString() {
        MineField f = new MineField(10,10,20);
        f.populate();
        assertEquals(false,f.isMined(0,0));
        assertEquals(20,f.getCtrl());
        
        System.out.print("\n" + f + "\n");
    }
    
    @Test
    public void testToString2() {
        MineField f = new MineField(11,11,18);
        f.mineTile(0,0);
        f.mineTile(1,0);
        f.mineTile(2,0);
        f.mineTile(2,1);
        f.mineTile(2,2);
        
        f.mineTile(0,4);
        f.mineTile(0,5);
        f.mineTile(0,6);
        f.mineTile(2,4);
        f.mineTile(2,5);
        f.mineTile(2,6);
        f.mineTile(1,4);
        f.mineTile(1,6);
        
        f.mineTile(0,8);
        f.mineTile(1,8);
        f.mineTile(2,8);
        f.mineTile(2,9);
        f.mineTile(2,10);
        
        System.out.print("\n" + f + "\n");
        //The x of the mines from the letters "L O L"
        
        String lolTest = "x202xxx4x20\n" +
                         "x524x8x6x52\n" +
                         "xxx3xxx4xxx\n" +
                         "23222322232\n" +
                         "00000000000\n" +
                         "00000000000\n" +
                         "00000000000\n" +
                         "00000000000\n" +
                         "00000000000\n" +
                         "00000000000\n" +
                         "00000000000\n";
        
        assertEquals(lolTest,f.toString());
    }    
}
