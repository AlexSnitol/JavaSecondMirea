import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V>
{
    private int size = 0;
    private NodeKV<K, V> head;

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public boolean isEmpty()
    {
        if (this.size == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean containsKey(Object key)
    {
        return false;
    }

    @Override
    public boolean containsValue(Object value)
    {
        return false;
    }

    @Override
    public V get(Object key)
    {
        return null;
    }

    @Override
    public V remove(Object key)
    {
        return null;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public Set<K> keySet()
    {
        return null;
    }

    @Override
    public Collection values()
    {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        return null;
    }

    @Override
    public void putAll(Map m)
    {

    }

    @Override
    public synchronized V put(K key, V value)
    {
        NodeKV<K, V> newNode = new NodeKV<K, V>(key, value);
        NodeKV<K, V> tmpNode = head;

        V tmpValue;

        if (this.isEmpty())
        {
            this.head = newNode;
        }
        else
        {
            while (tmpNode.getNext() != null)
            {
                if (tmpNode.getKey() == key)
                {
                    tmpValue = tmpNode.getValue();
                    tmpNode.setValue(value);

                    return tmpValue;
                }
                tmpNode = tmpNode.getNext();
            }

            if (tmpNode.getKey() == key)
            {
                tmpValue = tmpNode.getValue();
                tmpNode.setValue(value);

                return tmpValue;
            }
            else
            {
                tmpNode.setNext(newNode);
            }
        }

        this.size++;

        return null;
    }

    public void printMap()
    {
        NodeKV<K, V> tmpNode = this.head;

        while (tmpNode != null)
        {
            System.out.print("[" + tmpNode.getKey() + "]:" + tmpNode.getValue() + ";");

            tmpNode = tmpNode.getNext();
        }
    }
}
