package two_pointer.Two_Sum_II;

class Solution {
    /* HashMap
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int s = target - numbers[i];
            if (map.containsKey(s))
                return new int[] {map.get(s), i+1};
            map.put(numbers[i], i+1);
        }
        throw new ArrayStoreException();
    }*/

    // Two-Pointer
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            int s = numbers[l] + numbers[r];
            if (s < target) l++;
            else r--;
        }
        return new int[] {l+1, r+1};
    }
}