package two_pointer.Find_the_Duplicate_Number;

class Solution {
    // Floyd's Tortoise and Hare (Cycle Detection)
    public int findDuplicate(int[] nums) {
        // intersection 찾기
        int tortoise = nums[0], hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // 사이클의 입구 찾기 : 토끼 놔두고 거북이 출발점으로 가서 각각 한 칸 씩 이동
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}

class Main {
    public static void main(String[] args) {

    }
}