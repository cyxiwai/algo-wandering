package com.xiwai.algorithm.augu24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num51 {
}

class Solution51 {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] char_list : chessBoard) {
            Arrays.fill(char_list, '.');
        }
        backTracing(n, 0, chessBoard);
        return ans;
    }

    public void backTracing(int n, int row, char[][] chessBoard) {
        if (row == n) {
            ans.add(Array_to_list(chessBoard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, chessBoard)) {
                chessBoard[row][i] = 'Q';
                backTracing(n, row + 1, chessBoard);
                chessBoard[row][i] = '.';
            }
        }
    }

    public List<String> Array_to_list(char[][] chessBoard) {
        List<String> temp = new ArrayList<>();
        for (char[] list : chessBoard) {
            temp.add(String.copyValueOf(list));
        }
        return temp;
    }

    public boolean isValid(int row, int col, int n, char[][] chessBoard) {
        for (int i = 0; i < row; ++i) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {

            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}