package structs.simple_list;

import java.util.*;

public class ListaSimple<T>{
    // Referencia  a el node raiz o la cabeza de la lista.
    private Node head;
    private int listCount;
 
    // constructor
    public ListaSimple() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node(null);
        listCount = 0;
    }
 
    public <T extends Comparable<T>> void add(T data)
    // Agrega el nodo al final de la lista.
    {
        Node Temp = new Node(data);
        Node Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
        // Asignamos el nuevo nodo como "next" 
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }
 
     public Node get(int index)
    // Regresa el nodo en la posicion indicada por index
    {
        if (index <= 0)
            return null;
 
        Node Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }
 
    public boolean remove(int index)
    // remueve el elemento en la posicion indicada
    {
        // 
        if (index < 1 || index > size())
            return false;
        Node Current = head;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        listCount--; // disminuimos el contador de nodos
        return true;
    }

    public <T extends Comparable<T>> boolean addPos(int index, T data)
    // agrega el elemento en la posicion indicada
    {
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data); 
            return true;
        }
        Node Current = head;
        int a=index+1;
        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }
        Node Temp = new Node(data,Current.getNext());
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }


public <T extends Comparable<T>> boolean addOrdenado(T data)
    // agrega el elemento en la posicion indicada
    {
        
        Node Current = head;
        int a=1;
        T data1 = data;
        while(Current.getNext()!=null && 
            data1.compareTo((T) Current.getNext().getData()) > 0) {
             Current = Current.getNext();
            a++;
        }
        return addPos(a,data1);
    }
    
    //Imprimir todos los datos de manera descedente
    public void listUp(){
        Node<T> Current = head.getNext();
        while (Current != null) {
            System.out.println("Elementos : " + Current.getData());
            Current = Current.getNext();
        }
    }
 
    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }
 
    public String toString() {
        Node<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }
  
    public class Node<T> {
        //Referencia al siguiente elemento o a NULL si es el ultimo
        Node next;
        T data;
        // Node constructor
        public Node(T dataValue) {
            next = null;
            data = dataValue;
        }
        // Constructor que incluye el siguiente nodo
        public Node(T dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }
 
        public T getData() {
            return data;
        }
 
        public void setData(T dataValue) {
            data = dataValue;
        }
 
        public Node getNext() {
            return next;
        }
 
        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}