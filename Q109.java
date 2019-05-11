/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.ArrayList;

class Q109 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodes = listToArray(head);
        return constructBST(nodes, 0, nodes.size()-1);
    }

    private List<Integer> listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while(head!=null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    private TreeNode constructBST(List<Integer> nodes, int start, int end) {
        if(start>end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nodes.get(mid));
        TreeNode left = constructBST(nodes, start, mid-1);
        TreeNode right = constructBST(nodes, mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}