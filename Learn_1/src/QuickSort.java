
public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] arr = {7,2,1,6,8,5,3,4};
		quickSort.sort(arr, 0, 7);
		System.out.println(arr.length);
		for (int i = 0; i < 8; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void sort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = arr[end];
			int pIndex = start;
			for (int i = start; i < end; i++) {
				if (pivot >= arr[i]) {
					int temp = arr[i];
					arr[i] = arr[pIndex];
					arr[pIndex] = temp;
					pIndex = pIndex + 1;
				}
			}
			int temp = arr[pIndex];
			arr[pIndex] = arr[end];
			arr[end] = temp;
			sort(arr, start, pIndex - 1);
			sort(arr, pIndex + 1, end);
		}
	}

}
