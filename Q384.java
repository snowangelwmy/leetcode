import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class Solution {

  private int[] original;
  private int[] array;

  private Random  random = new Random();

  public Solution(int[] nums) {
    original = nums;
    array = nums.clone();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    array = original.clone();
    return array;
  }

  // Time complexity : O(n)
  // The Fisher-Yates algorithm runs in linear time, as generating a random index and swapping two values can be done in constant time.
  // Space complexity : O(n)
  // Although we managed to avoid using linear space on the auxiliary array from the brute force approach,
  // we still need it for reset, so we're stuck with linear space complexity.
  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    for(int i=0; i<array.length; i++) {
      int index = getNextIndex(i, array.length);
      swap(array, i, index);
    }
    return array;
  }

  private int getNextIndex(int min, int max) {
    return random.nextInt(max-min)+min;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  //Time complexity : O(n^2)). The quadratic time complexity arises from the calls to list.remove (or list.pop), which run in linear time.
  // n linear list removals occur, which results in a fairly easy quadratic analysis.
  // Space complexity : O(n). Because the problem also asks us to implement reset, we must use linear additional space to store the original array.
  // Otherwise, it would be lost upon the first call to shuffle.
  /** Returns a random shuffling of the array. */
  public int[] shuffle0() {
    List<Integer> auxiliary = this.createAuxiliary();
    for(int i=0; i<array.length; i++) {
      int index = random.nextInt(auxiliary.size());
      array[i] = auxiliary.get(index);
      auxiliary.remove(index);
    }
    return array;
  }

  private List<Integer> createAuxiliary() {
    List<Integer> auxiliary = new ArrayList<>(original.length);
    for(int num: original) {
      auxiliary.add(num);
    }
    return auxiliary;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
