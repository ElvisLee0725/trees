// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than

// Base Case: a. head is null b. head is the only node in the list
// Use fast, slow and dummy pointer to get the middle node as the root node
// Do recursion with the left half of linked list at root's left child, the right half at root's right child
// Return the root at the end

// Time: O(nlogn), Space: O(logn)

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        TreeNode root = new Solution().sortedListToBST(a);
        new Solution().levelPrint(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        else if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = null;
        while(fast != null && fast.next != null) {
            dummy = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        dummy.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    public void levelPrint(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();

            if(cur != null) {
                System.out.print(cur.val);

                if(cur.left != null || cur.right != null) {
                    if(cur.left != null) {
                        q.offer(cur.left);
                    }
                    else {
                        q.offer(null);
                    }

                    if(cur.right != null) {
                        q.offer(cur.right);
                    }
                    else {
                        q.offer(null);
                    }
                }
            }
            else {
                System.out.print("null");
            }

            if(!q.isEmpty()) {
                System.out.print(", ");
            }
        }
    }

}
