
public class PigTester{

 /**
  * @param args
  */
 public static void main(String[] args) {

  PigLatin pl = new PigLatin();
  String originalInput = "";
  String finalOutput = "";
  
  // Simple test
  System.out.println("Case #1");
  originalInput = "";
  System.out.println("Org Word: " + originalInput);
  finalOutput = pl.convertWord(originalInput);    
  System.out.println("New word: " + finalOutput);


  // Sentence test
  System.out.println("Case #2");
  originalInput = null;
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);

 
 }
}
