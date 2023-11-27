package Data.DataStructures;

public class DoubleNode<T> {

    private T Data;
    private DoubleNode<T> Next;
    private DoubleNode<T> Previous;

    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous) {
        this.Data = data;
        this.Next = next;
        this.Previous = previous;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        this.Data = data;
    }

    public DoubleNode<T> getNext() {
        return Next;
    }

    public void setNext(DoubleNode<T> next) {
        this.Next = next;
    }

    public DoubleNode<T> getPrevious() {
        return Previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.Previous = previous;
    }
}
