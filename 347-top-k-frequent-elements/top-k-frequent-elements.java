class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Store unique numbers
        List<Integer> list = new ArrayList<>(map.keySet());

        // Sort according to frequency (highest first)
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        int[] ans = new int[k];

        // Take first k elements
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}