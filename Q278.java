/**
 * Test cases:
 * 1: Input & Output:
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 2: Input: 1
 * Output: 1
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
  //iteration approach
  public int firstBadVersion(int n) {
    if(n<1){
      return -1;
    }
    int low = 1;
    int high = n;
    while(low<high) {
      int mid = low+(high-low)/2;
      boolean result = isBadVersion(mid);
      if(!result){
        low = mid+1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  //recursion approach
  public int firstBadVersion1(int n) {
    if(n<1){
      return -1;
    }
    return binarySearch(1, n);
  }

  private int binarySearch(int low, int high) {
    if(low==high) {
      return low;
    }

    if(low<high){
      int mid = low+(high-low)/2;
      boolean result = isBadVersion(mid);
      if(!result){
        return binarySearch(mid+1, high);
      } else {
        return binarySearch(low, mid);
      }
    }

    return -1;
  }
}