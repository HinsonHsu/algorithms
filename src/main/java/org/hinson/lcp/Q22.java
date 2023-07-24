package org.hinson.lcp;

public class Q22 {

    /**
     * k1 * n + k2 * n - K1 * K2 = k
     * k2(n -k1) = k - k1 * n
     * @param n
     * @param k
     * @return
     */
    public int paintingPlan(int n, int k) {
        int cnt = 0;
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        if(k==0) return 1;
        if(n>k) return 0;
        if(k==n*n) return 1;
        for (int i = 0; i <= k; i++) {
            int k1 = i;
            if (k - n * k1 >= 0 && (k - n * k1) % (n - k1) == 0) {
                int k2 = (k - n * k1) / (n - k1);
                cnt += getCombination(k1, n, factorial) * getCombination(k2, n, factorial);
            }
        }
        return cnt;
    }

    private int getCombination(int select, int num, int[] factorial) {
        if (select == 0) {
            return 1;
        }
        if (num < select) return 0;
        return factorial[num] / (factorial[num - select] * factorial[select]);
    }

    public static void main(String[] args) {
        int cnt = new Q22().paintingPlan(2, 4);
        System.out.println(cnt);
    }

}
