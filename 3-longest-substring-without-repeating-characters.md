# Introduction
problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/

## Description
Given a string s, find the length of the longest substring without repeating characters.

## Example

### Example 1

```plaintext
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

### Example 2

```plaintext
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

### Example 3

```plaintext
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

## Constraints
- 0 <= s.length <= 5 * 104

- s consists of English letters, digits, symbols and spaces.

---

# Solution

## Approach
We can solve this problem using a sliding window approach.
We will use a dictionary to store the index of the last occurrence of each character. In Java we can use a HashSet to store the characters of the current substring.


## Explanation

1. We will initialize 2 pointers `aPointer` and `bPointer` to 0, and a variable `max` to 0.

2. We will iterate over the string `s` using the `bPointer`
- If the character at `bPointer` is not in the HashSet, we will add it to the HashSet and increment the `bPointer`.
- Current max length is the maximum of HashSet size and the current `max`.
- If the character at `bPointer` is in the HashSet, we will remove the character at `aPointer` from the HashSet and increment the `aPointer`.

3. We will return the `max` value.

## Time complexity
The time complexity is O(n) where n is the length of the string `s`.

## Space complexity
The space complexity is O(min(n, m)) where n is the length of the string `s` and m is the size of the character set.

## Code
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;
        HashSet<Character> charMap = new HashSet<Character>();

        while(bPointer < s.length()) {
            if(!charMap.contains(s.charAt(bPointer))) {
                charMap.add(s.charAt(bPointer));
                max = Math.max(charMap.size(), max);
                bPointer++;
            } else {
                charMap.remove(s.charAt(aPointer));
                aPointer++;
            }
        }
        return max;
    }
}
```