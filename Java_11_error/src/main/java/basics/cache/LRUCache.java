package basics.cache;
import java.util.LinkedHashMap;
import java.util.Map;
//很重要的一点， 此类不是线程安全的，所以使用的时候你需要加锁。
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
  private int cacheSize;

  public LRUCache(int cacheSize) {
    super(16, (float) 0.75, true);
    this.cacheSize = cacheSize;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() >= cacheSize;
  }
}