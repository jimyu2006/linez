package com.example.m787757.linez;

import org.junit.Test;

import static com.example.m787757.linez.Constants.gridCount;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private GridAttribute[][] InitGrid(){
        GridAttribute[][] board = new GridAttribute[gridCount][gridCount];

        for (int i = 0; i < gridCount; i++) {
            for (int j = 0; j < gridCount; j++) {
                board[i][j] = new GridAttribute(null, Constants.Status.BLANK);
            }
        }
        return  board;
    }



    @Test
    public void grid_Horizontal_Check_isCorrect() {

        GridAttribute[][] board=InitGrid();

        board[0][0].status=Constants.Status.USED;
        board[1][1].status=Constants.Status.USED;
        board[2][2].status=Constants.Status.USED;
        board[3][3].status=Constants.Status.USED;
        board[4][4].status=Constants.Status.USED;

        GridAttribute[][] updatedBoard=Grid.lineCheck(board);
        assertEquals(updatedBoard[4][0].status, Constants.Status.TOBEREMOVED);
    }

    @Test
    public void grid_Vertical_Check_isCorrect() {
        GridAttribute[][] board = InitGrid();

        board[0][0].status=Constants.Status.USED;
        board[0][1].status=Constants.Status.USED;
        board[0][2].status=Constants.Status.USED;
        board[0][3].status=Constants.Status.USED;
        board[0][4].status=Constants.Status.USED;

        GridAttribute[][] updatedBoard=Grid.lineCheck(board);
        assertEquals(updatedBoard[0][4].status, Constants.Status.TOBEREMOVED);
    }

    @Test
    public void grid_Diagnose_Check_isCorrect() {
        GridAttribute[][] board = InitGrid();

        board[3][3].status=Constants.Status.USED;
        board[4][4].status=Constants.Status.USED;
        board[5][5].status=Constants.Status.USED;
        board[6][6].status=Constants.Status.USED;
        board[7][7].status=Constants.Status.USED;

        GridAttribute[][] updatedBoard=Grid.lineCheck(board);
        assertEquals(updatedBoard[0][4].status, Constants.Status.TOBEREMOVED);
    }
}