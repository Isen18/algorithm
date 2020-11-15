/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
      // Map<Character, Integer> map = new HashMap<>(s.length());
        // int maxLen = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     Integer index = map.get(c);
        //     if (index == null) {
        //         map.put(c, i);
        //         if (maxLen < map.size()) {
        //             maxLen = map.size();
        //         }
        //     } else {
        //         i = index;
        //         map.clear();
        //     }
        // }

        // return maxLen;

        // int n = s.length();
        // Set<Character> set = new HashSet<>();
        // int ans = 0, i = 0, j = 0;
        // while (i < n && j < n) {
        //     // try to extend the range [i, j]
        //     if (!set.contains(s.charAt(j))){
        //         set.add(s.charAt(j++));
        //         ans = Math.max(ans, j - i);
        //     }
        //     else {
        //         set.remove(s.charAt(i++));
        //     }
        // }
        // return ans;

        // int n = s.length(), ans = 0;
        // Map<Character, Integer> map = new HashMap<>(); // current index of character
        // // try to extend the range [i, j]
        // for (int j = 0, i = 0; j < n; j++) {
        //     if (map.containsKey(s.charAt(j))) {
        //         i = Math.max(map.get(s.charAt(j)), i);
        //     }
        //     ans = Math.max(ans, j - i + 1);
        //     map.put(s.charAt(j), j + 1);
        // }
        // return ans;

        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
// @lc code=end