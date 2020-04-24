/**
 * Test cases:
 * 1: Input: N = 50
 * Output: 0.625
 * Explanation:
 * If we choose the first two operations, A will become empty first. For the third operation, A and B will become empty at the same time. For the fourth operation, B will become empty first. So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
 * 2: Input: N = 0
 * Output: 0.5
 * 3: Input: N = 800
 * Output: 0.961617625085637
 * 4: Input: N = 660295675
 * Output: 1.0
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Q808 {

    //https://leetcode.com/problems/soup-servings/discuss/121711/C++JavaPython-When-N-greater-4800-just-return-1
    //This is a dynamic programming problem.
    public double soupServings(int N) {
        if(N<0) {
            return -1.0;
        }
        if(N==0) {
            return 0.5;
        }

        //N>0
        if(N>=4800) {
            return 1.0;
        }

        N = N%25==0? N/25 : N/25+1;
        double[][] lookup = new double[N+1][N+1];
        return soupServingsHelper(N, N, lookup);
    }

    private double soupServingsHelper(int a, int b, double[][] lookup) {
        if(a<=0&&b<=0) {
            return 0.5;
        }
        if(a<=0) {
            return 1.0;
        }
        if(b<=0) {
            return 0.0;
        }
        if(lookup[a][b]>0) {
            return lookup[a][b];
        }

        lookup[a][b] = 0.25*(soupServingsHelper(a-4, b, lookup)+soupServingsHelper(a-3, b-1, lookup)+soupServingsHelper(a-2, b-2, lookup)+soupServingsHelper(a-1, b-3, lookup));
        return lookup[a][b];
    }

    class Node {
        int a;
        int b;
        double p;

        public Node(int a, int b, double p) {
            this.a = a;
            this.b = b;
            this.p = p;
        }
    }

    class Pros {
        double proOfA;
        double proOfAB;

        public Pros(double proOfA, double proOfAB) {
            this.proOfA = proOfA;
            this.proOfAB = proOfAB;
        }
    }

    int[][] ops = {
            {100, 0},
            {75, 25},
            {50, 50},
            {25, 75}
    };

    public double soupServings1(int N) {
        if(N<0) {
            return -1.0;
        }
        if(N==0) {
            return 0.5;
        }

        //N>0
        //We need to have this condition check, otherwise, you will get a Runtime Error: java.lang.StackOverflowError
        //The reason we pick up 4800 to do the condition check is explained here: https://leetcode.com/problems/soup-servings/discuss/121711/C++JavaPython-When-N-greater-4800-just-return-1
        if(N>=4800) {
            return 1.0;
        }
        Map<String, Pros> lookup = new HashMap<>();
        Pros pros = getPros(new Node(N, N, 1.0), lookup);
        return pros.proOfA + 0.5 * pros.proOfAB;
    }

    private Pros getPros(Node node, Map<String, Pros> lookup) {
        String key = node.a + "_" + node.b;
        System.out.println("key:" + key);
        if(lookup.containsKey(key)) {
            Pros subPros = lookup.get(key);
            return new Pros(node.p * subPros.proOfA, node.p * subPros.proOfAB);
        }

        double proOfA = 0.0;
        double proOfAB = 0.0;
        for(int[] op: ops) {
            int newA = 0;
            int newB = 0;
            double opP = 0.25;
            if(node.a-op[0]<=0) {//A is empty
                newA = node.a;
                if(node.b-op[1]<=0) {//B is empty as well
                    proOfAB += opP;
                    newB = node.b;
                } else {
                    proOfA += opP;
                    newB = node.b-op[1];
                }
                continue;
            } else {
                newA = node.a-op[0];
                if(node.b-op[1]<=0) { //B is empty first
                    continue;
                }

                newB = node.b-op[1];
                Pros subPros = getPros(new Node(newA, newB, opP), lookup);
                proOfA += subPros.proOfA;
                proOfAB += subPros.proOfAB;
            }
        }

        lookup.put(key, new Pros(proOfA, proOfAB));
        return new Pros(node.p * proOfA, node.p * proOfAB);
    }

    //Time Limit Exceeded
    public double soupServings0(int N) {
        if(N<0) {
            return -1.0;
        }
        if(N==0) {
            return 0.5;
        }

        //N>0
        double proOfA = 0.0;
        double proOfAB = 0.0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, N, 1.0));
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            for(int[] op: ops) {
                int newA = 0;
                int newB = 0;
                double newP = curNode.p * 0.25;
                if(curNode.a-op[0]<=0) {//A is empty
                    newA = curNode.a;
                    if(curNode.b-op[1]<=0) {//B is empty as well
                        proOfAB += newP;
                        newB = curNode.b;
                    } else {
                        proOfA += newP;
                        newB = curNode.b-op[1];
                    }
                    continue;
                } else {
                    newA = curNode.a-op[0];
                    if(curNode.b-op[1]<=0) { //B is empty first
                        continue;
                    }

                    newB = curNode.b-op[1];
                    queue.offer(new Node(newA, newB, newP));
                }
            }
        }

        return proOfA + 0.5 * proOfAB;
    }
}