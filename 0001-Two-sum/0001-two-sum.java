import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];  
            int complement = target - current; 
            if (indexMap.containsKey(complement)) {
                return new int[] {indexMap.get(complement), i};
            }
            indexMap.put(current, i);
        }
       
        throw new IllegalArgumentException("No two sum solution found");
    }
}
