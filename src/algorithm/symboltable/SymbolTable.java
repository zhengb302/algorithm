package algorithm.symboltable;

/**
 * 符号表接口
 *
 * @author Lumeng <zhengb302@163.com>
 * @param <Value> key-value对里边，value的类型
 */
public interface SymbolTable<Value> {

    public void put(String key, Value value);

    public Value get(String key);

    public void delete();
}
