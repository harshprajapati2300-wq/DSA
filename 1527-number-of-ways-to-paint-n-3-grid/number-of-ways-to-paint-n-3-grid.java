class Solution {

    public int numOfWays(int n) {

        int MOD = 1_000_000_007;

        // Number of ABA patterns
        long same = 6;

        // Number of ABC patterns
        long diff = 6;

        // Process remaining rows
        for (int i = 2; i <= n; i++) {

            long newSame = (same * 3 + diff * 2) % MOD;

            long newDiff = (same * 2 + diff * 2) % MOD;

            same = newSame;
            diff = newDiff;
        }

        // Total ways
        return (int)((same + diff) % MOD);
    }
}