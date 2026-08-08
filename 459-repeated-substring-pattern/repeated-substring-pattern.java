class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {

            // substring length must divide n
            if (n % i != 0)
                continue;

            String sub = s.substring(0, i);

            String temp = "";

            // repeat substring
            for (int j = 0; j < n / i; j++) {
                temp += sub;
            }

            if (temp.equals(s))
                return true;
        }

        return false;
    }
}