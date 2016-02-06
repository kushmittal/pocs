package learning;

public class Kadanes {

	public static void main(String[] args) {
		int[] arr = {1, -5, 2, -1, 3};
		int maxSum = 0;
		int currentSum = 0;
		for(int i = 0; i < arr.length ; i++)
		{
				currentSum += arr[i];
				if(currentSum < 0)
				{
					currentSum = 0;
					continue;
				}
				if(currentSum > maxSum){
					maxSum = currentSum;		
				}
		}
		System.out.println(maxSum);
	}
}
