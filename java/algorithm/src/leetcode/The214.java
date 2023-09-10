package leetcode;

public class The214 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("data");
        sb.delete(sb.length() - 0, sb.length());
        System.out.println(sb);
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s).reverse();
        int i = 0;
        while (i <= n) {
            String temp = sb.substring(0, i);
            sb.append(temp);
            if (func(sb)) {
                return sb.reverse().toString();
            }
            sb.delete(sb.length() - i, sb.length());
            i++;
        }
        return s;
    }

    private boolean func(StringBuilder sb) {
        int len = sb.length();
        if (len == 1) return true;

        int mid = (len - 1) / 2;
        for (int i = 0; i <= mid; ++i) {
            if (sb.charAt(i) != sb.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
