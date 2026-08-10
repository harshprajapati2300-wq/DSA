class Solution {
    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        String hex = "0123456789abcdef";
        StringBuilder ans = new StringBuilder();

        while (num != 0) {

            // Get last 4 bits
            int digit = num & 15;

            // Convert digit to hexadecimal character
            ans.append(hex.charAt(digit));

            // Move to next 4 bits
            num = num >>> 4;
        }

        return ans.reverse().toString();
    }
}