package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cc_ff
 * @creat 2019-12-2019/12/21-19:19
 */
public class ThreeLinkTree<E> {

    //节点
    public static class TreeNode {
        Object data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(){

        }

        public TreeNode(Object data){
            this.data = data;
        }

        public TreeNode(Object data,TreeNode left,TreeNode right,TreeNode parent){
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }
    //根节点
    private TreeNode root;

    //空参默认构造器创建二叉树
    public ThreeLinkTree(){
        this.root = new TreeNode();
    }

    public ThreeLinkTree(E data){
        this.root = new TreeNode(data);
    }


    /**
     * 添加子节点
     * @param parent
     * @param data
     * @param isLeft
     * @return
     */
    public TreeNode addNode(TreeNode parent, E data,boolean isLeft){

        if (parent == null){
            throw new RuntimeException("节点为空，无法添加子节点");
        }

        if(isLeft && parent.left != null){
            throw new RuntimeException("节点已有左子节点，不可重复添加");
        }

        if(!isLeft && parent.right != null){
            throw new RuntimeException("节点已有右子节点，不可重复添加");
        }

        TreeNode newNode = new TreeNode(data);

        if(isLeft){
            //添加左子节点
            parent.left = newNode;
        }else {
            //添加右子节点
            parent.right = newNode;
        }
        //子节点的父节点指向此节点
        newNode.parent = parent;

        return newNode;
    }

    //二叉树是否为空
    public boolean empty(){
        return root.data == null;
    }

    //返回根节点
    public TreeNode root(){
        if (empty()){
            throw new RuntimeException("树为空，无根节点");
        }

        return root;
    }

    public TreeNode parent(TreeNode node){
        if (node == null){
            throw new RuntimeException("空结点无父节点");
        }

        return node.parent;
    }

    //返回左孩子
    public TreeNode leftChild(TreeNode parent){
        if(parent == null){
            throw new RuntimeException("空结点无子节点");
        }

        return parent.left == null ? null : parent.left;
    }

    //返回左孩子
    public TreeNode rightChild(TreeNode parent){
        if(parent == null){
            throw new RuntimeException("空结点无子节点");
        }

        return parent.right == null ? null : parent.right;
    }

    //二叉树深度
    public int deep(){

        return deep(root);
    }

    //深度(每棵子树的深度为其所有子树的最大深度加一)
    private int deep(TreeNode node){
        if (node == null){
            return 0;
        }
        //无子树
        if (node.left == null && node.right == null){
            return 1;
        }else {
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);

            int max = leftDeep > rightDeep ? leftDeep :rightDeep;

            return max+1;
        }
    }

    public List<TreeNode> preIterator(){
        return preIterator(root);
    }

    public List<TreeNode> preIterator(TreeNode node){
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(node);
        if (node.left != null){
            list.addAll(preIterator(node.left));
        }

        if (node.right != null){
            list.addAll(preIterator(node.right));
        }

        return list;
    }

    public List<TreeNode> inIterator(){
        return inIterator(root);
    }

    public List<TreeNode> inIterator(TreeNode node){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (node.left != null){
            list.addAll(preIterator(node.left));
        }

        list.add(node);

        if (node.right != null){
            list.addAll(preIterator(node.right));
        }

        return list;
    }

    private TreeNode head;
    private TreeNode pre;
    public TreeNode toDuLinkList(){
        pre = null;
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null){
            pre.right = node;
        }

        pre = node;
        if (head == null){
            head = node;
        }
        inOrder(node.right);

    }
}
