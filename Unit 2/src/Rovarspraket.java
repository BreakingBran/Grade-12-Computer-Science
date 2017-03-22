import java.util.*;

/*
 * @author Divya
 * 
 * @course ICS4U1
 * 
 * @date 2015/02/20
 * 
 * @description This program will translate any word into the Swedish children's language
 * 'Rovarspraket.
 */
public class Rovarspraket {
  public static void main(String[] args) {
    // Get input from user: Single word
    Scanner sc = new Scanner(System.in);

    System.out.print("Input a single word:");
    String input = sc.next();

    // Send one letter of the word at a time to the method and translate
    getOutput(input);

    // Close scanner to prevent error messages
    sc.close();
  }

  /*
   * This method will translate each letter into the other language and return.
   */
  public static String getOutput(String input) {
    String output = "";
    char letter;

    for (int i = 0; i < input.length(); i++) {
      letter = input.charAt(i);

      // Vowels remain the same.
      if (letter == 'a' || letter == 'A') {
        output = "a";
      }
      // If it is a consonant, at the vowel closest and the next consonant. abaccaddefefeggehhijijikkillimmonnopopoqqorrossuttuvuvuwwuxxuyyuzzuz
      else if (letter == 'b' || letter == 'B') {
        output = "bac";
      } else if (letter == 'c' || letter == 'C') {
        output = "cad";
      } else if (letter == 'd' || letter == 'D') {
        output = "def";
      } else if (letter == 'e' || letter == 'E') {
        output = "e";
      } else if (letter == 'f' || letter == 'F') {
        output = "feg";
      } else if (letter == 'g' || letter == 'G') {
        output = "geh";
      } else if (letter == 'h' || letter == 'H') {
        output = "hij";
      } else if (letter == 'i' || letter == 'I') {
        output = "i";
      } else if (letter == 'j' || letter == 'J') {
        output = "jik";
      } else if (letter == 'k' || letter == 'K') {
        output = "kil";
      } else if (letter == 'l' || letter == 'L') {
        output = "lim";
      } else if (letter == 'm' || letter == 'M') {
        output = "mon";
      } else if (letter == 'n' || letter == 'N') {
        output = "nop";
      } else if (letter == 'o' || letter == 'O') {
        output = "o";
      } else if (letter == 'p' || letter == 'P') {
        output = "poq";
      } else if (letter == 'q' || letter == 'Q') {
        output = "qor";
      } else if (letter == 'r' || letter == 'R') { 
        output = "ros";
      } else if (letter == 's' || letter == 'S') {
        output = "sut";
      } else if (letter == 't' || letter == 'T') {
        output = "tuv";
      } else if (letter == 'u' || letter == 'U') {
        output = "u";
      } else if (letter == 'v' || letter == 'V') {
        output = "vuw";
      } else if (letter == 'w' || letter == 'W') {
        output = "wux";
      } else if (letter == 'x' || letter == 'X') {
        output = "xuy";
      } else if (letter == 'y' || letter == 'Y') {
        output = "yuz";
      } else if (letter == 'z' || letter == 'Z') {
        output = "zuz";
      }
      System.out.print(output);
    }

    // Return value
    return output;
  }
}
