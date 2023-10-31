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
        assertEquals(result.get(14),14);
        assertNotEquals(result.get(3),15);
    }
}