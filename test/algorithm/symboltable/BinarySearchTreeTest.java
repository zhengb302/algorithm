package algorithm.symboltable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lumeng <zhengb302@163.com>
 */
public class BinarySearchTreeTest {

    public BinarySearchTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class BinarySearchTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");

        BinarySearchTree<String, Integer> bst = new BinarySearchTree();
        bst.put("zhangsan", 18);
        assertEquals(18, (int) bst.get("zhangsan"));
    }

    /**
     * Test of get method, of class BinarySearchTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");

        BinarySearchTree<String, Integer> bst = new BinarySearchTree();
        bst.put("zhangsan", 18);
        assertEquals(18, (int) bst.get("zhangsan"));

        assertEquals(null, bst.get("lisi"));
    }

    /**
     * Test of delete method, of class BinarySearchTree.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");

        BinarySearchTree<String, Integer> bst = new BinarySearchTree();
        bst.put("zhangsan", 18);
        assertEquals(18, (int) bst.get("zhangsan"));

        bst.delete("zhangsan");
        assertEquals(null, bst.get("zhangsan"));
    }

}
