/**
 * Test cases:
 * 1: Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (A[i], A[j], A[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 * 2: Input: A = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Q923 {

    //https://leetcode.com/problems/3sum-with-multiplicity/solution/
    public int threeSumMulti(int[] A, int target) {
        if(A==null||A.length<3) {
            return 0;
        }

        Arrays.sort(A);

        long count = 0;
        for(int i=0; i<A.length; i++) {
            int newTarget = target - A[i];
            int j = i + 1;
            int k = A.length - 1;
            while(j<k) {
                if(A[j]+A[k]<newTarget) {
                    j++;
                } else if(A[j]+A[k]>newTarget) {
                    k--;
                } else {//A[j]+A[k]==newTarget
                    if(A[j]!=A[k]) {
                        int left = 1;
                        int right = 1;
                        while(j+1<k&&A[j+1]==A[j]) {
                            j++;
                            left++;
                        }
                        while(k-1>j&&A[k-1]==A[k]) {
                            k--;
                            right++;
                        }
                        count += left * right;
                        j++;
                        k--;
                    } else {//A[j]==A[k]
                        count += (k-j+1)*(k-j)/2;
                        break;
                    }
                }
            }
        }
        return (int)(count%(Math.pow(10,9)+7));
    }

    //Time Limit Exceeded
    public int threeSumMulti0(int[] A, int target) {
        if(A==null||A.length<3) {
            return 0;
        }

        Map<Integer, List<Integer>> lookup = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            if(!lookup.containsKey(A[i])) {
                lookup.put(A[i], new ArrayList<Integer>());
            }
            lookup.get(A[i]).add(i);
        }

        long result = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++) {
                int newTarget = target - A[i] - A[j];
                if(lookup.containsKey(newTarget)) {
                    List<Integer> indexes = lookup.get(newTarget);
                    for(int k=0; k<indexes.size(); k++) {
                        if(indexes.get(k)>j) {
                            result += indexes.size()-k;
                            break;
                        }
                    }
                }
            }
        }

        return (int)(result%(Math.pow(10, 9)+7));
    }
}