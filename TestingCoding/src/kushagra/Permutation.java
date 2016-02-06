package kushagra;

public class Permutation
{
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Permutation permutation = new Permutation();
    permutation.permutation("", "abc");
  }

  public void permutation(String beginningString, String endingString)
  {
    if(endingString.length()<=1)
      System.out.println(beginningString+endingString);
    else
    for(int i =0 ; i< endingString.length(); i++){
      String finalString = endingString.substring(0,i)+endingString.substring(i+1);
      permutation(beginningString+endingString.charAt(i), finalString);
    }
  }
}
