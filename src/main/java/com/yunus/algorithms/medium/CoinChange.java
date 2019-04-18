package com.yunus.algorithms.medium;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Tags: Dynamic Programming
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, 1, amount + 1, amount + 1);
        for (int coin : coins) {
            for (int i = coin; i < res.length; i++) {
                res[i] = Math.min(res[i], res[i - coin] + 1);
            }
        }
        return res[amount] == amount + 1 ? -1 : res[amount];
    }

}
