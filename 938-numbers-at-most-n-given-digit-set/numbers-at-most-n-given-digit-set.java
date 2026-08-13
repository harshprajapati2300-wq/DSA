class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int k = digits.length;
        int count = 0;

        for (int i = 1; i < len; i++) {
            count += Math.pow(k, i);
        }

     
        for (int i = 0; i < len; i++) {
            boolean found = false;

            for (String d : digits) {
                if (d.charAt(0) < s.charAt(i)) {
                    count += Math.pow(k, len - i - 1);
                } else if (d.charAt(0) == s.charAt(i)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return count;
            }
        }

        return count + 1;
    }
}