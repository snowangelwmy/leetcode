/**
 * Test cases:
 * 1: Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * Output: 14
 * Explanation:
 * There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 * In special offer 1, you can pay $5 for 3A and 0B
 * In special offer 2, you can pay $10 for 1A and 2B.
 * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 * 2: Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * Output: 11
 * Explanation:
 * The price of A is $2, and $3 for B, $4 for C.
 * You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 * You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C.
 * You cannot add more items, though only $9 for 2A ,2B and 1C.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Q638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(price==null||price.size()==0||needs==null||needs.size()==0||price.size()!=needs.size()) {
            return 0;
        }

        if(special==null||special.size()==0) {
            int total = 0;
            for(int i=0; i<needs.size(); i++) {
                total += price.get(i) * needs.get(i);
            }
            return total;
        }

        List<Integer> curCount = new ArrayList<>(needs.size());
        for(int i=0; i<needs.size(); i++) {
            curCount.add(0);
        }
        int curPrice = 0;
        Map<String, Integer> lookup = new HashMap<>();
        return shoppingOffersHelper(price, special, needs, curCount, curPrice, lookup);
    }

    private int shoppingOffersHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, List<Integer> curCount, int curPrice, Map<String, Integer> lookup) {
        boolean isDone = true;
        List<String> keyBuilder = new ArrayList<>();
        for(int i=0; i<needs.size(); i++) {
            if(needs.get(i)!=curCount.get(i)) {
                isDone = false;
            }
            keyBuilder.add(String.valueOf(curCount.get(i)));
        }
        if(isDone) {
            return curPrice;
        }

        String key = String.join("_", keyBuilder);
        if(lookup.containsKey(key)) {
            return lookup.get(key);
        }

        int minTotalPrice = curPrice;
        for(int i=0; i<needs.size(); i++) {
            minTotalPrice += price.get(i) * (needs.get(i)-curCount.get(i));
        }
        for(List<Integer> curSpecial : special) {
            if(curSpecial.size() != needs.size() + 1) {
                continue;
            }

            boolean isValid = true;
            List<Integer> newCurCount = new ArrayList<>(needs.size());
            int newCurPrice = curPrice;
            for(int i=0; i<needs.size(); i++) {
                if(curCount.get(i)+curSpecial.get(i)>needs.get(i)) {
                    isValid = false;
                    break;
                }

                newCurCount.add(curCount.get(i)+curSpecial.get(i));
            }
            newCurPrice += curSpecial.get(needs.size());

            if(!isValid) {
                continue;
            }

            int curTotalPrice =  shoppingOffersHelper(price, special, needs, newCurCount, newCurPrice, lookup);
            minTotalPrice = Math.min(minTotalPrice, curTotalPrice);
        }

        lookup.put(key, minTotalPrice);
        return lookup.get(key);
    }
}