package LeetCode.PalindromeNumber;

public class Main {
    static public boolean isPalindrome(int x) {
        // 정수 x를 문자로 받는다
        String source = Integer.toString(x);
        // 거꾸로 읽어서 저장한다
        String back = "";
        for (int i = source.length() - 1; i >= 0; i--) {
            back += source.charAt(i);
        }
        // 비교한다.
//        System.out.println(back + ", " + source.equals(back));
        return  source.equals(back);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(222));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(112));
    }
}
