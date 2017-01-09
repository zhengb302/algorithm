package algorithm.symboltable;

/**
 * 符号表接口
 *
 * @author Lumeng <zhengb302@163.com>
 * @param <Key> key-value对里边，key的类型
 * @param <Value> key-value对里边，value的类型
 */
public interface SymbolTable<Key extends Comparable<Key>, Value> {

    public void put(Key key, Value value);

    public Value get(Key key);

    public void delete(Key key);
}
