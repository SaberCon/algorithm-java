package cn.sabercon.algorithm.q200.q180;

/**
 * Dungeon Game
 * <p>
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)   -3	    3
 * -5	    -10 	1
 * 10	    30	    -5 (P)
 * <p>
 * Note:
 * <p>
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 * @author ywk
 * @date 2020-03-28
 */
public class Q174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] cache = new int[dungeon.length][dungeon[0].length];
        return calc(dungeon, cache, 0, 0);
    }

    private int calc(int[][] dungeon, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int hp = 0;
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
            hp = Math.max(1, 1 - dungeon[i][j]);
        } else if (i == dungeon.length - 1) {
            hp = Math.max(1, calc(dungeon, cache, i, j + 1) - dungeon[i][j]);
        } else if (j == dungeon[0].length - 1) {
            hp = Math.max(1, calc(dungeon, cache, i + 1, j) - dungeon[i][j]);
        } else {
            hp = Math.max(1, Math.min(calc(dungeon, cache, i + 1, j), calc(dungeon, cache, i, j + 1)) - dungeon[i][j]);
        }
        cache[i][j] = hp;
        return hp;
    }
}
