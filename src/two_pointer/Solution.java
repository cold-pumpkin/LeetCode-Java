package two_pointer;

public class Solution {

    public int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                // 오른쪽 높이가 더 클 경우 왼쪽 높이를 기억해두고, 왼쪽 인덱스 증가시키면서
                // 기억해둔 높이보다 더 큰 높이를 만날 때 까지 가능한 양을 채움
                int curHeight = height[l];
                while (height[++l] < curHeight)
                    ans += curHeight - height[l];
            } else {
                int curHeight = height[r];
                while (height[--r] < curHeight)
                    ans += curHeight - height[r];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height));
    }
}
