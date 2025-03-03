# Introduction
problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

## Description
You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.
Find the maximum profit you can achieve. You may complete as many transactions as you like(i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

- After you sell the stock, you cannot buy stock on the next day(i.e., cooldown one day).
- Note: You may not engage in multiple transactions simultaneously(i.e., you must sell the stock before you buy again).

### Example 1

```plaintext
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
```

### Example 2
```plaintext
Input: prices = [1]
Output: 0
```

# Solution

## Hint


## Approach
We have three states:
- `buy`: The maximum profit we can have if we buy the stock on the `ith` day.
- `sell`: The maximum profit we can have if we sell the stock on the `ith` day.
- `cooldown`: The maximum profit we can have if we do nothing on the `ith` day.

We need to keep track of the maximum profit we can have on each state.

## Explanation
1. We initialize the `hold`, `sell`, and `cooldown` variables to the first element of the prices array.
    - `hold = -prices[0]` we buy the stock on the first day so the profit is negative
    - `sell = 0` we cannot sell the stock on the first day
    - `cooldown = 0` we cannot do anything on the first day
2. we iterate over the prices array starting from the second element.
    - we update the `buy` variable by:
        - 
    -  we update the `sell` variable by:
        -
    -  we update the `cooldown` variable by:
        -
3. 

## Time complexity
The time complexity is O(n) where n is the length of the prices array.

## Code
```java
// [1,2,3,0,2]
class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int cooldown = 0;
        int free = 0;

        for(int i = 1; i < prices.length; i++) {
           int prevHold = hold;
           hold = Math.max(hold, free - prices[i]);
           cooldown = Math.max(prices[i] - prevHold, free);
            free = Math.max(cooldown, hold);
        }

        return Math.max(sellfree, cooldown);
    }
}
```