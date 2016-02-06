public class MergeSort {
	public static void main(String[] args) {
		MergeSort quickSort = new MergeSort();
		int[] arr = { 7, 2, 8, 6, 1, 5, 3, 4 };
		int[] a = { 1, 2, 4, 6 };
		int[] b = { 3, 5, 7, 8 };
		int[] c = new int[8];
		quickSort.sort(arr);
		System.out.println(arr.length);
		for (int i = 0; i < 8; i++) {
			System.out.println(arr[i]);
		}
	}

	public void sort(int[] arr) {
		int[] a,b,c;
		if(arr.length<2){
			return;
		}
		int mid = arr.length/2;
			a = new int[mid];
			b = new int[arr.length - mid];
			//c = new int[arr.length];
	    for(int i=0; i <= mid-1; i++){
	    	a[i] = arr[i]; 
	    }
	    for(int i=mid; i <= arr.length-1; i++){
	    	b[i-mid] = arr[i]; 
	    }
	    sort(a);
	    sort(b);
	    merge(a,b,arr);
		
	}

	public void merge(int[] arr, int[] arr1, int[] finalArray) {
		int i = 0, j = 0, k = 0;
		while (i < arr.length && j < arr1.length) {
			if (arr[i] <= arr1[j]) {
				finalArray[k] = arr[i];
				k++;
				i++;
			} else {
				finalArray[k] = arr1[j];
				k++;
				j++;
			}
		}
		while (j < arr1.length)
			finalArray[k++] = arr1[j++];
		while (i < arr.length)
			finalArray[k++] = arr[i++];
	}
}
