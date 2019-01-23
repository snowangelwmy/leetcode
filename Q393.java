/**
 * Test cases:
 * 1: Input: data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 * Output: true
 * Explanation: It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 * 2: Input: data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 * Output: false
 * Explanation: The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 * 3: Input: data = [255], which represents the octet sequence: 11111111.
 * Output: false
 * Explanation: A character in UTF8 can be from 1 to 4 bytes long.
 * 4: Input: data = [145], which represents the octet sequence: 10010001.
 * Output: false
 * Explanation: For 1-byte character, the first bit is a 0, followed by its unicode code.
 */

class Q393 {
    public boolean validUtf8(int[] data) {
        if(data==null||data.length==0) {
            return false;
        }

        String[] bytes = new String[data.length];
        for(int i=0; i<data.length; i++) {
            bytes[i] = getLeastSignificant8Bits(data[i]);
        }

        int idx = 0;
        while(idx<bytes.length) {
            String first = bytes[idx];
            if(first.charAt(0)=='0') {
                idx++;
            } else {
                int n = 1;
                while(first.charAt(n)=='1') {
                    n++;
                    if(n>4) {
                        return false;
                    }
                }
                if(n==1) {
                    return false;
                }
                boolean isValid = validNBytes(bytes, idx, n);
                if(!isValid) {
                    return false;
                }
                idx += n;
            }
        }

        return true;
    }

    private String getLeastSignificant8Bits(int num) {
        StringBuilder builder = new StringBuilder();
        int mask = 1;
        for(int i=0; i<8; i++) {
            if((num&mask)!=0) {
                builder.insert(0, '1');
            } else {
                builder.insert(0, '0');
            }
            mask <<= 1;
        }

        return builder.toString();
    }

    private boolean validNBytes(String[] bytes, int start, int n) {
        for(int i=1; i<n; i++) {
            if(start+i>=bytes.length) {
                return false;
            }
            String next = bytes[start+i];
            if(next.charAt(0)!='1'||next.charAt(1)!='0') {
                return false;
            }
        }
        return true;
    }
}