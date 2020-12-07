package tree;
/**
 * 测试类
 * Created by Jaco.Young.
 * 2018-06-13 20:16
 */
public class TestTree {
    public static void main(String[] args){
        //构造先序遍历序列和中序遍历序列
        char[] pre = {'A','B','E', 'K', 'L', 'F', 'D', 'H', 'J'};
        char[] mid = {'K', 'E', 'L', 'B', 'F', 'A', 'H', 'D', 'J'};

        BitTree bitTree = new BitTree();
        //根据遍历序列构建二叉树
        bitTree.build(pre, mid);

        //先序遍历
        bitTree.preTraverse();
        System.out.println();
        //中序遍历
        bitTree.midTraverse();
        System.out.println();
        //后序遍历
        bitTree.postTraverse();
        System.out.println();
        //广度优先遍历
        bitTree.BFS();
    }
}


