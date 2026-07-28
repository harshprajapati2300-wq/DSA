class Solution {
    public int[] processQueries(int[] queries, int m) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = list.indexOf(queries[i]);

            ans[i] = index;

            list.remove(index);

            list.add(0, queries[i]);
        }

        return ans;
    }
}