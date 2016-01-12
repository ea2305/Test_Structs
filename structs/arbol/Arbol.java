/**
 * laft.flyzx@gmail.com
 * @author Luis Angel Farelo Toledo Adivina mi transporte
 */
package structs.arbol;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Arbol<T extends Comparable<T>> implements Serializable{

  private static final long serialVersionUID = 1;
  private Node<T> raiz;

  public Arbol(){
    raiz = null;
  }

  public Node<T> getRaiz(){
    return raiz;
  }


  public void insertar(T data){
    Node<T> nuevo = new Node<T>(data);
    if(raiz == null) raiz = nuevo;
    else{
      Node<T> anterior = null, reco;
      reco = raiz;
      while(reco != null){
        anterior = reco;
        if(data.compareTo(reco.getData()) < 0)
          reco = reco.getPrevious();
        else reco = reco.getNext();
      }
      if(data.compareTo(anterior.getData()) < 0)
        anterior.setPrevious(nuevo);
      else anterior.setNext(nuevo);
    }
  }

  private void inOrder(Node<T> raiz, List<T> lst){
      if (raiz != null) {
          inOrder(raiz.getPrevious(), lst);
          lst.add(raiz.getData());
          inOrder(raiz.getNext(), lst);
      }
  }

  public List<T> inOrderList(){
      List<T> lst = new ArrayList<>();
      inOrder(raiz, lst);
      return lst;
  }

  public void limpiar(){
    raiz = null;
  }

  public String toString(){
    List<T> lst = inOrderList();
    return lst.toString();
  }

}
