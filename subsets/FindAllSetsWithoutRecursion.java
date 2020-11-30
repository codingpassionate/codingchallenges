import java.util.ArrayList;
import java.util.List;

public class FindAllSetsWithoutRecursion {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		FindAllSetsWithoutRecursion findAllSetsWithoutRecursion = new FindAllSetsWithoutRecursion();
		System.err.println(findAllSetsWithoutRecursion.findAllSubsets(list));
	}
	
	private List<List<Integer>> findAllSubsets(List<Integer> list){
		List<List<Integer>> subsets = new ArrayList();
		subsets.add(new ArrayList<Integer>());
		for(int num:list) {
			int length = subsets.size();
			for(int i=0;i<length;i++) {
				List<Integer> newSubset = new ArrayList(subsets.get(i));
				newSubset.add(num);
				subsets.add(newSubset);
			}
		}
		return subsets;
	}
}
