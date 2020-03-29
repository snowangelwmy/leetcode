/**
 * Test cases:
 * 1: Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 2: Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 3: Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * 4: Input: nums1 = [1,2,4,5,6], nums2 = [3,5,7,9], k = 3
 * Output: [1,3][2,3][1,5]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

class Q373 {

    class Item {
        int index1;
        int index2;
        int sum;
        Item(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0) {
            return results;
        }

        TreeMap<Integer, List<Item>> itemsMap = new TreeMap<>();
        int count = 0;
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                int sum = nums1[i]+nums2[j];
                if(count<k) {
                    if(!itemsMap.containsKey(sum)) {
                        itemsMap.put(sum, new ArrayList<>());
                    }
                    itemsMap.get(sum).add(new Item(i, j, sum));
                    count++;
                } else if(sum<itemsMap.lastKey()) {
                    List<Item> items = itemsMap.get(itemsMap.lastKey());
                    if(items.size()==1) {
                        itemsMap.pollLastEntry();
                    } else {
                        items.remove(items.size()-1);
                    }
                    if(!itemsMap.containsKey(sum)) {
                        itemsMap.put(sum, new ArrayList<>());
                    }
                    itemsMap.get(sum).add(new Item(i, j, sum));
                } else {//items.size()>=k && nums1[i]+nums2[j]>=items.last().sum
                    break;
                }
            }
        }

        for(List<Item> items : itemsMap.values()) {
            for(Item item : items) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums1[item.index1]);
                cur.add(nums2[item.index2]);
                results.add(cur);
            }
        }
        return results;
    }
}