package algorithm.symboltable;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author zhengluming <luming.zheng@shandjj.com>
 */
public class RedBlackTreeTest extends TestCase {

    public RedBlackTreeTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of put method, of class RedBlackTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");

        RedBlackTree<String, Integer> bst = new RedBlackTree();
        bst.put("zhangsan", 18);
        assertEquals(18, (int) bst.get("zhangsan"));
    }

    /**
     * Test of get method, of class RedBlackTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");

        RedBlackTree<String, Integer> bst = new RedBlackTree();
        bst.put("zhangsan", 18);
        assertEquals(18, (int) bst.get("zhangsan"));

        assertEquals(null, bst.get("lisi"));
    }

    /**
     * Test of delete method, of class RedBlackTree.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");

        RedBlackTree<String, Integer> bst = new RedBlackTree();
        bst.put("zhangsan", 18);
        assertEquals(18, (int) bst.get("zhangsan"));

        bst.delete("zhangsan");
        assertEquals(null, bst.get("zhangsan"));
    }

}
