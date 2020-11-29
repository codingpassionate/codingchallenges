import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 *
 */
public class MergeTwoShortedArray {

	public static void main(String args[]) {
		int[] arr1 = {1,2,3,0,0,0};
		int m = 3;
		int[] arr2 = {2,5,6};
		int n = 3;
		MergeTwoShortedArray mergeTwoShortedArray = new MergeTwoShortedArray();
		System.err.println(Arrays.stream(mergeTwoShortedArray.mergeTwoSortedArray(arr1, m, arr2, n)).boxed().collect(Collectors.toList()));
	}
	
	private int[] mergeTwoSortedArray(int[] arr1, int m , int[] arr2, int n) {
		int i = m -1;
		int j = n-1;
		int k = m + n - 1;
		while(i >= 0 && j>=0) {
			if(arr1[i] > arr2[j]) {
				arr1[k--] = arr1[i--];
			}else {
				arr1[k--] = arr2[j--];
			}
				
		}
		while(j>=0)
			arr1[k--] = arr2[j--];
		
		return arr1;
	}
	
}
