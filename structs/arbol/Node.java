/**
 * laft.flyzx@gmail.com
 * @author Luis Angel Farelo Toledo Adivina mi transporte
 */
package structs.arbol;

import java.io.Serializable;

public class Node<T> implements Serializable{

  private static final long serialVersionUID = 1;

  private Node<T> previous;
  private Node<T> next;
  private T data;

  public Node(){
    previous = null;
    next = null;
    data = null;
  }

  public Node(T data){
    this();
    this.data = data;
  }

  public int getAltua(){
    if(previous == null && next == null)
      return 0;
    else{
      if(previous == null)
        return next.getAltua() + 1;
      if(next == null)
        return previous.getAltua() + 1;
      int opc1 = previous.getAltua() + 1;
      int opc2 = next.getAltua() + 1;
      return (opc1 < opc2) ? opc2 : opc1;
    }
  }

  public int getNumNodos(){
    if(previous == null && next == null)
      return 1;
    else{
      if(previous == null)
        return next.getNumNodos() + 1;
      if(next == null)
        return previous.getNumNodos() + 1;
      int opc1 = previous.getNumNodos();
      int opc2 = next.getNumNodos();
      return opc2 + opc1 + 1;
    }
  }

  public Node<T> getPrevious(){
    return previous;
  }

  public Node<T> getNext(){
    return next;
  }

  public T getData(){
    return data;
  }

  public void setPrevious(Node<T> previous){
    this.previous = previous;
  }

  public void setNext(Node<T> next){
    this.next = next;
  }

  public void setData(T data){
    this.data = data;
  }

}
