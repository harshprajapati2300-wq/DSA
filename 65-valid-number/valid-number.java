class Solution {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean dot = false;
        boolean exponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                digit = true;
            }
            else if (c == '.') {
                if (dot || exponent) {
                    return false;
                }
                dot = true;
            }
            else if (c == 'e' || c == 'E') {
                if (exponent || !digit) {
                    return false;
                }

                exponent = true;
                digit = false;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return digit;
    }
}