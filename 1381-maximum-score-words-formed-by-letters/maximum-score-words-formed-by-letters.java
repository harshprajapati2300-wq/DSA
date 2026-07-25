class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] count = new int[26];

        // Count available letters
        for (char c : letters) {
            count[c - 'a']++;
        }

        return solve(words, count, score, 0);
    }

    private int solve(String[] words, int[] count, int[] score, int index) {

        // Base case
        if (index == words.length)
            return 0;

        // Option 1 : Skip current word
        int notTake = solve(words, count, score, index + 1);

        // Option 2 : Take current word
        String word = words[index];
        int wordScore = 0;
        boolean possible = true;

        // Use letters
        for (char c : word.toCharArray()) {
            count[c - 'a']--;

            if (count[c - 'a'] < 0)
                possible = false;

            wordScore += score[c - 'a'];
        }

        int take = 0;

        if (possible) {
            take = wordScore + solve(words, count, score, index + 1);
        }

        // Backtrack (restore letters)
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        return Math.max(take, notTake);
    }
}