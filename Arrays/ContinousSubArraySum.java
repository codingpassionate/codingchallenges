import java.util.HashMap;
import java.util.Map;

/**
 * start with mod =0, then we always do mod = (mod+nums[i])%k, if mod repeats, that means between these two mod = x occurences the sum is multiple of k.
Math: c = a % k, c = b % k, so we have a % k = b % k.
Where a is the mod at i and b is the mod at j and a <= b, i < j, because all nums are non-negative. And c is the mod that repeats.
Suppose b-a=d, then we have b % k = ((a+d) % k)%k = (a%k + d%k)%k
In order to make the equation valid: a % k = (a%k + d%k)%k
d%k has to be 0, so d, the different between b and a, is a multiple of k
Example:
[23, 2, 1, 6, 7] k=9
mod = 5, 7, 8, 5 <-- at here we found it
 *
 */
public class ContinousSubArraySum {

	public static void main(String args[]) {
		ContinousSubArraySum continousSubArraySum = new ContinousSubArraySum();
		int nums[] = {23, 2, 4, 6, 7};
		int k = 6;
		System.err.println(continousSubArraySum.verifyContinousSubArraySum(nums,k));
	}
	
	private boolean verifyContinousSubArraySum(int[] nums, int k) {
	    Map<Integer, Integer> sumIndexMap = new HashMap<Integer, Integer>();
	    //initialize sum 0 with -1.
	    int sum = 0;
	    for (int i=0;i<nums.length;i++) {
	        sum += nums[i];
	        if (k != 0) { 
	        	sum %= k; 
	        }
	        if (sumIndexMap.get(sum) != null) {
	            if (i - sumIndexMap.get(sum) > 1) return true;
	        }
	        else {
	        	sumIndexMap.put(sum, i);
	        }
	    }
	    return false;
	}
	
}
