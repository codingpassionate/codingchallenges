package codingassignemnt;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 *
 * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 */

public class FrogJump {
    public static void main(String args[]) {
        int[] stones = {0,1,3,5,6,8,12,17};
    FrogJump frogJump = new FrogJump();
    System.err.println(frogJump.canCross(stones));
    }


    public boolean canCross(int[] stones) {
    	
    	//dfs approach
//     if (stones == null || stones.length == 0) {return false;}
//         int n = stones.length;
//         if (n == 1) {return true;}
//         if (stones[1] != 1) {return false;}
//         if (n == 2) {return true;}
//         int last = stones[n - 1];
//         HashSet<Integer> hs = new HashSet();
//         for (int i = 0; i < n; i++) {
//             if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away. 
//             hs.add(stones[i]);
//         }
//         return canReach(hs, last, 1, 1);
//     }
    
//     private boolean canReach(HashSet<Integer> hs, int last, int pos, int jump) {
//         if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
//             return true;
//         }
//         if (hs.contains(pos + jump + 1)) {
//             if (canReach(hs, last, pos + jump + 1, jump + 1)) {return true;}
//         }
//         if (hs.contains(pos + jump)) {
//             if (canReach(hs, last, pos + jump, jump)) {return true;}
//         }
//         if (jump > 1 && hs.contains(pos + jump - 1)) {
//             if (canReach(hs, last, pos + jump - 1, jump - 1)) {return true;}
//         }
//         return false;
//     }
        
    	//stack approach
        if(stones == null || stones.length == 0){
            return false;
        }
        for(int i =3;i<stones.length;i++){
            if(stones[i] > stones[i-1]*2){
                return false;
            }
        }
        Set<Integer> stonesPositions = new HashSet<Integer>();
        for(int stone:stones){
            stonesPositions.add(stone);
        }
        int lastPosition = stones[stones.length -1];
        Stack<Integer> positions = new Stack();
        Stack<Integer> steps = new Stack();
        positions.add(0);
        steps.add(0);
        while(!positions.isEmpty()){
           int currentPosition = positions.pop();
           int currentStep =  steps.pop();
            for(int i = currentStep-1; i<=  currentStep+1; i++){
                if(i<= 0){
                    continue;
                }
                int nextPosition = currentPosition + i;
                if(nextPosition == lastPosition){
                    return true;
                }else if(stonesPositions.contains(nextPosition)){
                    positions.add(nextPosition);
                    steps.add(i);
                }
            }
        }
        
        return false;
    }

}





