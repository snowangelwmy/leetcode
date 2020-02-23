/**
 * Test cases:
 * 1: Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * 2: Input: "1,#"
 * Output: false
 * 3: Input: "9,#,#,1"
 * Output: false
 * 4: Input: "1,#,#,#,#"
 * Output: false
 */

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Q331 {

    class Node {
        String value;
        List<Boolean> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>(2);
        }
    }

    public boolean isValidSerialization(String preorder) {
        if(preorder==null||preorder.length()==0) {
            return false;
        }

        Stack<Node> nodes = new Stack<>();
        String[] values = preorder.split(",");
        if(values[0].equals("#")) {
            return values.length==1;
        }
        nodes.push(new Node(values[0]));
        for(int i=1; i<values.length; i++) {
            String value = values[i];
            if(nodes.isEmpty()) {
                return false;
            }
            Node parent = nodes.peek();
            parent.children.add(true);
            if(parent.children.size()==2) {
                nodes.pop();
            }
            if(!value.equals("#")) {
                Node current = new Node(value);
                nodes.push(current);
            }
        }

        return nodes.isEmpty();
    }
}