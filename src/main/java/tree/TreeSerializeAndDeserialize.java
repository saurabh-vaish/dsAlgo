package tree;


import java.util.*;

/**
 * @Link == https://www.codingninjas.com/studio/problems/serialise-deserialise-a-binary-tree_920328?topList=striver-sde-sheet-problems&leftPanelTab=1
 *
 * Compl == O(N)
 *
 * @Author saurabh vaish
 * @Date 04-07-2023
 */
public class TreeSerializeAndDeserialize {

    public static String serialize(TreeNode<Integer> root){
        StringBuilder sb= new StringBuilder();
        if(root==null)return "";
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            if(node==null ) {
                sb.append("# ");
                continue;
            }
            sb.append(node.data).append(" ");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    public static TreeNode deserialize(String data){
        if(data==null || data.equals(""))return null;
        String[] arr = data.split(" ");
        TreeNode<Integer> root = new TreeNode<Integer>(Integer.parseInt(arr[0]));
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        for(int i=1;i<arr.length;i++){
            TreeNode<Integer> parent = q.poll();
            if(!arr[i].equals("#")){
                TreeNode<Integer> left= new TreeNode<Integer>(Integer.parseInt(arr[i]));
                parent.left= left;
                q.offer(left);
            }
            if(!arr[++i].equals("#")){
                TreeNode<Integer> right= new TreeNode<Integer>(Integer.parseInt(arr[i]));
                parent.right=right;
                q.offer(right);
            }

        }

        return root;
    }


    //==========================

    static String serializeRec(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return "" + root.data + "," + serializeRec(root.left) + "," + serializeRec(root.right);
    }


    static TreeNode deserializeRec(String data) {
        if (data == null){
            return null;
        }

        List<String> values = new ArrayList<>(Arrays.asList(data.split(",")));

        return deserial(values);
    }

    private static TreeNode deserial(List<String> values){
        String val = values.remove(0);

        if (val.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserial(values);
        root.right = deserial(values);
        return root;
    }


    private static TreeNode<Integer> root;
    public static void main(String[] args) {

       int n= 4;
        int ar[][] = {{1 ,-1, 3, -1, -1},{
        3 ,4 ,-1, -1, -1},{
        1 ,2, 3, -1, 4, 5, -1, -1, -1, -1, -1},{
        2 ,1 ,3 ,4 ,-1 ,-1 ,5 ,-1 ,-1 ,-1 ,-1}};

        for (int [] a:ar){
            root = null;
            Arrays.stream(a).forEach(ee->{
                insert(root,ee);
            });

            String serialize = serialize(root);

            System.out.println(serialize);

            TreeNode<Integer> deserialize = deserialize(serialize);


            bfs(deserialize);
            System.out.println();
            System.out.println(deserialize);

        }
//        String serialize2 = serialize(deserialize);
//
//        System.out.println(serialize2);
//
//        System.out.println(serialize.equals(serialize2));

        System.out.println(" ============= using recursion =========== ");


        for (int [] a:ar){
            root = null;
            Arrays.stream(a).forEach(ee->{
                insert(root,ee);
            });

            String serialize = serializeRec(root);

            System.out.println(serialize);

            TreeNode<Integer> deserialize = deserializeRec(serialize);


            bfs(deserialize);
            System.out.println();
            System.out.println(deserialize);

        }

    }




    static void insert(TreeNode<Integer> temp, int key)
    {

        if (temp == null) {
            root = new TreeNode<Integer>(key);
            return;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new TreeNode<Integer>(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new TreeNode<Integer>(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public static void bfs(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root); // O(1)

        while (!queue.isEmpty()){
            TreeNode<Integer> visited = queue.poll();  // similar to dequeue() in queue O(1)
            System.out.print(visited.data+" ");
            if (visited.left!=null){
                queue.offer(visited.left);  // offer used bcs it will not throw exception if insertion is failed
            }
            if (visited.right!=null){
                queue.offer(visited.right);
            }
        }
    }

}
