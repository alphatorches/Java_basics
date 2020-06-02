package torches.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数组实现
 */
public class BinaryTree {

    private Node[] tree = new Node[100005];
    private int root;
    private int len;

    public BinaryTree() {
        root = 0;
        len = 0;
    }

    // 节点
    private class Node{
        int val;
        int l;
        int r;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", l=" + l +
                    ", r=" + r +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "BinaryTree{" +
                "tree=" + Arrays.toString(tree) +
                ", root=" + root +
                ", len=" + len +
                '}';
    }

    // 递归插入
    public int insertData(int value, int x){
        // 初始化根节点
        if (x == 0){
            x = ++len;
            tree[x] = new Node();
            tree[x].val = value;
            tree[x].l = 0;
            tree[x].r = 0;
            return x;
        }
        if (value <= tree[x].val){
            tree[x].l = insertData(value, tree[x].l);
        }else {
            tree[x].r = insertData(value, tree[x].r);
        }
        return x;
    }


    // 前序遍历
    public ArrayList DLR(int root, ArrayList arrayList){

        arrayList.add(tree[root].val);
        if (tree[tree[root].l] != null){
            DLR(tree[root].l, arrayList);
        }
        if (tree[tree[root].r] != null){
            DLR(tree[root].r, arrayList);
        }
        return arrayList;
    }

    // 后续遍历
    public ArrayList LRD(int root, ArrayList arrayList){


        if (tree[tree[root].l] != null){
            LRD(tree[root].l, arrayList);
        }
        if (tree[tree[root].r] != null){
            LRD(tree[root].r, arrayList);
        }
        arrayList.add(tree[root].val);
        return arrayList;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int root = 0;
        int[] num = {2,6,9,3,5,7,10,8,4,1};
        for (int i = 0; i < num.length; ++i) {
            root = binaryTree.insertData(num[i],root);
        }
        System.out.println(binaryTree.DLR(1,new ArrayList()));
        System.out.println(binaryTree.LRD(1,new ArrayList()));
    }

}
