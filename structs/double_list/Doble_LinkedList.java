/*
 *   Lista generica, fase de pruebas para clases
 *   que implementen de Comparable
 *@author Elihu Alejandro Cruz Albores
 *@version 1.6
 */
package structs.double_list;

//import structs.double_list.*;


public class Doble_LinkedList<T extends Comparable<T>>{

    // Referencia  a el Node raiz o la cabeza de la lista.
    private Node <T> head;
    private Node <T> foot;
    private int listCount;

    // constructor
    // Se asigna la cabeza a un nodo nulo y el contador a 0
    public Doble_LinkedList() {
        
        head = new Node<T>(null);
        foot = new Node<T>(null);
        head.setNext(foot);//Asignamos como siguiente elemento
        foot.setPrev(head);//Creamos elemento anterior

        listCount = 0;
    }

    public Node<T> getHead(){
      return this.head;
    }

    public Node<T> getFoot(){
      return this.foot;
    }

    // Agrega el nodo al final de la lista.
    public void add(T data){

        Node<T> Temp = new Node<T>(data);

        Node<T> Current = head;
        // Se tiene que posicionar en la cabeza para poder
        //recorrer la lista y llegar al fin

        while (Current.getNext().getNext() != null) {
            Current = Current.getNext();
        }

        Temp.setPrev(Current);// Asignamos el nuevo nodo como "next"
        Temp.setNext(foot);//Cambiamos le pie de busqueda !!
        Current.setNext(Temp);
        foot.setPrev(Temp);

        listCount++;// incrementamos el contador de nodos
    }

    // Regresa el nodo en la posición indicada por index
    public Node<T> get(int index){
        Node<T> Current;

        if (index <= 0 || index > this.listCount)
            return null;



        //if(index == 1)
          Current = head.getNext();

        //else
          //Current = head.getNext().getNext();

        for (int i = 1; i < index; i++) {
//Provisional
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }

    // Regresa el nodo en la posición indicada por index
    public Node<T> getInverse(int index){

        if (index > size())
            return null;

        Node<T> Current = foot.getPrev();

        for (int i = size(); i < index; i--) {

            if (Current.getPrev() == null)
                return null;
             Current = Current.getPrev();
        }
        return Current;

    }

    // remueve el elemento en la posición indicada
    public boolean remove(int index){
        //
        if (index < 1 || index > size())
            return false;

        Node<T> Current = head;

        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        if(index != 1)
          Current.setPrev(Current.getPrev().getPrev());

        listCount--; // disminuimos el contador de nodos
        return true;
    }

    // agrega el elemento en la posición indicada
    public boolean addPos(int index, T data){
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data);
            return true;
        }

        Node<T> Current = head;

        int a = index + 1;

        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }

        Node<T> Temp = new Node<T>(data,Current.getNext(),Current);
        Current.getNext().setPrev(Temp);//Enlace doble para siguiente
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }

    // agrega el elemento en la posición indicada
    //Ordenacion de menor a mayor para clases genericas con
    //Implentacion de Comparable
    public boolean addOrdenado(T data){

        Node<T> Current = head;

        int a = 1;

        while(Current.getNext()!=null &&
                              data.compareTo(Current.getNext().getData()) > 0) {
             Current = Current.getNext();
            a++;
        }
        return addPos(a,data);
    }

    // returns the number of elements in this list.
    public int size(){return listCount;}

    public String toString() {
        Node<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current =  Current.getNext();
        }
        return output;
    }

}
