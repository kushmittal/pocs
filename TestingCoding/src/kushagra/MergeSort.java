package kushagra;

public class MergeSort
{
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MergeSort mergeSort = new MergeSort();
  }
  
  private void doMergeSort(int lowerIndex, int higherIndex)
  {
    if (lowerIndex < higherIndex)
    {
      int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
      doMergeSort(lowerIndex, middle);
      doMergeSort(middle + 1, higherIndex);
      mergeParts(lowerIndex, middle, higherIndex);
    }
  }
  
  public void permutation(String string){
    
  }
  
  private void mergeParts(int lowerIndex, int middle, int higherIndex)
  {/*
    for (int i = lowerIndex; i <= higherIndex; i++)
    {
      tempMergArr[i] = array[i];
    }
    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;
    while (i <= middle && j <= higherIndex)
    {
      if (tempMergArr[i] <= tempMergArr[j])
      {
        array[k] = tempMergArr[i];
        i++;
      }
      else
      {
        array[k] = tempMergArr[j];
        j++;
      }
      k++;
    }
    while (i <= middle)
    {
      array[k] = tempMergArr[i];
      k++;
      i++;
    }
  */}
}
