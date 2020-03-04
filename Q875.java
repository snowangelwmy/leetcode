/**
 * Test cases:
 * 1: Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * 2: Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * 3: Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * 4: Input: piles = [332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184], H = 823855818
 * Output: 14
 */

class Q875 {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles==null||piles.length==0) {
            return 0;
        }

        if(piles.length>H) {
            return Integer.MAX_VALUE; //impossible
        }

        int high = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        if(piles.length==H) {
            return high;
        }

        //piles.length<H
        int low = 1;
        int minSpeed = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = (low+high)/2;
            int hours = getHours(piles, mid);
            if(hours<=H) {
                minSpeed = Math.min(minSpeed, mid);
                high = mid - 1;
            } else {//hours>H
                low = mid + 1;
            }
        }

        return minSpeed;
    }

    private int getHours(int[] piles, int speed) {
        int hours = 0;

        for(int pile : piles) {
            hours += pile / speed;
            hours += pile % speed > 0 ? 1 : 0;
        }

        return hours;
    }
}