package lzf.Greedy;

import java.util.Arrays;

public class Code_45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Code_45().jump(nums));
    }

    // 方法一：正向查找可到达的最大位置

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length -1; i++){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    // 方法一：反向查找出发位置

    /*public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }*/

    // 动态规划

    /*public int jump(int[] nums) {
        // 用个dp数组记录到达当前位置的最小步数， 一步步向后遍历
        int n = nums.length;
        int dp[] = new int[n]; // 动态规划数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        int reach[] = new int[n]; // 每个位置最远可以到达的地方
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            reach[i] = i + num;
            for(int j = 0; j < i; j++) {
                if (reach[j] >= i) { //可以到达当前位置
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

        }
        return dp[n - 1];
    }*/

}
