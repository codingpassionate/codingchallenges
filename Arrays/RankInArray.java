import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RankInArray {

	public static void main(String args[]) {
		int[] arr = {40,10,10,20,30};
		RankInArray rankInArray = new RankInArray();
		rankInArray.findArrayItemRanks(arr);
	}
	
	private int[] findArrayItemRanks(int[] arr) {
		Set<Integer> treeSet = new TreeSet();
		for(int item : arr) {
			treeSet.add(item);
		}
		int rank = 1;
		Map<Integer,Integer> rankMap = new HashMap();
		for(int item: treeSet) {
			rankMap.put(item,rank++);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = rankMap.get(arr[i]);
			System.err.println("arr[i]:"+arr[i]);
		}
		return arr;
	}
	
}
