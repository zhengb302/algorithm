package algorithm.symboltable;

/**
 * 二叉搜索树
 *
 * @author Lumeng <zhengb302@163.com>
 * @param <Value>
 */
public class BinarySearchTree<Value> implements SymbolTable<Value> {

    private Node root;

    private class Node {

        private final String key;

        private Value value;

        private Node left, right;

        public Node(String key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public void put(String key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, String key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    public Value get(String key) {
        return get(root, key);
    }

    private Value get(Node x, String key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void delete(String key) {

    }

    public static void main(String args[]) {
        SymbolTable<Integer> bst = new BinarySearchTree();
        bst.put("zhangsan", 18);

        assert bst.get("zhangsan") == 18;
        assert bst.get("lisi") == null;

        bst.delete("zhangsan");
        assert bst.get("zhangsan") == null;
    }
}
