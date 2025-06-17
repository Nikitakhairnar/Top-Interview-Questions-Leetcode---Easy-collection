//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/

//Problem description - Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

import java.util.HashSet;

/************************* SOLUTION *************************/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] squares = new HashSet[3][3];

        // Initialize sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new HashSet<>();
            }
        }

        // Validate board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.')
                    continue;

                if (rows[r].contains(val) ||
                        cols[c].contains(val) ||
                        squares[r / 3][c / 3].contains(val)) {
                    return false;
                }

                rows[r].add(val);
                cols[c].add(val);
                squares[r / 3][c / 3].add(val);
            }
        }

        return true;

    }
}