# Introduction
problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

## Description

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

### Example 1

```plaintext
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
```

### Example 2
```plaintext
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
```

### Example 3
```plaintext
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
```

# Solution

## Hint
Instead of tracking complete transactions, think about adding up all the positive differences between consecutive days.

## Approach
We can solve this problem by iterating over the prices array and adding the positive differences between consecutive days.

## Explanation
1. We will initialize a variable `maxProfit` to 0, `aPointer` to 0, and `bPointer` to 1. 
2. We will iterate over the prices array using the `bPointer`.
    - If the price at `bPointer` is greater than the price at `aPointer`, we will add the difference to `maxProfit`.
    - We will jump `aPointer` to `bPointer`, and increment `bPointer`.
3. We will return the `maxProfit`.

## Time complexity
The time complexity is O(n) where n is the length of the prices array.

## Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int aPointer = 0;
        int bPointer = 1;
        int profit = 0;

        while(bPointer < prices.length) {
            if(prices[bPointer] - prices[aPointer] > 0) {
                profit += prices[bPointer] - prices[aPointer];
              
            }
            aPointer = bPointer;
            bPointer++;
        }

        return profit;

    }
}
```