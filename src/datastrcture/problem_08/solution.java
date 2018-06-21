package datastrcture.problem_08;




public class solution {

    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        // 当前节点有右节点
        if(pNode.right != null){
            TreeLinkNode p = pNode.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        // 当前节点没有右节点
        }else{
            // 判断是否为根节点
            if(pNode.father == null){
                return null;
            }
            // 判断是否为父节点的左孩子
            while (pNode.father != null){
                if(pNode.father.left == pNode){
                    return pNode.father;
                }
                pNode = pNode.father;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode("a");
        root.left = new TreeLinkNode("b");
        root.left.father = root;
        root.right = new TreeLinkNode("c");
        root.right.father = root;
        root.left.left = new TreeLinkNode("d");
        root.left.left.father = root.left;
        root.left.right = new TreeLinkNode("e");
        root.left.right.father = root.left;
        root.left.right.left = new TreeLinkNode("h");
        root.left.right.left.father = root.left.right;
        TreeLinkNode node = new TreeLinkNode("i");
        root.left.right.right = node;
        root.left.right.right.father = root.left.right;

        // fuck
        root.right.left = new TreeLinkNode("f");
        root.right.left.father = root.right;
        root.right.right = new TreeLinkNode("g");
        root.right.right.father = root.right;

        System.out.println(getNext(node).val);

    }
}
