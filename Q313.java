/**
 * Test cases:
 * 1: Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 * 2: Input: n = 1, primes = [2,7,13,19]
 * Output: 1
 * Explanation: [1] is the sequence of the first 1
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 */

import java.util.PriorityQueue;

class Q313 {

    //https://leetcode.com/problems/super-ugly-number/discuss/277313/My-view-of-this-question-hope-it-can-help-you-understand!!!
    class Node {
        int number;
        int prime;
        int index;

        public Node(int number, int prime, int index) {
            this.number = number;
            this.prime = prime;
            this.index = index;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n<=0||primes==null||primes.length==0) {
            return 0;
        }

        int[] nums = new int[n+1];
        nums[0] = 1;
        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.number-node2.number);
        for(int prime : primes) {
            queue.offer(new Node(prime, prime, 0));
        }

        int next = 1;
        while(next<n) {
            Node node = queue.poll();
            int number = node.number;
            int prime = node.prime;
            int index = node.index;
            if(number!=nums[next-1]) {
                nums[next] = number;
                next++;
            }
            queue.offer(new Node(prime*nums[index+1], prime, index+1));
        }

        return nums[n-1];
    }
}