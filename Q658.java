/**
 * Test cases:
 * 1: Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * 2: Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * 3: Input: [0,1,1,1,2,3,6,7,8,9], k=9, x=4
 * Output: [0,1,1,1,2,3,6,7,8]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null) {
            return new ArrayList<Integer>();
        } else if(arr.length<k) {
            List<Integer> result = new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        List<Integer> result = new ArrayList<>();
        int index = findElement(arr, x);
        if(index==-1) {
            if(x<arr[0]) {
                for(int i=0; i<k; i++) {
                    result.add(arr[i]);
                }
                return result;
            } else if(x>arr[arr.length-1]){
                for(int i=arr.length-k; i<arr.length; i++) {
                    result.add(arr[i]);
                }
                return result;
            } else {//arr[0]<x<arr[arr.length-1]
                int left = -1;
                int right = -1;
                for(int i=0; i<arr.length; i++) {
                    if(arr[i]<x) {
                        left = i;
                    } else {//arr[i]>x
                        right = i;
                        break;
                    }
                }
                findClosestElements(arr, k, x, result, left, right);
                return result;
            }
        } else {
            result.add(arr[index]);
            k--;
            int left = index - 1;
            int right = index + 1;
            findClosestElements(arr, k, x, result, left, right);
            return result;
        }
    }

    private int findElement(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;

        while(start<=end) {
            int mid = start+(end-start)/2;
            if(arr[mid]==x) {
                return mid;
            } else if(arr[mid]>x){
                end = mid -1;
            } else {//arr[mid]<x
                start = mid + 1;
            }
        }

        return -1;
    }

    private void findClosestElements(int[] arr, int k, int x, List<Integer> result, int left, int right) {
        while(k>0) {
            if(left>=0&&right<arr.length) {
                int leftDistance = Math.abs(arr[left]-x);
                int rightDistance = Math.abs(arr[right]-x);
                if(leftDistance<=rightDistance) {
                    result.add(arr[left]);
                    left--;
                    k--;
                } else {
                    result.add(arr[right]);
                    right++;
                    k--;
                }
            } else if(left>=0) {
                result.add(arr[left]);
                left--;
                k--;
            } else if(right<arr.length) {
                result.add(arr[right]);
                right++;
                k--;
            } else {
                System.out.println("error: unexpected not enough data");
                k--;
            }
        }
        Collections.sort(result);
    }
}