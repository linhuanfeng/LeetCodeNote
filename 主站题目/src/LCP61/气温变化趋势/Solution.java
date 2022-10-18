package LCP61.气温变化趋势;

class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int left = 0, max = 0, right = 1;
        while (right < temperatureA.length) {
            if (check(temperatureA, temperatureB, right)) {
                max = Math.max(right - left, max);
            } else {
                left=right;
            }
            right++;
        }
        return max;
    }

    boolean check(int[] temperatureA, int[] temperatureB, int i) {
        if (temperatureA[i] > temperatureA[i - 1] && temperatureB[i] > temperatureB[i - 1]) {
            return true;
        }
        if (temperatureA[i] < temperatureA[i - 1] && temperatureB[i] < temperatureB[i - 1]) {
            return true;
        }
        if (temperatureA[i] == temperatureA[i - 1] && temperatureB[i] == temperatureB[i - 1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().
                temperatureTrend(new int[]{1,-15,3,14,-1,4,35,36},
                        new int[]{-15,32,20,9,33,4,-1,-5}));
    }
}