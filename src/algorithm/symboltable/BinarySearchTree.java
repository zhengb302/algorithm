package algorithm.symboltable;

/**
 * 二叉搜索树
 *
 * @author Lumeng <zhengb302@163.com>
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    private Node root;

    private class Node {

        private final Key key;

        private Value value;

        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
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

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
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

    public Key min() {
        Node minNode = min(root);
        return minNode != null ? minNode.key : null;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }

            Node tmp = x;
            x = min(x.right);
            x.right = deleteMin(tmp.right);
            x.left = tmp.left;
        }

        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left != null) {
            x.left = deleteMin(x.left);
            return x;
        } else {
            return x.right;
        }
    }

}
