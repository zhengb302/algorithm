package algorithm.graph;

import algorithm.basic.Bag;
import algorithm.util.In;
import algorithm.util.StdOut;

/**
 * Graph
 *
 * @author zhengluming <luming.zheng@shandjj.com>
 */
public class Graph {

    private final int numOfVertex;

    private int numOfEdge;

    private Bag<Integer>[] adj;

    public Graph(In in) {
        numOfVertex = in.readInt();
        if (numOfVertex < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        }

        //边数初始化为0。因为边数可能会因为添加边而增加，
        //所以不能直接从输入中读取。
        numOfEdge = 0;

        adj = new Bag[numOfVertex];
        for (int i = 0; i < numOfVertex; i++) {
            adj[i] = new Bag();
        }

        int tmpNumOfEdge = in.readInt();
        if (tmpNumOfEdge < 0) {
            throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
        }

        for (int j = 0; j < tmpNumOfEdge; j++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            addEdge(v, w);
        }
    }

    /**
     * 向图中添加边
     *
     * @param v 边的一个顶点
     * @param w 边的另一个顶点
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        numOfEdge++;
    }

    /**
     * 校验顶点(编号)是否有效
     *
     * @param v
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= numOfVertex) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (numOfVertex - 1));
        }
    }

    /**
     * 返回此图顶点的个数
     *
     * @return
     */
    public int numOfVertex() {
        return numOfVertex;
    }

    /**
     * 返回此图边的条数
     *
     * @return
     */
    public int numOfEdge() {
        return numOfEdge;
    }

    /**
     * 返回与顶点{@code v}相邻的(所有)顶点
     *
     * @param v
     * @return 与顶点{@code v}相邻的(所有)顶点
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * 返回顶点{@code v}的度
     *
     * @param v
     * @return 顶点{@code v}的度
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of
     * edges <em>E</em>, followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(numOfVertex + " vertices, " + numOfEdge + " edges " + "\n");
        for (int v = 0; v < numOfVertex; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }

}
