import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPalindrome {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int n = scr.nextInt();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(scr.next());
        }

        List<String> shortestPalindromeList = findShortestPalindrome(list);
        for(String value: shortestPalindromeList) {
            System.out.println(value);
        }

    }

    public static List<String> findShortestPalindrome(List<String> input) {

        for(int i = 0; i < input.size(); i++) {

            String element = input.get(i);
            if(isPalindrome(element))
                continue;

            int start = 0;
            int end = element.length()-1;
            StringBuilder sb;

            while(start < end) {
                StringBuilder temp = new StringBuilder(element);
                sb = new StringBuilder(element.substring(0,++start)).reverse();
                if(isPalindrome(temp.append(sb).toString())) {
                    input.set(i, temp.toString());
                    start = end;
                }
            }
        }
        return input;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)){
               return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
