//Nodo Generico
//Implementacion y retornos de datos correctos
package structs.double_list;

public class Node <T>{

    //Referencia al siguiente elemento
    //o a NULL si es el ultimo
    Node<T> next;
    Node<T> prev;
    T data;

    // Node constructor
    public Node(T dataValue) {
        this.next = null;
        this.prev = null;
        this.data = dataValue;
    }

    // Constructor que incluye el siguiente nodo
    public Node(T dataValue, Node<T> nextValue,Node<T> prevValue){

        this.next = nextValue;
        this.prev = prevValue;
        this.data = dataValue;

    }

    public T getData() {
        return this.data;
    }

    public void setData(T dataValue) {
        this.data = dataValue;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setNext(Node<T> nextValue) {
        this.next = nextValue;
    }

    public void setPrev(Node<T> prevValue) {
        this.prev = prevValue;
    }
}
