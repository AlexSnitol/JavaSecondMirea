package ru.mirea.task3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

public class MyList<T> implements List<T>
{
    private int size;
    private Node<T> head;
    private Node<T> last;
    private static final Semaphore semaphore = new Semaphore(1);


    public Node<T> getHead()
    {
        return head;
    }

    public void setHead(Node<T> newHead)
    {
        this.head = newHead;
    }

    public void printList()
    {
        Node<T> tmpNode = this.head;

        while (tmpNode != null)
        {
            System.out.print(tmpNode.getData() + ";");
            tmpNode = tmpNode.getNext();
        }
    }

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public boolean isEmpty()
    {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Object o)
    {
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return null;
    }

    @Override
    public boolean add(T data)
    {
        try
        {
            semaphore.acquire();

            Node<T> newNode = new Node<T>(data);

            if (this.isEmpty())
            {
                this.head = newNode;
                this.last = this.head;
            }
            else
            {
                this.last.setNext(newNode);
                this.last = newNode;
            }

            this.size++;

            semaphore.release();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public T get(int index)
    {
        Node<T> tmpNode = this.head;

        for (int i = 0; i < index; i++)
            tmpNode = tmpNode.getNext();

        return tmpNode.getData();
    }

    public Node<T> getNode(int index)
    {
        Node<T> tmpNode = this.head;

        for (int i = 0; i < index; i++)
            tmpNode = tmpNode.getNext();

        return tmpNode;
    }

    @Override
    public T set(int index, T element)
    {
        this.getNode(index).setData(element);

        return null;
    }

    @Override
    public void add(int index, T element)
    {

    }

    @Override
    public T remove(int index)
    {
        return null;
    }

    @Override
    public int indexOf(Object o)
    {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        return null;
    }
}
