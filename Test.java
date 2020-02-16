import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String args[]) {
        System.out.println();
        System.out.println();
        System.out.println();

        int[] a = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int[] b = { 1, 1, 2, 1, 1 };
        int[] c = { 2, 4, 6 };
        System.out.println(countSubarrays(a, 2));
        System.out.println(countSubarrays(b, 3));
        System.out.println(countSubarrays(c, 1));

    }

    public static int countSubarrays(int nums[], int k) {
        int n = nums.length;
        int count = 0;
        int prefix[] = new int[n];
        int odd = 0;

        for (int i = 0; i < n; i++) {
            prefix[odd]++;

            if ((nums[i] & 1) == 1)
                odd++;

            if (odd >= k)
                count += prefix[odd - k];
        }

        return count;
    }
}
