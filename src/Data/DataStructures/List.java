package Data.DataStructures;

import Data.Models.User;

import java.lang.reflect.Field;
import java.util.Objects;

public class List <T> {
    public Node<T> Beginning;
    public int Count;

    public List (){
        Beginning = null;
        Count = 0;
    }

    public boolean isEmpty (){

        return Beginning == null;

    }

    public void insertAtBeginning (T data){

        Node<T> newElement;

        if (isEmpty()){

            newElement = new Node<>(data, null);
            Beginning = newElement;

        }
        else {

            newElement = new Node<>(data, null);

            newElement.setNext(Beginning);

            Beginning = newElement;

        }

        Count++;
    }

    public void insertAtEnd (T data){

        Node<T> newElement;

        if (isEmpty()){
            newElement = new Node<>(data, null);
            Beginning = newElement;

        }
        else{
            newElement = new Node<>(data, null);
            Node<T> temp = Beginning;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }

            temp.setNext(newElement);

        }
        Count++;
    }

    public void deleteAtBeginning (){

        Beginning = Beginning.getNext();

        Count--;
    }

    public void deleteAtEnd (){

        if (Beginning.getNext() == null){

            Beginning = null;

            Count--;

            return;
        }

        Node<T> temp = Beginning;

        Node<T> previousTemp = null;

        while (temp.getNext() != null){

            previousTemp = temp;

            temp = temp.getNext();

        }

        previousTemp.setNext(null);

        Count--;
    }

    public void delete(T data) throws  Exception {
        if (isEmpty()){
            throw new Exception("List is empty");
        }

        Node<T> temp;
        Node<T> previous;

        temp = Beginning;
        previous = null;

        if (temp != null && temp.getData() == data ){
            Beginning = temp.getNext();

            return;
        }



        while (temp != null){

            if (temp.getData() == data){
                previous.setNext(temp.getNext());

                return;
            }
            previous = temp;
            temp = temp.getNext();

        }
    }

    public void set (int index, T data)  throws Exception {

        if (isEmpty()){
            throw new Exception("List is empty");
        }

        if (index < 0 || index >= Count){
            throw new Exception("Out of index bounds");
        }

        Node<T> temp;

        temp = Beginning;

        int position = 0;

        while (position != index){
            temp = temp.getNext();
            position ++;
        }

        temp.setData(data);
    }

    public T getItemAtIndex (int index) throws Exception{

        Node<T> temp;

        if (isEmpty()){
            throw new Exception("List is empty");
        }

        if (index < 0 || index >= Count){
            throw new Exception("Out of index bounds");
        }

        temp = Beginning;
        int position = 0;

        while (position != index){
            temp = temp.getNext();
            position ++;
        }

        return (T) temp.getData();
    }

    public int indexOf(T data) throws Exception{

        Node<T> temp;

        if (isEmpty()){
            throw  new Exception("List is empty");
        }

        temp = Beginning;
        int position = 0;
        while (temp != null){

            if (temp.getData() == data){
                return position;
            }
            temp = temp.getNext();
            position++;
        }
        return -1;
    }

    public T findById(long id) throws Exception{
        Node<T> temp;

        if (isEmpty()){
            throw  new Exception("List is empty");
        }

        temp = Beginning;
        int position = 0;
        while (temp != null){

            Object data = (Object) temp.getData();

            Field idField = data.getClass().getDeclaredField("Id");

            idField.setAccessible(true);

            long idValue = (long)idField.get(data);

            if ( idValue == id){
                return temp.getData();
            }
            temp = temp.getNext();
            position++;
        }
        throw new Exception("Element not found");
    }
    //This only works for User Entity
    public T findByUserName(String name) throws Exception{
        Node<T> temp;


        if (isEmpty()){
            throw  new Exception("List is empty");
        }

        temp = Beginning;
        int position = 0;
        while (temp != null){

            Object data = (Object) temp.getData();

            Field nameField = data.getClass().getDeclaredField("UserName");

            nameField.setAccessible(true);

            String nameValue = (String)nameField.get(data);

            if (Objects.equals(nameValue, name)){
                return temp.getData();
            }
            temp = temp.getNext();
            position++;
        }
        throw new Exception("Element not found");
    }
}