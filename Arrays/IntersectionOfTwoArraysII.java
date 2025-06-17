//Problem link - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

//Problem Description - Given two integer arrays nums1 and nums2, return an array of their intersection. 
// Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/************************* SOLUTION *************************/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums1)
            count.put(num, count.getOrDefault(num, 0) + 1);

        for (final int num : nums2)
            if (count.containsKey(num) && count.get(num) > 0) {
                ans.add(num);
                count.put(num, count.get(num) - 1);
            }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}