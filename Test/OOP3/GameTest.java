package OOP3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game testGame = new Game();

    @Test
    public void testWinMatrix(){
        int[][] expectedResult = {  { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 0, 15 } };
        int[][] incorrectMatrix = {  { 1, 2, 3, 4 },
                { 5, 6, 2, 8 },
                { 9, 10, 111, 12 },
                { 13, 14, 10, 15 } };

        int[][]result = new int[4][4];
        testGame.getWinMatrix(result);

        assertArrayEquals(expectedResult, result);
        Assertions.assertNotEquals(result[2][2],incorrectMatrix[2][2]);
        Assertions.assertEquals(result[2][2],expectedResult[2][2]);

    }

    @Test
    public void testGenerateGame(){
        int[][] resultMatrix = new int[4][4];
        ArrayList<Integer> expectedResult = new ArrayList<>();
        for (int i=0; i<16; i++){
            expectedResult.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        testGame.generateGame(resultMatrix);
        for (int i=0; i<resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                result.add(resultMatrix[i][j]);
            }
        }
        Collections.sort(result);

        assert !result.isEmpty();
        assertEquals(result.size(),16);
        assertEquals(result.get(14),expectedResult.get(14));
        assertNotEquals(result.get(3),expectedResult.get(15));
    }

    @Test
    public void testGetIndex(){
        int[][] matrix = {  { 7, 2, 3, 4 },
                { 5, 6, 2, 81 },
                { 9, 10, 111, 12 },
                { 13, 14, 10, 15 } };

        int input = 2;
        int input2 = 111;

        Cell testCell = testGame.getIndex(input,matrix);
        Cell testCell2 = testGame.getIndex(input2,matrix);

        int expectedX = 0;
        int expectedY = 1;
        int expectedX2 = 2;
        int expectedY2 = 2;

        Assertions.assertEquals(expectedX,testCell.getX());
        Assertions.assertEquals(expectedY, testCell.getY());
        Assertions.assertEquals(expectedX2,testCell2.getX());
        Assertions.assertEquals(expectedY2,testCell2.getY());
        Assertions.assertNotEquals(testCell2.getX(), 22);
        Assertions.assertNotEquals(testCell.getY(),12);
    }

    @Test
    public void testGetNeighbours (){
        int[][] matrix = {  { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 0, 15 } };

        Cell testCell = new Cell(0,1);
        ArrayList<Cell> result = testGame.getNeighbours(testCell);

        Cell neighbour = new Cell(1,1);
        Cell neighbour2 = new Cell(0,2);
        Cell neighbour3 = new Cell(0,0);

        assert !result.isEmpty();
        assertEquals(result.size(),3);

        assertEquals(neighbour.getX(),result.get(0).getX());
        assertEquals(neighbour.getY(),result.get(0).getY());

        assertEquals(neighbour2.getY(),result.get(1).getY());
        assertEquals(neighbour2.getY(),result.get(1).getY());

        assertEquals(neighbour3.getY(),result.get(2).getY());
        assertEquals(neighbour3.getY(),result.get(2).getY());

    }
}