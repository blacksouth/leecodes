package tree;

import javax.swing.tree.TreeNode;

/* BitTree.java */



import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jaco.Young.
 * 2018-06-13 18:26
 */
public class BitTree {

    //代表由先序和中序唯一确定的树的根结点
    private TreeNode root;

    /**
     * 提供给外部调用的方法
     * 字符数组pre表示先序遍历序列，mid表示中序遍历序列
     */
    public void build(char[] pre, char[] mid){
        //将创建树的根结点赋值给 root
        root = buildTree(pre,0, pre.length-1, mid, 0, mid.length-1);
    }

    /**
     * 前提条件，树中不存在重复元素
     * 由先序遍历序列和中序遍历序列，构造二叉树的方法
     * 我们建树的过程总是将序列不断地分割成左子树、右子树
     * lPre、rPre和lMid、rMid，分别就表示要对先序和中序的哪一部分进行建树
     */
    private TreeNode buildTree(char[] pre, int lPre, int rPre, char[] mid, int lMid, int rMid){
        //在先序遍历序列中，找到当前这棵树的根结点
        char root = pre[lPre];

        //在中序遍历序列中，根据先序中的根结点来查找在中序中的位置
        int rootIndex = getRootIndex(mid, lMid, rMid, root);

        //如果没有找到，说明所给的参数异常
        if(rootIndex == -1){
            throw new IllegalArgumentException("Illegal Argument!");
        }

        //计算当前这棵树，左右子树的个数
        //整个中序序列：[左子树(lMid)  root(rootIndex)  右子树(rMid)]
        //左子树[lMid,rootIndex-1]
        int lNum = rootIndex - lMid; //rootIndex-1 -lMid + 1
        //右子树[rootIndex+1,rMid]
        int rNum = rMid - rootIndex;  //rMid - (rootIndex + 1) + 1

        //开始构建当前根结点的左子树和右子树
        //先构建左子树
        TreeNode lchild;  //作为左子树的根结点
        //以当前结点为根的树，没有左子树
        if(lNum == 0){
            lchild = null;
        }else{
            //当前这个树的左子树，仍然是一棵树，递归构造这棵树的左子树
            //设x为当前树先序中左子树最后一个元素的下标，则：x - (lpre + 1) = lNum
            //得：x = lPre + lNum
            lchild = buildTree(pre, lPre + 1, lPre+lNum, mid, lMid, rootIndex - 1);
        }

        //构建右子树
        TreeNode rchild;
        if(rNum == 0){
            rchild = null;
        }else{
            //当前结点的右子树，仍然包含很多节点，需要递归的构造其右子树
            rchild = buildTree(pre, lPre + lNum + 1, rPre, mid, rootIndex + 1, rMid);
        }

        //构造完整的二叉树
        return new TreeNode(root,lchild,rchild);
    }

    //在中序遍历序列中，根据先序中的根结点来查找在中序中的位置
    private int getRootIndex(char[] mid, int lMid, int rMid, char root) {
        for(int i = lMid; i <= rMid; i++){
            if(mid[i] == root){
                return i;
            }
        }
        return -1;
    }

    //二叉树每一个结点的结构
    private class TreeNode{
        //结点中存储的数据
        char item;
        //指向左孩子结点
        TreeNode lChild;
        //指向右孩子结点
        TreeNode rChild;

        //构造方法,完成初始化
        public TreeNode(char item, TreeNode lChild, TreeNode rChild){
            this.item = item;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }

    //提供三个让外界调用的方法
    public  void preTraverse() {
        preOrder(root);
    }

    public void midTraverse() {
        midOrder(root);
    }

    public void postTraverse() {
        postOrder(root);
    }

    //先序遍历  DLR
    private void preOrder(TreeNode root) {
        if( root != null) {
            //先访问根节点
            System.out.print(root.item + " ");
            //递归访问左子树
            preOrder(root.lChild);
            //递归访问右子树
            preOrder(root.rChild);
        }
    }

    //中序遍历   LDR
    private void midOrder(TreeNode root) {
        if(root != null) {
            //递归访问左子树
            midOrder(root.lChild);
            //访问根
            System.out.print(root.item + " ");
            //递归访问右子树
            midOrder(root.rChild);
        }
    }

    //后续遍历
    // LRD
    private void postOrder(TreeNode root) {
        if(root != null) {
            //递归访问左子树
            postOrder(root.lChild);
            //递归访问右子树
            postOrder(root.rChild);
            //访问根
            System.out.print(root.item + " ");
        }
    }

    //广度优先遍历  BFS
    public void BFS() {
        //创建一个能放TreeNode对象的队列
        Queue<TreeNode> queue = new LinkedList<>();
        //将树的根节点入队列
        queue.add(root);
        //循环执行广度优先遍历
        while(!queue.isEmpty()) {
            //将当前的队头元素出队列
            TreeNode node = queue.remove();
            //访问出队列的节点
            System.out.print(node.item + " ");

            //出队列的节点是否有左孩子，有则将其左孩子入队列
            if(node.lChild != null) {
                //有左孩子
                queue.add(node.lChild);
            }
            //出队列的节点是否有右孩子，如果右，将其右孩子如队列
            if(node.rChild != null) {
                queue.add(node.rChild);
            }
        }
    }
}

