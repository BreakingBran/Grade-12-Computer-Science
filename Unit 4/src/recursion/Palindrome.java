package recursion;

import java.util.Scanner;

public class Palindrome {

  public static boolean isPalindrome(String word) {

    boolean isPalindrome = false;

    if (word.length() <= 2) {

      if (word.charAt(0) == word.charAt(1) || word.length() == 1) {
        isPalindrome = true;
      }
      
    }else if (word.charAt(0) == word.charAt(word.length()-1)){
      isPalindrome = isPalindrome(word.substring(1, word.length()-1));
    }
    
    
    return isPalindrome;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(isPalindrome(sc.next()));
  }

}
