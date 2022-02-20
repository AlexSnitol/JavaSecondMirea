package ru.mirea.task3;

public class Node<T>
{
    private T data;
    private Node<T> next = null;


    Node() {}

    Node(T data)
    {
        this.data = data;
    }

    public Node<T> getNext()
    {
        return next;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }
}
