package bttuan2

import java.util.Arrays;

public class FourSum {

    public static int countFourSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) a[i] + a[j] + a[left] + a[right];
                    if (sum == 0) {
                        count++;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return count;
    }
}