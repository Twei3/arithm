import java.util.Stack;

/**
 * 给出一棵二叉树的前序和中序遍历，输出后序遍历的结果。
 * 如输入(前序__中序)：ABDHECFG__HDBEAFCG 输出(后序)：HDEBFGCA。
 * @author tangwei
 *
 */
public class BinaryTree {

	public static void main(String[] args) {
		String[] str = args[0].split("__");
		char[] prechar = str[0].toCharArray();
		char[] midchar = str[1].toCharArray();
		String[] pre = new String[prechar.length];
		for(int i = 0; i < prechar.length; i++){
			pre[i] = String.valueOf(prechar[i]);
		}
		String[] mid = new String[midchar.length];
		for(int j = 0; j < midchar.length; j++){
			mid[j] = String.valueOf(midchar[j]);
		}
		String[] tree = rebuildTree(pre, mid);
		afterTraverse(tree);
	}
	
	// 重建树  
    public static String[] rebuildTree(String[] pre, String[] mid) {  
        int len = pre.length;  
        String[] tree = new String[(int) Math.pow(2, len-1)];  
        build(tree, pre, mid, 1);  
        return tree;  
    }  
  
    public static String[] build(String[] tree, String[] pre, String[] mid,int rootIndex){  
        int len = pre.length;  
        if(pre.length == 1){  
            tree[rootIndex] = pre[0];  
            return tree;   
        }else if(mid.length == 1){  
            tree[rootIndex] = mid[0];  
            return tree;  
        }  
          
        String root = "";  
        if(pre.length>0){   
            root = pre[0];  
        }else if(mid.length > 0){  
            root = mid[0]; 
        }
        tree[rootIndex] = root;  
        int i = 0;  
        for(i=0;i<len;i++){  
            if(root.equals(mid[i])){ 
                break; 
            }
        }  
        //得到中序遍历中的左树数组  
        String leftpre[] = new String[i];  
        String rightpre[] = new String[len-1-i];  
        String leftmid[] = new String[i];  
        String rightmid[] = new String[len-1-i]; 
        for(int j=0; j<len; j++){  
            //左边前序和右边前序赋值  
            if(j < i){ 
                leftpre[j] = pre[j+1];  
            }else if(j<len-1){ 
                rightpre[j-i] = pre[j+1];   
            }
            //左边中序和右边中序  
            if(!root.equals(mid[j])){  
                if(j < i){
                	leftmid[j] = mid[j]; 
                } else{ 
                    rightmid[j-i-1] = mid[j];  
                }
            }             
        }  
        if(leftpre.length > 0 || leftmid.length > 0){
        	tree = build(tree, leftpre, leftmid, 2*rootIndex); 
        }  
        if(rightpre.length > 0 || rightmid.length > 0){
        	tree = build(tree, rightpre, rightmid, 2*rootIndex+1);  
        }  
        return tree;  
    }  
    /**
     * 后序遍历
     * @return
     */
    public static void afterTraverse(String tree[]){
    	Stack<String> stack = new Stack<String>();  
        stack = after(tree,1,stack);  
        while(!stack.isEmpty()){
        	System.out.print(stack.pop());
        } 
    }
    
    public static Stack<String> after(String tree[],int root,Stack<String> stack)  
    {  
        //每次压入栈的都是当前的根节点，当前根节点没有子节点时，返回该栈，  
        //注意栈的放入顺序是先右孩子再左孩子，这样输出的时候就是先左孩子再右孩子  
        if(tree[root] == null || "".equals(tree[root])){
        	return null; 
        }  
        stack.push(tree[root]);  
        if(tree[root*2+1] != null){  
        	after(tree,root*2+1,stack);  
        }  
        if(tree[root*2] != null){  
        	after(tree,root*2,stack);  
        }     
        return stack;  
    }  

}
