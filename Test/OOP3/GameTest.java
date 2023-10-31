package OOP3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}