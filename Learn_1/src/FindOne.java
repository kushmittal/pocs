import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class FindOne {

	public static void main(String ...args)
	{
		List<Integer> listInt = new ArrayList<Integer>();
		Integer[] arr = new Integer[100];
		
		/*int sumSquaresComplete = 0;*/
//		for(int i = 1; i <= 100; i++)
//		{
//			listInt.add(i);
////			sumSquaresComplete += i^2;
//		}
		//arr = listInt.toArray(new Integer[listInt.size()]);
		Random ra = new Random();
		for (int i = 0; i < 100; i++)
            arr[i] = ra.nextInt(100);
//		listInt.remove(8);
//		listInt.remove(4);
//		int n = 100;
//		int sum = 0;
//		int sumSquares = 0;
//		for(int no : array)
//		{
//			sum += no;
//			sumSquares += Math.pow(no, 2);
//		}
//		int val = n*(n+1)/2 - sum;
//		int value = n*(n+1)*(2*n+1)/6 - sumSquares;
//		int ab = ((int)Math.pow(val, 2) - value)/2;
//		System.out.println(val+" "+value+" "+ab);
//		int aMinusb = (int) Math.sqrt(Math.pow(val, 2) - 4*ab);
//		System.out.println(aMinusb);
//		System.out.println("a="+ (val + aMinusb)/2);
//		System.out.println("b="+ (val - aMinusb)/2);
		System.out.println("aa");
		int N = arr.length;
        if (N == 0)
            return;
        /** find max and min values **/
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
 
        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > 500)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }
 
        int[] count = new int[range];
        /** make count/frequency array for each element **/
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        /** modify count so that positions in final array is obtained **/
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        /** modify original array **/
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
        System.out.println("b=");
	}
	
}

class Node
{
	
}
