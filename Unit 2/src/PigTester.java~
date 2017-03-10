
public class PigTester{

 /**
  * @param args
  */
 public static void main(String[] args) {

  PigLatin pl = new PigLatin();
  String originalInput = "";
  String finalOutput = "";
  
  /**
  // Simple test
  System.out.println("Case #1");
  originalInput = "dog";
  System.out.println("Org Word: " + originalInput);
  finalOutput = pl.convertWord(originalInput);    
  System.out.println("New word: " + finalOutput);


  // Sentence test
  System.out.println("Case #2");
  originalInput = "Ray likes pig latin";
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);
  
  */
  
  // Input 'wI' and 'I' produce same output
  System.out.println("Case #1");
  originalInput = "wI";
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);

  // Input 's-sa' causes consant after Symbol such as (#,-,_) to be moved to end instead of first constant
  System.out.println("Case #2");
  originalInput = "s_sa"; //S-Stuff
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);
  
  // doesn't translate words that are 10 or over characters long
  System.out.println("Case #3");
  originalInput = "restqwqw Resteqwqw Basseeqwqw dayqwerqwqw"; 
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);
  
  // doesn't translate the 10th word no matter what word it is
  System.out.println("Case #4");
  originalInput = " qw we er rt ty yu ui op pa ass sd df fg gh hj jk kl lz zx xc cv vb bn nm mq "; //S-Stuff
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);
  
  // doesn't translate the for the consanant q,r, as didn't print, sd,df fg gh hj jk kl lz zx  didn't print,vb bn nm mq didnt translate
  System.out.println("Case #");
  originalInput = "wrym"; //S-Stuff
  System.out.println("Org Sentence: " + originalInput);
  finalOutput = pl.convertSentence(originalInput);
  System.out.println("New Sentence: " + finalOutput);
 
 
 }
}
