package leetcode;

import javax.transaction.TransactionRequiredException;
import java.util.*;

/**
 * Created by admin on 2014/11/2.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class TreeLinkNodeTest {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null){
            TreeLinkNode curNode = head;
            TreeLinkNode tmpNextHead = new TreeLinkNode(0);
            TreeLinkNode pre = tmpNextHead;
            while(curNode != null){
                if(curNode.left != null){
                    pre.next = curNode.left;
                    pre = pre.next;
                }
                if(curNode.right != null){
                    pre.next = curNode.right;
                    pre = pre.next;
                }
                curNode = curNode.next;
            }
            head = tmpNextHead.next;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        TreeNode flag = new TreeNode(0);
        ArrayDeque<TreeNode> arrQueue = new ArrayDeque<TreeNode>();
        arrQueue.add(root);
        arrQueue.add(flag);
        boolean isOdd = true;

        List<Integer> tmpList = new ArrayList<Integer>();
        while (arrQueue.size() > 1){
            TreeNode top = arrQueue.removeFirst();
            if(top == flag){
                arrQueue.add(flag);
                if(isOdd) Collections.reverse(tmpList);
                list.add(tmpList);
                tmpList = new ArrayList<Integer>();
                isOdd = !isOdd;
            }else{
                tmpList.add(top.val);
                if(top.left != null) arrQueue.add(top.left);
                if(top.right != null) arrQueue.add(top.right);
            }


        }
        return list;

    }

    public static void main(String args[]){
        TreeLinkNodeTest s = new TreeLinkNodeTest();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list = s.zigzagLevelOrder(root);
        System.out.println(list);
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}