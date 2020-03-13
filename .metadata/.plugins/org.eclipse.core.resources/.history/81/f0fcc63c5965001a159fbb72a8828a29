package binarysearch;

public class FixedPoint {
	static int binarySearch(int arr[], int low, int high) {
		int retval = -1;
		while (high >= low) {
			/* low + (high - low)/2; */
			int mid = (low + high) / 2;
			if (mid == arr[mid]) {
				retval = mid;
				high = mid;
			}
			if (mid > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		/*
		 * Return -1 if there is no Fixed Point
		 */
		return retval;
	}

	// main function
	public static void main(String args[]) {
		int arr[] = { -10, -1, 0, 3};
		int n = arr.length;
		System.out.println("Fixed Point is " + binarySearch(arr, 0, n - 1));
	}
}
