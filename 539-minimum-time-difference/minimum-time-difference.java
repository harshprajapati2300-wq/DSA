import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        int n = timePoints.size();

        // Pigeonhole Principle
        if (n > 1440) return 0;

        List<Integer> minutes = new ArrayList<>();

        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            minutes.add(hour * 60 + minute);
        }

        Collections.sort(minutes);

        int ans = Integer.MAX_VALUE;

        // Adjacent differences
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, minutes.get(i) - minutes.get(i - 1));
        }

        // Circular difference
        ans = Math.min(ans, 1440 - minutes.get(n - 1) + minutes.get(0));

        return ans;
    }
}