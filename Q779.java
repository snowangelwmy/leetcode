import java.lang.StringBuilder;
import java.lang.Math;

class Q779 {

    //https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/548873/Java-Recursive-Solution-Explained
    public int kthGrammar(int N, int K) {
        if(N<1||K<1) {
            return -1;
        }

        //N>=1 && K>=1
        if(N==1) {
            if(K==1) {
                return 0;
            } else {//K>1
                return -1;
            }
        }

        //N>1
        int prevN = N-1;
        int prevK = (int)Math.ceil(K/2.0);
        int prevKthNum = kthGrammar(prevN, prevK);
        if((prevKthNum==0 && K%2==1) || (prevKthNum==1 && K%2==0)) {
            return 0;
        } else if((prevKthNum==0 && K%2==0) || (prevKthNum==1 && K%2==1)) {
            return 1;
        } else {//prevKthNum==-1
            return -1;
        }
    }

    //Memory Limit Exceeded
    public int kthGrammar1(int N, int K) {
        if(N<1) {
            return -1;
        }

        StringBuilder builder = new StringBuilder("0");
        int row = 1;
        while(row<N) {
            StringBuilder newBuilder = new StringBuilder();
            for(int i=0; i<builder.length(); i++) {
                char c = builder.charAt(i);
                if(c=='0') {
                    newBuilder.append('0').append('1');
                } else {
                    newBuilder.append('1').append('0');
                }
            }
            builder = newBuilder;
            row++;
        }

        if(builder.length() < K) {
            return -1;
        }

        return Integer.parseInt(String.valueOf(builder.charAt(K-1)));
    }

    //Memory Limit Exceeded
    public int kthGrammar0(int N, int K) {
        if(N<1) {
            return -1;
        }

        StringBuilder builder = new StringBuilder("0");
        int row = 1;
        while(row<N) {
            String s = builder.toString();
            builder = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c=='0') {
                    builder.append('0').append('1');
                } else {
                    builder.append('1').append('0');
                }
            }
            row++;
        }

        String s = builder.toString();
        if(s.length() < K) {
            return -1;
        }

        return Integer.parseInt(String.valueOf(s.charAt(K-1)));
    }
}