package Data.DataStructures;

public class Queue<T> {
    public DoubleNode<T> Beginning;
    public DoubleNode<T> End;

    public Queue(){
        Beginning = null;
        End = null;
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
    public String show (){

        if (isEmpty())
            return "La cola está vacía";
        else {

            StringBuilder content = new StringBuilder();

            DoubleNode<T> temp = Beginning;

            while (temp != null){
                content.append(temp.getData()).append("  ");
                temp = temp.getNext();
            }
            return content.toString();
        }

    }
}
