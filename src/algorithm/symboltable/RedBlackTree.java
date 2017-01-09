package algorithm.symboltable;

/**
 *
 * @author zhengluming <luming.zheng@shandjj.com>
 * @param <Value>
 */
public class RedBlackTree<Value> implements SymbolTable<Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        private final String key;

        private Value value;

        private Node left, right;

        private boolean color;

        public Node(String key, Value value) {
            this.key = key;
            this.value = value;
            this.color = RED;
        }

    }

    public void put(String key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, String key, Value value) {
        if (h == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
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

    public String min() {
        if (root == null) {
            return null;
        }

        return min(root).key;
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

    public void deleteMin() {
        if (root == null) {
            return;
        }

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMin(root);
        if (root != null) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }

        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }

        h.left = deleteMin(h.left);
        return fixUp(h);
    }

    public void delete(String key) {

    }

    private Node delete(Node x, String key) {

    }

    /**
     * 向左旋转一个右倾斜的链接
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * 向右旋转一个左倾斜的链接
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /**
     * 是否一个节点的颜色是红的
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }

        return x.color == RED;
    }

    /**
     * 恢复红黑树不变量
     *
     * @param h
     * @return
     */
    private Node fixUp(Node h) {
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }
}
