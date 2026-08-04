class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] freq = new int[26];

        for (char c : chars.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        for (String word : words) {

            int[] temp = new int[26];

            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }

            boolean good = true;

            for (int i = 0; i < 26; i++) {
                if (temp[i] > freq[i]) {
                    good = false;
                    break;
                }
            }

            if (good) {
                ans += word.length();
            }
        }

        return ans;
    }
}