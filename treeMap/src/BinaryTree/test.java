package BinaryTree;

import org.junit.Test;

import java.util.List;

/**
 * @author cc_ff
 * @creat 2019-12-2019/12/21-19:51
 */
public class test {

    @Test
    public void testThreeLinkTree(){
        ThreeLinkTree<Integer> tree = new ThreeLinkTree<>(10);

        ThreeLinkTree.TreeNode treeNode1 = tree.addNode(tree.root(), 3, true);
        ThreeLinkTree.TreeNode treeNode2 = tree.addNode(tree.root(), 18, false);
        ThreeLinkTree.TreeNode treeNode3 = tree.addNode(treeNode1, 4, false);
        ThreeLinkTree.TreeNode treeNode4 = tree.addNode(treeNode1, 2, true);

//        List<ThreeLinkTree.TreeNode> list = tree.preIterator();
//        System.out.println(list);
//        System.out.println(tree.inIterator());
        ThreeLinkTree.TreeNode head = tree.toDuLinkList();
        System.out.println(head.data);
        while (head!=null){
            System.out.println(head.data);
            head = head.right;
        }

    }
}
