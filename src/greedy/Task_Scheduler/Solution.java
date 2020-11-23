package greedy.Task_Scheduler;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];  // 각 task의 개수
        int max = 0, maxFreq = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxFreq++;
            } else  if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxFreq = 1;
            }
        }
        return Math.max(tasks.length, (max-1) * (n+1) + maxFreq);
    }
}
