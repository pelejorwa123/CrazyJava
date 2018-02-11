package chapter3;

/**
 *@author: pele
 *@time: 2018/2/9 18:39
 *@package: chapter3
 *@descroption:计算二叉树的高度，递归调用算法
 */
import java.util.*;
class Node{
    int number;
    Node lchild;
    Node rchild;
    public Node(int number){
        this.number = number;
    }
    public void setLchild(Node lchild){
        this.lchild = lchild;
    }
    public void setRchild(Node rchild){
        this.rchild = rchild;
    }
}
public class ReverseWordList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nodeCount = 0;
        List<Node> nodeTree = new ArrayList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.matches("\\d")){
                nodeCount = Integer.parseInt(line);
                for(int i=0;i<nodeCount;i++){
                    Node node = new Node(i);
                    nodeTree.add(node);
                }
            }else {
                if (line.equals("")) {
                    break;
                }
                String[] relation = line.split("\\s");
                int parent = Integer.parseInt(relation[0]);
                int child = Integer.parseInt(relation[1]);
                Node parentNode = nodeTree.get(parent);
                Node childNode = nodeTree.get(child);
                if (null == parentNode.lchild) {
                    parentNode.lchild = childNode;
                } else {
                    parentNode.rchild = childNode;
                }
            }
        }
        int height = calTreeHeight(nodeTree.get(0));
        System.out.println(height);

    }

    public static int calTreeHeight(Node parent){
        //没有子节点时递归返回
        if(parent.lchild ==null && parent.rchild == null){
            return 1;
        }
        int lchildTreeHeight=0,rchildTreeHeight=0;
        if(null != parent.lchild){
            lchildTreeHeight = calTreeHeight(parent.lchild);
        }
        if(null != parent.rchild){
            rchildTreeHeight = calTreeHeight(parent.rchild);
        }
        int maxHeight;
        if(lchildTreeHeight>=rchildTreeHeight){
            maxHeight = lchildTreeHeight;
        }else{
            maxHeight = rchildTreeHeight;
        }
        return ++maxHeight;
    }
}