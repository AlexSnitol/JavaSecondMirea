public class NodeKV <K, V>
{
    private K key;
    private V value;
    private NodeKV<K, V> next = null;


    NodeKV() {};

    NodeKV(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public NodeKV<K, V> getNext()
    {
        return next;
    }

    public void setNext(NodeKV<K, V> next)
    {
        this.next = next;
    }

    public K getKey()
    {
        return key;
    }

    public void setKey(K key)
    {
        this.key = key;
    }

    public V getValue()
    {
        return value;
    }

    public void setValue(V value)
    {
        this.value = value;
    }
}
