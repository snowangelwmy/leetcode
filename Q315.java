/**
 * Test cases:
 * 1: Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */

import java.util.List;
import java.util.ArrayList;

class Q315 {
    public List<Integer> countSmaller(int[] nums) {
        if(nums==null||nums.length==0) {
            return new ArrayList<Integer>();
        }

        List<Integer> counts = new ArrayList<>(nums.length);
        for(int i=0; i<nums.length; i++) {
            counts.add(0);
        }
        int[] indexes = new int[nums.length];
        for(int i=0; i<indexes.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, counts, 0, nums.length-1);
        return counts;
    }

    private void mergeSort(int[] nums, int[] indexes, List<Integer> counts, int start, int end) {
        if(end<=start) {
            return;
        }

        int mid = (start+end)/2;
        mergeSort(nums, indexes, counts, start, mid);
        mergeSort(nums, indexes, counts, mid+1, end);
        merge(nums, indexes, counts, start, end);
    }

    private void merge(int[] nums, int[] indexes, List<Integer> counts, int start, int end) {
        int mid = (start+end)/2;
        int leftIndex = start;
        int rightIndex = mid+1;
        int[] sortedIndexes = new int[end-start+1];
        int sortIndex = 0;
        int rightCount = 0;
        while(leftIndex<=mid&&rightIndex<=end) {
            if(nums[indexes[leftIndex]]<=nums[indexes[rightIndex]]) {
                sortedIndexes[sortIndex] = indexes[leftIndex];
                counts.set(indexes[leftIndex], counts.get(indexes[leftIndex])+rightCount);
                leftIndex++;
            } else {//nums[indexes[leftIndex]]>nums[indexes[rightIndex]]
                sortedIndexes[sortIndex] = indexes[rightIndex];
                rightCount++;
                rightIndex++;
            }
            sortIndex++;
        }
        while(leftIndex<=mid) {
            sortedIndexes[sortIndex++] = indexes[leftIndex];
            counts.set(indexes[leftIndex], counts.get(indexes[leftIndex])+rightCount);
            leftIndex++;
        }
        while(rightIndex<=end) {
            sortedIndexes[sortIndex++] = indexes[rightIndex++];
        }
        for(int i=start; i<=end; i++) {
            indexes[i] = sortedIndexes[i-start];
        }
    }
}