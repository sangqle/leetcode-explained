# Introduction
problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1555612583/

## Description
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

### Example 1

```plaintext
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

### Example 2
```plaintext
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

# Solution

## Hint
The key is to update the minimum price and the maximum profit while iterating through the prices array.

## Approach

## Explanation
1. Initialize the `maxProfit` to 0 and `minPrice` to the first element of the prices array. Return 0 if the length of the prices array is less than 2.
2. Iterate through the prices array starting from the second element `prices[1]`:
    - Update the `minPrice` if the current price is less than the `minPrice`.
    - Update the `maxProfit` if the difference between the current price `prices[i]` and the `minPrice` is greater than the `maxProfit`.
3. Return the `maxProfit`.

## Time complexity
The time complexity is O(n) where n is the length of the prices array.

## Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
        
    }
}
```