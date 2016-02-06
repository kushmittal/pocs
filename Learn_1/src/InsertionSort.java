
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void sort(int arr[]) {
		for (int i = 1; i < arr.length-1; i++) {
				int temp = arr[i];
				int hole = i;
				while(hole > 0 && arr[hole-1] > temp)
				{
					arr[hole] = arr[hole-1];
					hole--;
				}
				arr[hole] = temp;
		}
	}

}
