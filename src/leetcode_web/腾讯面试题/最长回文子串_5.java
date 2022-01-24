package leetcode_web.腾讯面试题;

import org.junit.Test;


public class 最长回文子串_5 {

    public String longestPalindrome(String s) {

        int i = 0;
        String ans = "";

        while (i < s.length()) {
            int j = s.length();
            while (j > i) {
                System.out.println(s.substring(i, j));
                if (judgeIsPalindrome(s.substring(i, j)) ) {
                    if (ans.length() <= (j-i)){
                        ans = s.substring(i, j );
                        System.out.println("temp: "+ans);
                        break;
                    }
                }
                j--;

            }
            i++;
        }
        System.out.println(s.charAt(0));

        return ans;
    }

    public boolean judgeIsPalindrome(String s) {
        System.out.println("s:" + s);
        StringBuffer sb = new StringBuffer(s);
        if (s.equals(sb.reverse().toString())){
            return true;
        }else {
            return false;
        }
    }

    @Test
    public void test() {
        float t1 = System.nanoTime();
        System.out.println("ans: "+longestPalindrome("abcacba"));
        float t2 = System.nanoTime();
        System.out.println((t2-t1)/1000000);
    }

    @Test
    public void test2() {
        System.out.println(judgeIsPalindrome("abcacba"));
    }
}
