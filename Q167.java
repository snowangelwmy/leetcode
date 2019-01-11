/**
 * Test cases:
 * 1: Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[] {-1, -1};
        if(numbers==null||numbers.length<2){
            return result;
        }

        //numbers.length>=2
        for(int i=0; i<numbers.length; i++){
            int diffIndex = findDiffIndex(numbers, target-numbers[i], 0, numbers.length-1, i);
            if(diffIndex!=-1){
                if(i<=diffIndex){
                    result[0]=i+1;
                    result[1]=diffIndex+1;
                } else {//i>diffIndex
                    result[0]=diffIndex+1;
                    result[1]=i+1;
                }
                return result;
            }
        }

        return result;
    }

    private int findDiffIndex(int[] numbers, int diff, int low, int high, int index){
        int result = -1;
        if(low>high){
            return result;
        }

        //low<=high
        int mid = (low+high)/2;
        if(numbers[mid]==diff){
            if(diff==numbers[index]&&mid==index){
                //check the neighbors
                if(mid-1>=0&&numbers[mid-1]==diff){
                    return mid-1;
                }
                if(mid+1<numbers.length&&numbers[mid+1]==diff){
                    return mid+1;
                }
                return result;
            } else {
                return mid;
            }
        } else if(numbers[mid]>diff){
            return findDiffIndex(numbers, diff, 0, mid-1, index);
        } else {//numbers[mid]<diff
            return findDiffIndex(numbers, diff, mid+1, high, index);
        }
    }
}