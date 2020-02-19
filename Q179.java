/**
 * Test cases:
 * 1: Input: [10,2]
 * Output: "210"
 * 2: Input: [3,30,34,5,9]
 * Output: "9534330"
 * 3: Input: [0,0]
 * Output: "0"
 */

import java.util.Arrays;
import java.util.Comparator;
import java.lang.StringBuilder;

class Q179 {
    public String largestNumber(int[] nums) {
        if(nums==null|nums.length==0) {
            return "";
        }

        boolean allZeros = true;
        for(int num : nums) {
            if(num!=0) {
                allZeros = false;
                break;
            }
        }
        if(allZeros) {
            return "0";
        }

        Integer[] newNums = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) {
            newNums[i] = new Integer(nums[i]);
        }

        Arrays.sort(newNums, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                String aStr = Integer.toString(a);
                String bStr = Integer.toString(b);
                int i=0;
                while(i<aStr.length()&&i<bStr.length()) {
                    if((aStr.charAt(i)-'0')>(bStr.charAt(i)-'0')) {
                        return -1;
                    } else if((aStr.charAt(i)-'0')<(bStr.charAt(i)-'0')) {
                        return 1;
                    } else {
                        i++;
                    }
                }
                if(i<aStr.length()||i<bStr.length()) {
                    if(Long.parseLong(aStr+bStr)>Long.parseLong(bStr+aStr)) {
                        return -1;
                    } else if (Long.parseLong(aStr+bStr)<Long.parseLong(bStr+aStr)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                return 0;
            }
        });

        StringBuilder builder = new StringBuilder();
        for(Integer num : newNums) {
            builder.append(Integer.toString(num));
        }

        return builder.toString();
    }
}