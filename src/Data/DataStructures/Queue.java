package Data.DataStructures;

public class Queue<T> {
    public DoubleNode<T> Beginning;
    public DoubleNode<T> End;

    public int Count;

    public Queue(){
        Beginning = null;
        End = null;
        Count = 0;
    }

    public boolean isEmpty (){
        return Beginning == null;
    }
    public void push (T data){
        DoubleNode<T> element =  new DoubleNode<>(data, null, null);

        if (isEmpty()){

            Beginning = element;
            End = element;

        }
        else {
            element.setNext(Beginning);

            Beginning = element;

            DoubleNode<T> temp = Beginning;

            temp = temp.getNext();

            temp.setPrevious(Beginning);


        }
        Count++;
    }
    public void pop (){
        DoubleNode<T> temp = End;

        if (temp.getNext() == null && temp.getPrevious() == null){
            Beginning = null;
            End = null;
        }
        else {
            End = End.getPrevious();

            End.setNext(null);
        }
    }
    public List<T> show (){
        List<T> list = new List<>();
        Count--;
        if (isEmpty())
            return  list;
        else {

            DoubleNode<T> temp = Beginning;

            while (temp != null){

                list.insertAtEnd(temp.getData());

                temp = temp.getNext();
            }
            return list;
        }

    }
}
