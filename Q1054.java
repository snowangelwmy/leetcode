/**
 * Test cases:
 * 1: Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * 2: Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 * 3: Input: [2,2,2,1,5]
 * Output: [2,1,2,5,2]
 */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

class Q1054 {

    class NumCount {
        int value;
        int count;

        NumCount(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i=0; i<barcodes.length; i++) {
            if(!counts.containsKey(barcodes[i])) {
                counts.put(barcodes[i], 0);
            }
            counts.put(barcodes[i], counts.get(barcodes[i])+1);
        }
        NumCount[] numCounts = new NumCount[counts.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            numCounts[i++] = new NumCount(entry.getKey(), entry.getValue());
        }
        Arrays.sort(numCounts, new Comparator<NumCount>() {
            public int compare(NumCount a, NumCount b) {
                return b.count - a.count;
            }
        });
        int j = 0;
        for(int m=0; m<numCounts.length; m++) {
            NumCount curNumCount = numCounts[m];
            for(int n=0; n<curNumCount.count; n++) {
                barcodes[j] = curNumCount.value;
                j = (j+2>=barcodes.length) ? 1 : j+2;
            }
        }
        return barcodes;
    }
}