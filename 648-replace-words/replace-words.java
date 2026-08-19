class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            String shortest = word;

            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    if (root.length() < shortest.length()) {
                        shortest = root;
                    }
                }
            }

            ans.append(shortest).append(" ");
        }

        return ans.toString().trim();
    }
}