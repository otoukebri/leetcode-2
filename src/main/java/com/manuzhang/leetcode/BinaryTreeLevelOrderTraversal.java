package com.manuzhang.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lo = new LinkedList<List<Integer>>();
    if (root == null) {
      return lo;
    }
    List<Integer> v = new LinkedList<Integer>();
    v.add(root.val);
    lo.add(v);
    List<List<Integer>> llo = levelOrder(root.left);
    List<List<Integer>> rlo = levelOrder(root.right);
    Iterator<List<Integer>> li = llo.iterator();
    Iterator<List<Integer>> ri = rlo.iterator();
    while (li.hasNext() && ri.hasNext()) {
      List<Integer> merged = new LinkedList<Integer>();
      merged.addAll(li.next());
      merged.addAll(ri.next());
      lo.add(merged);
    }
    while (li.hasNext()) {
      lo.add(li.next());
    }
    while (ri.hasNext()) {
      lo.add(ri.next());
    }

    return lo;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
  }
}